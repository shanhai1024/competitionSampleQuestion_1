package com.zhonghui.procurementManagement.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.procurementManagement.domain.PmPlatformDynamics;
import com.zhonghui.procurementManagement.service.IPmPlatformDynamicsService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 平台动态Controller
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Api(tags="采购管理系统-后台-平台动态")
@RestController
@RequestMapping("/procurementManagement/platformDynamics")
public class PmPlatformDynamicsController extends BaseController
{
    @Autowired
    private IPmPlatformDynamicsService pmPlatformDynamicsService;

    /**
     * 查询平台动态列表
     */
    @ApiOperation("查询平台动态列表")
    @GetMapping("/list")
    public TableDataInfo<List<PmPlatformDynamics>> list(PmPlatformDynamics pmPlatformDynamics)
    {
        startPage();
        List<PmPlatformDynamics> list = pmPlatformDynamicsService.selectPmPlatformDynamicsList(pmPlatformDynamics);
        return getDataTable(list);
    }

    /**
     * 导出平台动态列表
     */
    @ApiOperation("导出平台动态列表")
    @Log(title = "平台动态", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmPlatformDynamics pmPlatformDynamics)
    {
        List<PmPlatformDynamics> list = pmPlatformDynamicsService.selectPmPlatformDynamicsList(pmPlatformDynamics);
        ExcelUtil<PmPlatformDynamics> util = new ExcelUtil<PmPlatformDynamics>(PmPlatformDynamics.class);
        util.exportExcel(response, list, "平台动态数据");
    }

    /**
     * 获取平台动态详细信息
     */
    @ApiOperation("获取平台动态详细信息")
    @GetMapping(value = "/{listId}")
    public BaseResult<PmPlatformDynamics> getInfo(@PathVariable("listId") Long listId)
    {
        return BaseResult.success(pmPlatformDynamicsService.selectPmPlatformDynamicsByListId(listId));
    }

    /**
     * 新增平台动态
     */
    @ApiOperation("新增平台动态")
    @Log(title = "平台动态", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult<Integer> add(@RequestBody PmPlatformDynamics pmPlatformDynamics)
    {
        return BaseResult.success(pmPlatformDynamicsService.insertPmPlatformDynamics(pmPlatformDynamics));
    }

    /**
     * 修改平台动态
     */
    @ApiOperation("修改平台动态")
    @Log(title = "平台动态", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult<Integer> edit(@RequestBody PmPlatformDynamics pmPlatformDynamics)
    {
        return BaseResult.success(pmPlatformDynamicsService.updatePmPlatformDynamics(pmPlatformDynamics));
    }

    /**
     * 删除平台动态
     */
    @ApiOperation("删除平台动态")
    @Log(title = "平台动态", businessType = BusinessType.DELETE)
	@DeleteMapping("/{listIds}")
    public BaseResult<Integer> remove(@PathVariable Long[] listIds)
    {
        return BaseResult.success(pmPlatformDynamicsService.deletePmPlatformDynamicsByListIds(listIds));
    }
}
