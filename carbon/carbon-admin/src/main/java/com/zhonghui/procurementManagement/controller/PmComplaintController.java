package com.zhonghui.procurementManagement.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.procurementManagement.domain.PmComplaint;
import com.zhonghui.procurementManagement.service.IPmComplaintService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 投诉Controller
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Api(tags="采购管理系统-后台-投诉")
@RestController
@RequestMapping("/procurementManagement/complaint")
public class PmComplaintController extends BaseController
{
    @Autowired
    private IPmComplaintService pmComplaintService;

    /**
     * 查询投诉列表
     */
    @ApiOperation("查询投诉列表")
    @GetMapping("/list")
    public TableDataInfo<List<PmComplaint>> list(PmComplaint pmComplaint)
    {
        startPage();
        List<PmComplaint> list = pmComplaintService.selectPmComplaintList(pmComplaint);
        return getDataTable(list);
    }

    /**
     * 导出投诉列表
     */
    @ApiOperation("导出投诉列表")
    @Log(title = "采购—投诉", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmComplaint pmComplaint)
    {
        List<PmComplaint> list = pmComplaintService.selectPmComplaintList(pmComplaint);
        ExcelUtil<PmComplaint> util = new ExcelUtil<PmComplaint>(PmComplaint.class);
        util.exportExcel(response, list, "采购—投诉数据");
    }

    /**
     * 获取投诉详细信息
     */
    @ApiOperation("获取投诉详细信息")
    @GetMapping(value = "/{complaintId}")
    public BaseResult<PmComplaint> getInfo(@PathVariable("complaintId") Long complaintId)
    {
        return BaseResult.success(pmComplaintService.selectPmComplaintByComplaintId(complaintId));
    }

    /**
     * 新增投诉
     */
    @ApiOperation("新增投诉")
    @Log(title = "采购—投诉", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult<Integer> add(@RequestBody PmComplaint pmComplaint)
    {
        return BaseResult.success(pmComplaintService.insertPmComplaint(pmComplaint));
    }

    /**
     * 修改投诉
     */
    @ApiOperation("修改投诉")
    @Log(title = "采购—投诉", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult<Integer> edit(@RequestBody PmComplaint pmComplaint)
    {
        return BaseResult.success(pmComplaintService.updatePmComplaint(pmComplaint));
    }

    /**
     * 删除投诉
     */
    @ApiOperation("删除投诉")
    @Log(title = "采购—投诉", businessType = BusinessType.DELETE)
	@DeleteMapping("/{complaintIds}")
    public BaseResult<Integer> remove(@PathVariable Long[] complaintIds)
    {
        return BaseResult.success(pmComplaintService.deletePmComplaintByComplaintIds(complaintIds));
    }
}
