package com.zhonghui.productionScheduling.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.zhonghui.productionScheduling.domain.MesPlannedProduction;
import com.zhonghui.productionScheduling.service.IMesPlannedProductionService;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.common.core.page.TableDataInfo;

/**
 * 计划排产Controller
 * 
 * @author shanhai1024
 * @date 2024-07-01
 */
@RestController
@RequestMapping("/productionScheduling/productionScheduling")
public class MesPlannedProductionController extends BaseController
{
    @Autowired
    private IMesPlannedProductionService mesPlannedProductionService;

    /**
     * 查询计划排产列表
     */
    @PreAuthorize("@ss.hasPermi('productionScheduling:productionScheduling:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesPlannedProduction mesPlannedProduction)
    {
        startPage();
        List<MesPlannedProduction> list = mesPlannedProductionService.selectMesPlannedProductionList(mesPlannedProduction);
        return getDataTable(list);
    }

    /**
     * 导出计划排产列表
     */
    @PreAuthorize("@ss.hasPermi('productionScheduling:productionScheduling:export')")
    @Log(title = "计划排产", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesPlannedProduction mesPlannedProduction)
    {
        List<MesPlannedProduction> list = mesPlannedProductionService.selectMesPlannedProductionList(mesPlannedProduction);
        ExcelUtil<MesPlannedProduction> util = new ExcelUtil<MesPlannedProduction>(MesPlannedProduction.class);
        util.exportExcel(response, list, "计划排产数据");
    }

    /**
     * 获取计划排产详细信息
     */
    @PreAuthorize("@ss.hasPermi('productionScheduling:productionScheduling:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(mesPlannedProductionService.selectMesPlannedProductionById(id));
    }

    /**
     * 新增计划排产
     */
    @PreAuthorize("@ss.hasPermi('productionScheduling:productionScheduling:add')")
    @Log(title = "计划排产", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesPlannedProduction mesPlannedProduction)
    {
        return toAjax(mesPlannedProductionService.insertMesPlannedProduction(mesPlannedProduction));
    }

    /**
     * 修改计划排产
     */
    @PreAuthorize("@ss.hasPermi('productionScheduling:productionScheduling:edit')")
    @Log(title = "计划排产", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesPlannedProduction mesPlannedProduction)
    {
        return toAjax(mesPlannedProductionService.updateMesPlannedProduction(mesPlannedProduction));
    }

    /**
     * 删除计划排产
     */
    @PreAuthorize("@ss.hasPermi('productionScheduling:productionScheduling:remove')")
    @Log(title = "计划排产", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mesPlannedProductionService.deleteMesPlannedProductionByIds(ids));
    }
}
