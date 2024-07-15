package com.zhonghui.mes.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.mes.domain.MesDeviceInformation;
import com.zhonghui.mes.service.IMesDeviceInformationService;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.common.core.page.TableDataInfo;

/**
 * 设备信息Controller
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
@Api(tags="制造执行MES-设备信息")
@RestController
@RequestMapping("/mes/information")
public class MesDeviceInformationController extends BaseController
{
    @Autowired
    private IMesDeviceInformationService mesDeviceInformationService;

    /**
     * 查询设备信息列表
     */
    @ApiOperation("查询设备信息列表")
    @GetMapping("/list")
    public TableDataInfo<List<MesDeviceInformation>> list(MesDeviceInformation mesDeviceInformation)
    {
        startPage();
        List<MesDeviceInformation> list = mesDeviceInformationService.selectMesDeviceInformationList(mesDeviceInformation);
        return getDataTable(list);
    }

    /**
     * 查询设备信息列表（不分页）
     */
    @ApiOperation("查询设备信息列表（不分页）")
    @GetMapping("/deviceList")
    public BaseResult<List<MesDeviceInformation>> deviceList(MesDeviceInformation mesDeviceInformation)
    {
        return BaseResult.success(mesDeviceInformationService.selectMesDeviceInformationList(mesDeviceInformation));
    }

    /**
     * 导出设备信息列表
     */
    @ApiOperation("导出设备信息列表")
    @Log(title = "设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesDeviceInformation mesDeviceInformation)
    {
        List<MesDeviceInformation> list = mesDeviceInformationService.selectMesDeviceInformationList(mesDeviceInformation);
        ExcelUtil<MesDeviceInformation> util = new ExcelUtil<MesDeviceInformation>(MesDeviceInformation.class);
        util.exportExcel(response, list, "设备信息数据");
    }

    /**
     * 获取设备信息详细信息
     */
    @ApiOperation("获取设备信息详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult<MesDeviceInformation> getInfo(@PathVariable("id") Integer id)
    {
        return BaseResult.success(mesDeviceInformationService.selectMesDeviceInformationById(id));
    }

    /**
     * 新增设备信息
     */
    @ApiOperation("新增设备信息")
    @Log(title = "设备信息", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult<Integer> add(@RequestBody MesDeviceInformation mesDeviceInformation)
    {
        return BaseResult.success(mesDeviceInformationService.insertMesDeviceInformation(mesDeviceInformation));
    }

    /**
     * 修改设备信息
     */
    @ApiOperation("修改设备信息")
    @Log(title = "设备信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult<Integer> edit(@RequestBody MesDeviceInformation mesDeviceInformation)
    {
        return BaseResult.success(mesDeviceInformationService.updateMesDeviceInformation(mesDeviceInformation));
    }

    /**
     * 删除设备信息
     */
    @ApiOperation("删除设备信息")
    @Log(title = "设备信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult<Integer> remove(@PathVariable Integer[] ids)
    {
        return BaseResult.success(mesDeviceInformationService.deleteMesDeviceInformationByIds(ids));
    }
}
