package com.zhonghui.business.controller;

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
import com.zhonghui.business.domain.MyMesDeviceInformation;
import com.zhonghui.business.service.MyIMesDeviceInformationService;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.common.core.page.TableDataInfo;

/**
 * 设备信息管理Controller
 *
 * @author shanhai1024
 * @date 2024-07-01
 */
@RestController
@RequestMapping("/business/information")
public class MyMesDeviceInformationController extends BaseController
{
    @Autowired
    private MyIMesDeviceInformationService mesDeviceInformationService;

    /**
     * 查询设备信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('business:information:list')")
    @GetMapping("/list")
    public TableDataInfo list(MyMesDeviceInformation mesDeviceInformation)
    {
        startPage();
        List<MyMesDeviceInformation> list = mesDeviceInformationService.selectMesDeviceInformationList(mesDeviceInformation);
        return getDataTable(list);
    }

    /**
     * 导出设备信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('business:information:export')")
    @Log(title = "设备信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MyMesDeviceInformation mesDeviceInformation)
    {
        List<MyMesDeviceInformation> list = mesDeviceInformationService.selectMesDeviceInformationList(mesDeviceInformation);
        ExcelUtil<MyMesDeviceInformation> util = new ExcelUtil<MyMesDeviceInformation>(MyMesDeviceInformation.class);
        util.exportExcel(response, list, "设备信息管理数据");
    }

    /**
     * 获取设备信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:information:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(mesDeviceInformationService.selectMesDeviceInformationById(id));
    }

    /**
     * 新增设备信息管理
     */
    @PreAuthorize("@ss.hasPermi('business:information:add')")
    @Log(title = "设备信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MyMesDeviceInformation mesDeviceInformation)
    {
        return toAjax(mesDeviceInformationService.insertMesDeviceInformation(mesDeviceInformation));
    }

    /**
     * 修改设备信息管理
     */
    @PreAuthorize("@ss.hasPermi('business:information:edit')")
    @Log(title = "设备信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MyMesDeviceInformation mesDeviceInformation)
    {
        return toAjax(mesDeviceInformationService.updateMesDeviceInformation(mesDeviceInformation));
    }

    /**
     * 删除设备信息管理
     */
    @PreAuthorize("@ss.hasPermi('business:information:remove')")
    @Log(title = "设备信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mesDeviceInformationService.deleteMesDeviceInformationByIds(ids));
    }
}
