package com.zhonghui.procurementManagement.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.procurementManagement.domain.PmPoliciesRegulations;
import com.zhonghui.procurementManagement.service.IPmPoliciesRegulationsService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 政策法规Controller
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Api(tags="采购管理系统-后台-政策法规")
@RestController
@RequestMapping("/procurementManagement/PoliciesRegulations")
public class PmPoliciesRegulationsController extends BaseController
{
    @Autowired
    private IPmPoliciesRegulationsService pmPoliciesRegulationsService;

    /**
     * 查询政策法规列表
     */
    @ApiOperation("查询政策法规列表")
    @GetMapping("/list")
    public TableDataInfo<List<PmPoliciesRegulations>> list(PmPoliciesRegulations pmPoliciesRegulations)
    {
        startPage();
        List<PmPoliciesRegulations> list = pmPoliciesRegulationsService.selectPmPoliciesRegulationsList(pmPoliciesRegulations);
        return getDataTable(list);
    }

    /**
     * 获取政策法规详细信息
     */
    @ApiOperation("获取政策法规详细信息")
    @GetMapping(value = "/{listId}")
    public BaseResult<PmPoliciesRegulations> getInfo(@PathVariable("listId") Integer listId)
    {
        return BaseResult.success(pmPoliciesRegulationsService.selectPmPoliciesRegulationsByListId(listId));
    }

    /**
     * 新增政策法规
     */
    @ApiOperation("新增政策法规")
    @Log(title = "政策法规", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult<Integer> add(@RequestBody PmPoliciesRegulations pmPoliciesRegulations)
    {
        return BaseResult.success(pmPoliciesRegulationsService.insertPmPoliciesRegulations(pmPoliciesRegulations));
    }

    /**
     * 修改政策法规
     */
    @ApiOperation("修改政策法规")
    @Log(title = "政策法规", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult<Integer> edit(@RequestBody PmPoliciesRegulations pmPoliciesRegulations)
    {
        return BaseResult.success(pmPoliciesRegulationsService.updatePmPoliciesRegulations(pmPoliciesRegulations));
    }

    /**
     * 删除政策法规
     */
    @ApiOperation("删除政策法规")
    @Log(title = "政策法规", businessType = BusinessType.DELETE)
	@DeleteMapping("/{listIds}")
    public BaseResult<Integer> remove(@PathVariable Integer[] listIds)
    {
        return BaseResult.success(pmPoliciesRegulationsService.deletePmPoliciesRegulationsByListIds(listIds));
    }
}
