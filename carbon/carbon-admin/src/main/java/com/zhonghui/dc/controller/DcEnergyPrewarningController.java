package com.zhonghui.dc.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.zhonghui.common.core.domain.AjaxResult;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.dc.domain.DcEnergyPrewarning;
import com.zhonghui.dc.service.IDcEnergyPrewarningService;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.common.core.page.TableDataInfo;

/**
 * 智造双碳-能效预警Controller
 * 
 * @author zhonghui
 * @date 2022-05-24
 */
@Api(tags="智造双碳—能效预警")
@RestController
@RequestMapping("/dc/prewarning")
public class DcEnergyPrewarningController extends BaseController
{
    @Autowired
    private IDcEnergyPrewarningService dcEnergyPrewarningService;

    /**
     * 查询智造双碳-能效预警列表
     */
    @ApiOperation("查询智造双碳-能效预警列表")
    @GetMapping("/list")
    public TableDataInfo<List<DcEnergyPrewarning>> list(DcEnergyPrewarning dcEnergyPrewarning)
    {
        startPage();
        List<DcEnergyPrewarning> list = dcEnergyPrewarningService.selectDcEnergyPrewarningList(dcEnergyPrewarning);
        return getDataTable(list);
    }

    /**
     * 导出智造双碳-能效预警列表
     */
    @ApiOperation("导出智造双碳-能效预警列表")
    @Log(title = "智造双碳-能效预警", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DcEnergyPrewarning dcEnergyPrewarning)
    {
        List<DcEnergyPrewarning> list = dcEnergyPrewarningService.selectDcEnergyPrewarningList(dcEnergyPrewarning);
        ExcelUtil<DcEnergyPrewarning> util = new ExcelUtil<DcEnergyPrewarning>(DcEnergyPrewarning.class);
        util.exportExcel(response, list, "智造双碳-能效预警数据");
    }

    /**
     * 获取智造双碳-能效预警详细信息
     */
    @ApiOperation("获取智造双碳-能效预警详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult<DcEnergyPrewarning> getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(dcEnergyPrewarningService.selectDcEnergyPrewarningById(id));
    }

    /**
     * 新增智造双碳-能效预警
     */
    @ApiOperation("新增智造双碳-能效预警")
    @Log(title = "智造双碳-能效预警", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult<Integer> add(@RequestBody DcEnergyPrewarning dcEnergyPrewarning)
    {
        return BaseResult.success(dcEnergyPrewarningService.insertDcEnergyPrewarning(dcEnergyPrewarning));
    }

    /**
     * 修改智造双碳-能效预警
     */
    @ApiOperation("修改智造双碳-能效预警")
    @Log(title = "智造双碳-能效预警", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult<Integer> edit(@RequestBody DcEnergyPrewarning dcEnergyPrewarning)
    {
        return BaseResult.success(dcEnergyPrewarningService.updateDcEnergyPrewarning(dcEnergyPrewarning));
    }

    /**
     * 删除智造双碳-能效预警
     */
    @ApiOperation("删除智造双碳-能效预警")
    @Log(title = "智造双碳-能效预警", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult<Integer> remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(dcEnergyPrewarningService.deleteDcEnergyPrewarningByIds(ids));
    }
}
