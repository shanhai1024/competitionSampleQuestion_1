package com.zhonghui.procurementManagement.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.domain.AjaxResult;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.procurementManagement.domain.PmEnterpriseInformation;
import com.zhonghui.procurementManagement.service.IPmEnterpriseInformationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 采购—企业信息Controller
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Api(tags="采购管理系统-后台-投诉")
@RestController
@RequestMapping("/procurementManagement/enterpriseInformation")
public class PmEnterpriseInformationController extends BaseController
{
    @Autowired
    private IPmEnterpriseInformationService pmEnterpriseInformationService;

    /**
     * 查询采购—企业信息列表
     */
    @PreAuthorize("@ss.hasPermi('procurementManagement:enterpriseInformation:list')")
    @GetMapping("/list")
    public TableDataInfo list(PmEnterpriseInformation pmEnterpriseInformation)
    {
        startPage();
        List<PmEnterpriseInformation> list = pmEnterpriseInformationService.selectPmEnterpriseInformationList(pmEnterpriseInformation);
        return getDataTable(list);
    }

    /**
     * 导出采购—企业信息列表
     */
    @PreAuthorize("@ss.hasPermi('procurementManagement:enterpriseInformation:export')")
    @Log(title = "采购—企业信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmEnterpriseInformation pmEnterpriseInformation)
    {
        List<PmEnterpriseInformation> list = pmEnterpriseInformationService.selectPmEnterpriseInformationList(pmEnterpriseInformation);
        ExcelUtil<PmEnterpriseInformation> util = new ExcelUtil<PmEnterpriseInformation>(PmEnterpriseInformation.class);
        util.exportExcel(response, list, "采购—企业信息数据");
    }

    /**
     * 获取采购—企业信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('procurementManagement:enterpriseInformation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pmEnterpriseInformationService.selectPmEnterpriseInformationById(id));
    }

    /**
     * 新增采购—企业信息
     */
    @PreAuthorize("@ss.hasPermi('procurementManagement:enterpriseInformation:add')")
    @Log(title = "采购—企业信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmEnterpriseInformation pmEnterpriseInformation)
    {
        return toAjax(pmEnterpriseInformationService.insertPmEnterpriseInformation(pmEnterpriseInformation));
    }

    /**
     * 修改采购—企业信息
     */
    @PreAuthorize("@ss.hasPermi('procurementManagement:enterpriseInformation:edit')")
    @Log(title = "采购—企业信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmEnterpriseInformation pmEnterpriseInformation)
    {
        return toAjax(pmEnterpriseInformationService.updatePmEnterpriseInformation(pmEnterpriseInformation));
    }

    /**
     * 删除采购—企业信息
     */
    @PreAuthorize("@ss.hasPermi('procurementManagement:enterpriseInformation:remove')")
    @Log(title = "采购—企业信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pmEnterpriseInformationService.deletePmEnterpriseInformationByIds(ids));
    }
}
