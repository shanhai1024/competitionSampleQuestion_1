package com.zhonghui.carbonReport.controller;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import com.zhonghui.dc.service.IDcNeutralityCalculationRatioService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.domain.AjaxResult;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.carbonReport.domain.ViewMesDevicePowerDetails;
import com.zhonghui.carbonReport.service.IViewMesDevicePowerDetailsService;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.common.core.page.TableDataInfo;

/**
 * 设备能耗数据采集Controller
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@Api(tags="智造双碳-设备能耗数据采集")
@RestController
@RequestMapping("/carbonReport/devicePowerDetails")
public class ViewMesDevicePowerDetailsController extends BaseController
{
    @Autowired
    private IViewMesDevicePowerDetailsService viewMesDevicePowerDetailsService;

    @Autowired
    private IDcNeutralityCalculationRatioService dcNeutralityCalculationRatioService;

    /**
     * 查询设备能耗汇总报表
     */
    @ApiOperation("查询设备能耗数据采集报表")
    @GetMapping("/list")
    public TableDataInfo<List<ViewMesDevicePowerDetails>> list(ViewMesDevicePowerDetails viewMesDevicePowerDetails)
    {
        startPage();
        List<ViewMesDevicePowerDetails> list = viewMesDevicePowerDetailsService.selectViewMesDevicePowerDetailsList(viewMesDevicePowerDetails);
        // 获取碳中和耗电计算比例
        double electricCo2 = dcNeutralityCalculationRatioService.getElectricCo2();
        // 计算单位碳排放和总碳排放
        list.stream().forEach(power -> {
            // 单位碳排放
            double carbon = power.getUnitPowerConsumption() == null ? 0 : power.getUnitPowerConsumption() * electricCo2;
            // 总碳排放
            double totalCarbon = power.getTotalPowerConsume() == null ? 0 : power.getTotalPowerConsume() * electricCo2;
            power.setCarbonEmission(carbon);
            power.setTotalCarbonEmission(totalCarbon);
        });
        return getDataTable(list);
    }

    /**
     * 查询设备日能耗报表
     */
    @ApiOperation("查询设备日能耗报表")
    @GetMapping("/day")
    public TableDataInfo reportByDay(ViewMesDevicePowerDetails viewMesDevicePowerDetails)
    {
        startPage();
        List<ViewMesDevicePowerDetails> list = viewMesDevicePowerDetailsService.selectDevicePowerReportByDay(viewMesDevicePowerDetails);
        // 获取碳中和耗电计算比例
        double electricCo2 = dcNeutralityCalculationRatioService.getElectricCo2();
        // 计算单位碳排放和总碳排放
        list.stream().forEach(power -> {
            // 单位碳排放
            double carbon = power.getUnitPowerConsumption() == null ? 0 : power.getUnitPowerConsumption() * electricCo2;
            // 总碳排放
            double totalCarbon = power.getTotalPowerConsume() == null ? 0 : power.getTotalPowerConsume() * electricCo2;
            power.setCarbonEmission(carbon);
            power.setTotalCarbonEmission(totalCarbon);
        });
        return getDataTable(list);
    }

    /**
     * 查询设备小时能耗报表
     */
    @ApiOperation("查询设备小时能耗报表")
    @GetMapping("/hour")
    public TableDataInfo reportByHour(ViewMesDevicePowerDetails viewMesDevicePowerDetails)
    {
        List<ViewMesDevicePowerDetails> hourList = new ArrayList<ViewMesDevicePowerDetails>();
        Date date = viewMesDevicePowerDetails.getManufactureDate();
        String today = DateUtil.today();
        Date now = DateUtil.parse(today);
        // 查询日期为空默认查询前一天数据
        if (date != null) {
            // 当天以及未来数据不采集
            if (date.compareTo(now) >= 0) {
                return getDataTable(hourList);
            }
        } else {
            Date yesterday = DateUtil.offset(DateUtil.parse(today), DateField.DAY_OF_MONTH, -1);
            viewMesDevicePowerDetails.setManufactureDate(yesterday);
        }
        List<ViewMesDevicePowerDetails> list = viewMesDevicePowerDetailsService.selectDevicePowerReportByDay(viewMesDevicePowerDetails);
        // 获取碳中和耗电计算比例
        double electricCo2 = dcNeutralityCalculationRatioService.getElectricCo2();
        for (ViewMesDevicePowerDetails dayPower : list) {
            // 模拟小时能耗数据
            Double totalPowerConsume = dayPower.getTotalPowerConsume();
            for (int i = 0; i < 24; i++) {
                ViewMesDevicePowerDetails hourPower = new ViewMesDevicePowerDetails();
                BeanUtil.copyProperties(dayPower, hourPower);
                hourPower.setHour(String.valueOf(i + 1));
                double hourConsume = RandomUtil.randomDouble(0, totalPowerConsume / 24, 2, RoundingMode.FLOOR);
                hourPower.setTotalPowerConsume(hourConsume);
                hourPower.setCarbonEmission(NumberUtil.round(hourConsume * electricCo2, 2).doubleValue());
                hourList.add(hourPower);
            }
        }
        return getDataTable(hourList);
    }

    /**
     * 导出设备能耗数据采集列表
     */
    @ApiOperation("导出设备能耗数据采集列表")
    @Log(title = "设备能耗数据采集", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ViewMesDevicePowerDetails viewMesDevicePowerDetails)
    {
        List<ViewMesDevicePowerDetails> list = viewMesDevicePowerDetailsService.selectViewMesDevicePowerDetailsList(viewMesDevicePowerDetails);
        // 获取碳中和耗电计算比例
        double electricCo2 = dcNeutralityCalculationRatioService.getElectricCo2();
        // 计算单位碳排放和总碳排放
        list.stream().forEach(power -> {
            // 单位碳排放
            double carbon = power.getUnitPowerConsumption() * electricCo2;
            // 总碳排放
            double totalCarbon = power.getTotalPowerConsume() * electricCo2;
            power.setCarbonEmission(carbon);
            power.setTotalCarbonEmission(totalCarbon);
        });
        ExcelUtil<ViewMesDevicePowerDetails> util = new ExcelUtil<ViewMesDevicePowerDetails>(ViewMesDevicePowerDetails.class);
        util.exportExcel(response, list, "设备能耗数据采集数据");
    }

    /**
     * 获取设备能耗数据采集详细信息
     */
    @ApiOperation("获取设备能耗数据采集详细信息")
    @GetMapping(value = "/{deviceId}")
    public BaseResult<ViewMesDevicePowerDetails> getInfo(@PathVariable("deviceId") Long deviceId)
    {
        return BaseResult.success(viewMesDevicePowerDetailsService.selectViewMesDevicePowerDetailsByDeviceId(deviceId));
    }
}
