package com.zhonghui.procurementManagement.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.procurementManagement.domain.PmMark;
import com.zhonghui.procurementManagement.service.IPmMarkService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 参与投标Controller
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Api(tags="采购管理系统-后台-参与投标")
@RestController
@RequestMapping("/procurementManagement/mark")
public class PmMarkController extends BaseController
{
    @Autowired
    private IPmMarkService pmMarkService;

    /**
     * 查询参与投标列表
     */
    @ApiOperation("查询参与投标列表")
    @GetMapping("/list")
    public TableDataInfo<List<PmMark>> list(PmMark pmMark)
    {
        startPage();
        List<PmMark> list = pmMarkService.selectPmMarkList(pmMark);
        return getDataTable(list);
    }

    /**
     * 导出参与投标列表
     */
    @ApiOperation("导出参与投标列表")
    @Log(title = "参与投标表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmMark pmMark)
    {
        List<PmMark> list = pmMarkService.selectPmMarkList(pmMark);
        ExcelUtil<PmMark> util = new ExcelUtil<PmMark>(PmMark.class);
        util.exportExcel(response, list, "参与投标表数据");
    }

    /**
     * 获取参与投标详细信息
     */
    @ApiOperation("获取参与投标详细信息")
    @GetMapping(value = "/{markId}")
    public BaseResult<PmMark> getInfo(@PathVariable("markId") Long markId)
    {
        return BaseResult.success(pmMarkService.selectPmMarkByMarkId(markId));
    }

    /**
     * 新增参与投标
     */
    @ApiOperation("新增参与投标")
    @Log(title = "参与投标表", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult<Integer> add(@RequestBody PmMark pmMark)
    {
        return BaseResult.success(pmMarkService.insertPmMark(pmMark));
    }

    /**
     * 修改参与投标
     */
    @ApiOperation("修改参与投标")
    @Log(title = "参与投标表", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult<Integer> edit(@RequestBody PmMark pmMark)
    {
        return BaseResult.success(pmMarkService.updatePmMark(pmMark));
    }

    /**
     * 删除参与投标
     */
    @ApiOperation("删除参与投标")
    @Log(title = "参与投标表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{markIds}")
    public BaseResult<Integer> remove(@PathVariable Long[] markIds)
    {
        return BaseResult.success(pmMarkService.deletePmMarkByMarkIds(markIds));
    }
}
