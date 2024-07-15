package com.zhonghui.wms.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.common.core.domain.entity.WmsMaterialClassify;
import com.zhonghui.response.BaseResult;
import com.zhonghui.wms.service.IWmsMaterialClassifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 物料分类Controller
 *
 * @author zhonghui
 * @date 2022-05-19
 */
@Api(tags="智能仓储WMS-物料分类")
@RestController
@RequestMapping("/wms/classify")
public class WmsMaterialClassifyController extends BaseController
{
    @Autowired
    private IWmsMaterialClassifyService wmsMaterialClassifyService;

    /**
     * 查询物料分类列表
     */
    @ApiOperation("查询智能仓储WMS-物料分类列表")
    @GetMapping("/list")
    public BaseResult<List<WmsMaterialClassify>> list(WmsMaterialClassify wmsMaterialClassify)
    {
        List<WmsMaterialClassify> list = wmsMaterialClassifyService.selectWmsMaterialClassifyList(wmsMaterialClassify);
        return BaseResult.success(list);
    }

    /**
     * 导出物料分类列表
     */
    @ApiOperation("导出智能仓储WMS-物料分类列表")
    @Log(title = "物料分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsMaterialClassify wmsMaterialClassify)
    {
        List<WmsMaterialClassify> list = wmsMaterialClassifyService.selectWmsMaterialClassifyList(wmsMaterialClassify);
        ExcelUtil<WmsMaterialClassify> util = new ExcelUtil<WmsMaterialClassify>(WmsMaterialClassify.class);
        util.exportExcel(response, list, "物料分类数据");
    }

    /**
     * 获取物料分类详细信息
     */
    @ApiOperation("获取智能仓储WMS-物料分类详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult<WmsMaterialClassify> getInfo(@PathVariable("id") String id)
    {
        return BaseResult.success(wmsMaterialClassifyService.selectWmsMaterialClassifyById(id));
    }

    /**
     * 新增物料分类
     */
    @ApiOperation("新增智能仓储WMS-物料分类")
    @Log(title = "物料分类", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult<Integer> add(@RequestBody WmsMaterialClassify wmsMaterialClassify)
    {
        return BaseResult.success(wmsMaterialClassifyService.insertWmsMaterialClassify(wmsMaterialClassify));
    }

    /**
     * 修改物料分类
     */
    @ApiOperation("修改智能仓储WMS-物料分类")
    @Log(title = "物料分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult<Integer> edit(@RequestBody WmsMaterialClassify wmsMaterialClassify)
    {
        return BaseResult.success(wmsMaterialClassifyService.updateWmsMaterialClassify(wmsMaterialClassify));
    }

    /**
     * 删除物料分类
     */
    @ApiOperation("删除智能仓储WMS-物料分类")
    @Log(title = "物料分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult<Integer> remove(@PathVariable String[] ids)
    {
        return BaseResult.success(wmsMaterialClassifyService.deleteWmsMaterialClassifyByIds(ids));
    }
}
