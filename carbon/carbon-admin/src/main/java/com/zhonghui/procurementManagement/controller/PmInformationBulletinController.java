package com.zhonghui.procurementManagement.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.procurementManagement.domain.PmInformationBulletin;
import com.zhonghui.procurementManagement.service.IPmInformationBulletinService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 信息公告Controller
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Api(tags="采购管理系统-后台-信息公告")
@RestController
@RequestMapping("/procurementManagement/InformationBulletin")
public class PmInformationBulletinController extends BaseController
{
    @Autowired
    private IPmInformationBulletinService pmInformationBulletinService;

    /**
     * 查询信息公告列表
     */
    @ApiOperation("查询信息公告列表")
    @GetMapping("/list")
    public TableDataInfo<List<PmInformationBulletin>> list(PmInformationBulletin pmInformationBulletin)
    {
        startPage();
        List<PmInformationBulletin> list = pmInformationBulletinService.selectPmInformationBulletinList(pmInformationBulletin);
        return getDataTable(list);
    }

    /**
     * 导出信息公告列表
     */
    @ApiOperation("导出信息公告列表")
    @Log(title = "信息公告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmInformationBulletin pmInformationBulletin)
    {
        List<PmInformationBulletin> list = pmInformationBulletinService.selectPmInformationBulletinList(pmInformationBulletin);
        ExcelUtil<PmInformationBulletin> util = new ExcelUtil<PmInformationBulletin>(PmInformationBulletin.class);
        util.exportExcel(response, list, "信息公告数据");
    }

    /**
     * 获取信息公告详细信息
     */
    @ApiOperation("获取信息公告详细信息")
    @GetMapping(value = "/{listId}")
    public BaseResult<PmInformationBulletin> getInfo(@PathVariable("listId") Integer listId)
    {
        return BaseResult.success(pmInformationBulletinService.selectPmInformationBulletinByListId(listId));
    }

    /**
     * 新增信息公告
     */
    @ApiOperation("新增信息公告")
    @Log(title = "信息公告", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult<Integer> add(@RequestBody PmInformationBulletin pmInformationBulletin)
    {
        return BaseResult.success(pmInformationBulletinService.insertPmInformationBulletin(pmInformationBulletin));
    }

    /**
     * 修改信息公告
     */
    @ApiOperation("修改信息公告")
    @Log(title = "信息公告", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult<Integer> edit(@RequestBody PmInformationBulletin pmInformationBulletin)
    {
        return BaseResult.success(pmInformationBulletinService.updatePmInformationBulletin(pmInformationBulletin));
    }

    /**
     * 删除信息公告
     */
    @ApiOperation("删除信息公告")
    @Log(title = "信息公告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{listIds}")
    public BaseResult<Integer> remove(@PathVariable Integer[] listIds)
    {
        return BaseResult.success(pmInformationBulletinService.deletePmInformationBulletinByListIds(listIds));
    }
}
