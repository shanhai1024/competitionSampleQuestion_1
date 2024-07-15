package com.zhonghui.mes.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
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
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.mes.domain.MesProjectMaintenance;
import com.zhonghui.mes.service.IMesProjectMaintenanceService;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.common.core.page.TableDataInfo;

/**
 * 项目维护Controller
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
@Api(tags="制造执行MES-项目维护")
@RestController
@RequestMapping("/mes/maintenance")
public class MesProjectMaintenanceController extends BaseController
{
    @Autowired
    private IMesProjectMaintenanceService mesProjectMaintenanceService;

    /**
     * 查询项目维护列表
     */
    @ApiOperation("查询项目维护列表")
    @GetMapping("/list")
    public TableDataInfo<List<MesProjectMaintenance>> list(MesProjectMaintenance mesProjectMaintenance)
    {
        startPage();
        System.out.println(mesProjectMaintenance.getParams());
        List<MesProjectMaintenance> list = mesProjectMaintenanceService.selectMesProjectMaintenanceList(mesProjectMaintenance);
        return getDataTable(list);
    }

    /**
     * 查询项目维护列表(不分页)
     */
    @ApiOperation("查询项目维护列表(不分页)")
    @GetMapping("/getList")
    public BaseResult<List<MesProjectMaintenance>> getList(MesProjectMaintenance mesProjectMaintenance)
    {
        return BaseResult.success(mesProjectMaintenanceService.selectMesProjectMaintenanceList(mesProjectMaintenance));
    }

    /**
     * 导出项目维护列表
     */
    @ApiOperation("导出项目维护列表")
    @Log(title = "项目维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesProjectMaintenance mesProjectMaintenance)
    {
        List<MesProjectMaintenance> list = mesProjectMaintenanceService.selectMesProjectMaintenanceList(mesProjectMaintenance);
        ExcelUtil<MesProjectMaintenance> util = new ExcelUtil<MesProjectMaintenance>(MesProjectMaintenance.class);
        util.exportExcel(response, list, "项目维护数据");
    }

    /**
     * 获取项目维护详细信息
     */
    @ApiOperation("获取项目维护详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult<MesProjectMaintenance> getInfo(@PathVariable("id") Integer id)
    {
        return BaseResult.success(mesProjectMaintenanceService.selectMesProjectMaintenanceById(id));
    }

    /**
     * 新增项目维护
     */
    @ApiOperation("新增项目维护")
    @Log(title = "项目维护", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult<Integer> add(@RequestBody MesProjectMaintenance mesProjectMaintenance)
    {
        return BaseResult.success(mesProjectMaintenanceService.insertMesProjectMaintenance(mesProjectMaintenance));
    }

    /**
     * 修改项目维护
     */
    @ApiOperation("修改项目维护")
    @Log(title = "项目维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult<Integer> edit(@RequestBody MesProjectMaintenance mesProjectMaintenance)
    {
        return BaseResult.success(mesProjectMaintenanceService.updateMesProjectMaintenance(mesProjectMaintenance));
    }

    /**
     * 删除项目维护
     */
    @ApiOperation("删除项目维护")
    @Log(title = "项目维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult<Integer> remove(@PathVariable Integer[] ids)
    {
        return BaseResult.success(mesProjectMaintenanceService.deleteMesProjectMaintenanceByIds(ids));
    }
}
