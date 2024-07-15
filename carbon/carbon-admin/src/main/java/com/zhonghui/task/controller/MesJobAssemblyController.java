package com.zhonghui.task.controller;

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
import com.zhonghui.task.domain.MesJobAssembly;
import com.zhonghui.task.service.IMesJobAssemblyService;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.common.core.page.TableDataInfo;

/**
 * 作业装配Controller
 * 
 * @author shanhai1024
 * @date 2024-07-01
 */
@RestController
@RequestMapping("/task/task")
public class MesJobAssemblyController extends BaseController
{
    @Autowired
    private IMesJobAssemblyService mesJobAssemblyService;

    /**
     * 查询作业装配列表
     */
    @PreAuthorize("@ss.hasPermi('task:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesJobAssembly mesJobAssembly)
    {
        startPage();
        List<MesJobAssembly> list = mesJobAssemblyService.selectMesJobAssemblyList(mesJobAssembly);
        return getDataTable(list);
    }

    /**
     * 导出作业装配列表
     */
    @PreAuthorize("@ss.hasPermi('task:task:export')")
    @Log(title = "作业装配", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesJobAssembly mesJobAssembly)
    {
        List<MesJobAssembly> list = mesJobAssemblyService.selectMesJobAssemblyList(mesJobAssembly);
        ExcelUtil<MesJobAssembly> util = new ExcelUtil<MesJobAssembly>(MesJobAssembly.class);
        util.exportExcel(response, list, "作业装配数据");
    }

    /**
     * 获取作业装配详细信息
     */
    @PreAuthorize("@ss.hasPermi('task:task:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(mesJobAssemblyService.selectMesJobAssemblyById(id));
    }

    /**
     * 新增作业装配
     */
    @PreAuthorize("@ss.hasPermi('task:task:add')")
    @Log(title = "作业装配", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesJobAssembly mesJobAssembly)
    {
        return toAjax(mesJobAssemblyService.insertMesJobAssembly(mesJobAssembly));
    }

    /**
     * 修改作业装配
     */
    @PreAuthorize("@ss.hasPermi('task:task:edit')")
    @Log(title = "作业装配", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesJobAssembly mesJobAssembly)
    {
        return toAjax(mesJobAssemblyService.updateMesJobAssembly(mesJobAssembly));
    }

    /**
     * 删除作业装配
     */
    @PreAuthorize("@ss.hasPermi('task:task:remove')")
    @Log(title = "作业装配", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mesJobAssemblyService.deleteMesJobAssemblyByIds(ids));
    }
}
