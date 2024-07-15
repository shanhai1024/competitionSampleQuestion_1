package com.zhonghui.procurementManagement.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.procurementManagement.domain.PmBid;
import com.zhonghui.procurementManagement.service.IPmBidService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 我的投标Controller
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Api(tags="采购管理系统-后台-我的投标")
@RestController
@RequestMapping("/procurementManagement/bid")
public class PmBidController extends BaseController
{
    @Autowired
    private IPmBidService pmBidService;

    /**
     * 查询我的投标列表
     */
    @ApiOperation("查询我的投标列表")
    @GetMapping("/list")
    public TableDataInfo<List<PmBid>> list(PmBid pmBid)
    {
        startPage();
        List<PmBid> list = pmBidService.selectPmBidListVo(pmBid);
        return getDataTable(list);
    }

    /**
     * 导出我的投标列表
     */
    @Log(title = "我的投标", businessType = BusinessType.EXPORT)
    @ApiOperation("导出我的投标列表")
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmBid pmBid)
    {
        List<PmBid> list = pmBidService.selectPmBidList(pmBid);
        ExcelUtil<PmBid> util = new ExcelUtil<PmBid>(PmBid.class);
        util.exportExcel(response, list, "我的投标数据");
    }

    /**
     * 获取我的投标详细信息
     */
    @ApiOperation("获取我的投标详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult<PmBid> getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(pmBidService.selectPmBidById(id));
    }

    /**
     * 新增我的投标
     */
    @ApiOperation("新增我的投标")
    @Log(title = "我的投标", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult<Integer> add(@RequestBody PmBid pmBid)
    {
        return BaseResult.success(pmBidService.insertPmBid(pmBid));
    }

    /**
     * 修改我的投标
     */
    @ApiOperation("修改我的投标")
    @Log(title = "我的投标", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult<Integer> edit(@RequestBody PmBid pmBid)
    {
        return BaseResult.success(pmBidService.updatePmBid(pmBid));
    }

    /**
     * 删除我的投标
     */
    @ApiOperation("删除我的投标")
    @Log(title = "我的投标", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult<Integer> remove(@PathVariable Long[] ids)
    {
        pmBidService.deletePmBidByIds(ids);
        return BaseResult.success();
    }
}
