package com.zhonghui.carbonReport.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.zhonghui.common.utils.DateUtils;
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
import com.zhonghui.common.core.domain.AjaxResult;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.carbonReport.domain.ViewMesProductPowerDetails;
import com.zhonghui.carbonReport.service.IViewMesProductPowerDetailsService;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.common.core.page.TableDataInfo;

/**
 * 生产能耗报表Controller
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@Api(tags="智造双碳-生产能耗报表")
@RestController
@RequestMapping("/carbonReport/productPowerDetails")
public class ViewMesProductPowerDetailsController extends BaseReportController
{
    @Autowired
    private IViewMesProductPowerDetailsService viewMesProductPowerDetailsService;

    @Autowired
    private IDcNeutralityCalculationRatioService dcNeutralityCalculationRatioService;

    /**
     * 查询生产能耗报表列表
     */
    @ApiOperation("查询生产能耗报表列表")
    @GetMapping("/list")
    public TableDataInfo<List<ViewMesProductPowerDetails>> list(ViewMesProductPowerDetails viewMesProductPowerDetails)
    {
        startPage();
        List<ViewMesProductPowerDetails> list = viewMesProductPowerDetailsService.selectViewMesProductPowerDetailsList(viewMesProductPowerDetails);
        // 获取碳中和耗电计算比例
        double electricCo2 = dcNeutralityCalculationRatioService.getElectricCo2();
        list.stream().forEach(power -> {
            try {
                // 单位碳排放
                double carbon = power.getUnitPowerConsumption() * electricCo2;
                // 计算碳排放总量
                double totalCarbonEmission = power.getTotalPowerConsume() * electricCo2;
                power.setCarbonEmission(carbon);
                power.setTotalCarbonEmission(totalCarbonEmission);
            }catch (Exception ex) {
                logger.error(ex.getMessage(),ex);
            }

        });
        return getDataTable(list);
    }

    /**
     * 查询生产能耗月度报表
     */
    @GetMapping("/month")
    @ApiOperation("查询生产能耗月度报表")
    public TableDataInfo reportByMonth(ViewMesProductPowerDetails viewMesProductPowerDetails) {
        startPage();
        Object end = viewMesProductPowerDetails.getParams().get("endManufactureDate");
        Object start = viewMesProductPowerDetails.getParams().get("beginManufactureDate");
        Date now = DateUtil.date();
        if (StrUtil.isEmptyIfStr(start)) {
            // 默认查询本月第一天
            Date first = DateUtil.beginOfMonth(now);
            viewMesProductPowerDetails.getParams().put("beginManufactureDate", DateUtils.dateTime(first));
        }
        if (!StrUtil.isEmptyIfStr(end)) {
            // 将查询条件的结束月份转化为该月的最后一天
            Date date = DateUtils.parseDate(end);
            if (now.compareTo(date) < 0) {
                date = now;
            }
            Date last = DateUtil.endOfMonth(date);
            viewMesProductPowerDetails.getParams().put("endManufactureDate", DateUtils.dateTime(last));
        } else {
            // 默认查询本月最后一天
            Date last = DateUtil.endOfMonth(now);
            viewMesProductPowerDetails.getParams().put("endManufactureDate", DateUtils.dateTime(last));
        }
        List<ViewMesProductPowerDetails> list = viewMesProductPowerDetailsService
                .selectProductPowerReportByMonth(viewMesProductPowerDetails);
        // 获取碳中和耗电计算比例
        double pwRatio = dcNeutralityCalculationRatioService.getElectricCo2();
        double waterRatio = dcNeutralityCalculationRatioService.getWaterCo2();
        list.stream().forEach(power -> {
            String yearMonth = power.getProductMonth();
            // 获取该月份生产节电量
            double prdSave = mockPrdPowerSaveByMonth(yearMonth);
            power.setTotalProductPowerSave(prdSave);
            // 获取该月份办公节电量
            double officeSave = mockOfficePowerSaveByMonth(yearMonth);
            power.setTotalOfficePowerSave(officeSave);

            // 获取生产用水月数据
            double totalWaterConsume = this.mockPrdWaterConsumeByMonth(yearMonth);
            double totalWaterEmission = totalWaterConsume * waterRatio;
            power.setTotalWaterConsume(totalWaterConsume);

            // 获取办公用水月数据
            double totalOfficeWaterConsume = this.mockOfficeWaterConsumeByMonth(yearMonth);
            double totalOfficeWaterEmission = totalOfficeWaterConsume * waterRatio;
            power.setTotalOfficeWaterConsume(totalOfficeWaterConsume);

            // 获取办公用电月数据
            double totalOfficePowerConsume = this.mockOfficePowerConsumeByMonth(yearMonth);
            double totalOfficePowerEmission = totalOfficePowerConsume * pwRatio;
            power.setTotalOfficePowerConsume(totalOfficePowerConsume);

            // 计算碳排放总量
            double prdPowerConsume = power.getTotalPowerConsume() == null ? 0 : power.getTotalPowerConsume();
            double totalCarbonEmission = prdPowerConsume * pwRatio;
            power.setTotalCarbonEmission(
                    totalCarbonEmission + totalWaterEmission + totalOfficeWaterEmission + totalOfficePowerEmission);
            // 计算减少碳排放总量
            double totalCarbonSave = (power.getTotalProductPowerSave() + power.getTotalOfficePowerSave()) * pwRatio;
            power.setTotalCarbonSave(totalCarbonSave);
        });
        return getDataTable(list);
    }

    /**
     * 查询生产能耗年度报表
     */
    @ApiOperation("查询生产能耗年度报表")
    @GetMapping("/year")
    public TableDataInfo reportByYear(ViewMesProductPowerDetails viewMesProductPowerDetails) {
        Object end = viewMesProductPowerDetails.getParams().get("endManufactureDate");
        Object start = viewMesProductPowerDetails.getParams().get("beginManufactureDate");
        Date now = DateUtil.date();
        if (StrUtil.isEmptyIfStr(start)) {
            // 默认查询今年第一天数据
            Date first = DateUtil.beginOfYear(new Date());
            viewMesProductPowerDetails.getParams().put("beginManufactureDate", DateUtils.dateTime(first));
        }
        if (!StrUtil.isEmptyIfStr(end)) {
            // 将查询条件的结束月份转化为该年的最后一天
            Date date = DateUtils.parseDate(end);
            if (now.compareTo(date) < 0) {
                date = now;
            }
            Date last = DateUtil.endOfYear(date);
            viewMesProductPowerDetails.getParams().put("endManufactureDate", DateUtils.dateTime(last));
        } else {
            // 默认查询今年最后一天数据
            Date last = DateUtil.endOfYear(new Date());
            viewMesProductPowerDetails.getParams().put("endManufactureDate", DateUtils.dateTime(last));
        }
        // 获取统计的月份
        List<ViewMesProductPowerDetails> monthList = viewMesProductPowerDetailsService
                .selectReportMonth(viewMesProductPowerDetails);
        List<String> reportMonthList = monthList.stream().map(month -> month.getProductMonth())
                .collect(Collectors.toList());
        // 产生模拟月份数据
        reportMonthList.stream().forEach(month -> {
            mockPrdPowerSaveByMonth(month);
            mockOfficePowerSaveByMonth(month);
        });
        startPage();
        List<ViewMesProductPowerDetails> list = viewMesProductPowerDetailsService
                .selectProductPowerReportByYear(viewMesProductPowerDetails);
        // 获取碳中和耗电计算比例
        double pwRatio = dcNeutralityCalculationRatioService.getElectricCo2();
        double waterRatio = dcNeutralityCalculationRatioService.getWaterCo2();
        list.stream().forEach(power -> {
            String year = power.getProductYear();
            // 获取该年生产节电数据
            double prdSaveTotal = mockPrdPowerSaveByYear(year);
            power.setTotalProductPowerSave(prdSaveTotal);

            // 获取该年办公节电数据
            double officeSaveTotal = mockOfficePowerSaveByYear(year);
            power.setTotalOfficePowerSave(officeSaveTotal);

            // 获取生产用水年数据
            double totalWaterConsume = this.mockPrdWaterConsumeByYear(year);
            double totalWaterEmission = totalWaterConsume * waterRatio;
            power.setTotalWaterConsume(totalWaterConsume);

            // 获取办公用水年数据
            double totalOfficeWaterConsume = this.mockOfficeWaterConsumeByYear(year);
            double totalOfficeWaterEmission = totalOfficeWaterConsume * waterRatio;
            power.setTotalOfficeWaterConsume(totalOfficeWaterConsume);

            // 获取办公用电年数据
            double totalOfficePowerConsume = this.mockOfficePowerConsumeByYear(year);
            double totalOfficePowerEmission = totalOfficePowerConsume * pwRatio;
            power.setTotalOfficePowerConsume(totalOfficePowerConsume);

            // 计算碳排放总量
            double prdPowerConsume = power.getTotalPowerConsume() == null ? 0 : power.getTotalPowerConsume();
            double totalCarbonEmission = prdPowerConsume * pwRatio;
            power.setTotalCarbonEmission(
                    totalCarbonEmission + totalWaterEmission + totalOfficeWaterEmission + totalOfficePowerEmission);
            // 计算减少碳排放总量
            double totalCarbonSave = (power.getTotalProductPowerSave() + power.getTotalOfficePowerSave()) * pwRatio;
            power.setTotalCarbonSave(totalCarbonSave);
        });
        return getDataTable(list);
    }

    /**
     * 查询生产能耗日报表
     */
    @ApiOperation("查询生产能耗日报表")
    @GetMapping("/day")
    public TableDataInfo reportByDay(ViewMesProductPowerDetails viewMesProductPowerDetails) {
        startPage();
        // 默认查询今天数据
        if (viewMesProductPowerDetails.getManufactureDate() == null) {
            Date today = DateUtil.parse(DateUtil.today());
            viewMesProductPowerDetails.setManufactureDate(today);
        }
        List<ViewMesProductPowerDetails> list = viewMesProductPowerDetailsService
                .selectProductPowerReportByDay(viewMesProductPowerDetails);
        // 获取碳中和耗电计算比例
        double pwRatio = dcNeutralityCalculationRatioService.getElectricCo2();
        double waterRatio = dcNeutralityCalculationRatioService.getWaterCo2();
        list.stream().forEach(power -> {
            int days = DateUtil.dayOfMonth(DateUtil.endOfMonth(power.getManufactureDate()));
            String yearMonth = DateUtil.format(power.getManufactureDate(), "yyyy-MM");
            // 获取生产用水月数据
            double totalWaterConsume = this.mockPrdWaterConsumeByMonth(yearMonth);
            double totalWaterEmission = totalWaterConsume * waterRatio;
            totalWaterEmission = mockDaysEmission(days, totalWaterEmission, 3);
            power.setTotalWaterConsume(totalWaterConsume);

            // 获取办公用水月数据
            double totalOfficeWaterConsume = this.mockOfficeWaterConsumeByMonth(yearMonth);
            double totalOfficeWaterEmission = totalOfficeWaterConsume * waterRatio;
            totalOfficeWaterEmission = mockDaysEmission(days, totalOfficeWaterEmission, 4);
            power.setTotalOfficeWaterConsume(totalOfficeWaterConsume);

            // 获取办公用电月数据
            double totalOfficePowerConsume = this.mockOfficePowerConsumeByMonth(yearMonth);
            double totalOfficePowerEmission = totalOfficePowerConsume * pwRatio;
            totalOfficePowerEmission = mockDaysEmission(days, totalOfficePowerEmission, 2);
            power.setTotalOfficePowerConsume(totalOfficePowerConsume);

            // 计算碳排放总量
            double prdPowerConsume = power.getTotalPowerConsume() == null ? 0 : power.getTotalPowerConsume();
            double totalCarbonEmission = prdPowerConsume * pwRatio;
            power.setTotalCarbonEmission(Math.floor(totalCarbonEmission + totalWaterEmission + totalOfficeWaterEmission + totalOfficePowerEmission));
        });
        return getDataTable(list);
    }

    /**
     * 导出生产能耗报表列表
     */
    @ApiOperation("导出生产能耗报表列表")
    @Log(title = "产品能耗报表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ViewMesProductPowerDetails viewMesProductPowerDetails)
    {
        List<ViewMesProductPowerDetails> list = viewMesProductPowerDetailsService.selectViewMesProductPowerDetailsList(viewMesProductPowerDetails);
        ExcelUtil<ViewMesProductPowerDetails> util = new ExcelUtil<ViewMesProductPowerDetails>(ViewMesProductPowerDetails.class);
        util.exportExcel(response, list, "产品能耗报表数据");
    }

    /**
     * 获取生产能耗报表详细信息
     */
    @ApiOperation("获取生产能耗报表详细信息")
    @GetMapping(value = "/{productionPlanId}")
    public BaseResult<ViewMesProductPowerDetails> getInfo(@PathVariable("productionPlanId") Long productionPlanId)
    {
        return BaseResult.success(viewMesProductPowerDetailsService.selectViewMesProductPowerDetailsByFactoryId(productionPlanId));
    }
}
