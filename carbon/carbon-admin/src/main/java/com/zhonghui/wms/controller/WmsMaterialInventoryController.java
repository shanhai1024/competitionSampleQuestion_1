package com.zhonghui.wms.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.response.BaseResult;
import com.zhonghui.wms.domain.WmsInventoryDetails;
import com.zhonghui.wms.domain.vo.WmsMaterialInventoryVo;
import com.zhonghui.wms.domain.vo.WmsInventoryRelocationInformationVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.zhonghui.wms.domain.WmsMaterialInventory;
import com.zhonghui.wms.service.IWmsMaterialInventoryService;
import com.zhonghui.common.core.page.TableDataInfo;

import javax.servlet.http.HttpServletResponse;

/**
 * 物料库存Controller
 *
 * @author zhonghui
 * @date 2022-05-20
 */
@Api(tags="智能仓储WMS-物料库存")
@RestController
@RequestMapping("/wms/inventory")
public class WmsMaterialInventoryController extends BaseController
{
    @Autowired
    private IWmsMaterialInventoryService wmsMaterialInventoryService;

    /**
     * 查询物料库存列表
     */
    @ApiOperation("查询智能仓储WMS-物料库存列表")
    @GetMapping("/list")
    public TableDataInfo<List<WmsMaterialInventoryVo>> list(WmsMaterialInventoryVo wmsMaterialInventoryVo)
    {
        startPage();
        List<WmsMaterialInventoryVo> list = wmsMaterialInventoryService.selectWmsMaterialInventoryList(wmsMaterialInventoryVo);
        return getDataTable(list);
    }

    /**
     * 导出物料库存列表
     */
    @ApiOperation("导出智能仓储WMS-物料库存列表")
    @Log(title = "物料库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsMaterialInventoryVo wmsMaterialInventoryVo)
    {
        List<WmsMaterialInventoryVo> list = wmsMaterialInventoryService.selectWmsMaterialInventoryList(wmsMaterialInventoryVo);
        ExcelUtil<WmsMaterialInventoryVo> util = new ExcelUtil<WmsMaterialInventoryVo>(WmsMaterialInventoryVo.class);
        util.exportExcel(response, list, "物料库存数据");
    }

    /**
     * 获取物料库存详细信息
     */
    @ApiOperation("获取智能仓储WMS-物料库存详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult<WmsMaterialInventory> getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(wmsMaterialInventoryService.selectWmsMaterialInventoryById(id));
    }

    /**
     * 新增物料库存
     */
    @ApiOperation("新增智能仓储WMS-物料库存")
    @Log(title = "物料库存", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult<Integer> add(@RequestBody WmsMaterialInventoryVo wmsMaterialInventoryVo)
    {
        // 构造查询条件
        WmsMaterialInventoryVo queryParams = new WmsMaterialInventoryVo();
        queryParams.setMaterialId(wmsMaterialInventoryVo.getMaterialId());
        queryParams.setWarehouseId(wmsMaterialInventoryVo.getWarehouseId());
        // 查询当前仓库中是否已经包含了该物料
        List<WmsMaterialInventoryVo> list = wmsMaterialInventoryService.selectWmsMaterialInventoryList(queryParams);
        // 查询数据不为空则代表列表仓库已经包含该物料
        if (list!=null && !list.isEmpty()){
            return BaseResult.error("仓库已经包含该物料！请重新选择");
        }
        return BaseResult.success(wmsMaterialInventoryService.insertWmsMaterialInventory(wmsMaterialInventoryVo));
    }

    /**
     * 修改物料库存
     */
    @ApiOperation("修改智能仓储WMS-物料库存")
    @Log(title = "物料库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult<Integer> edit(@RequestBody WmsMaterialInventoryVo wmsMaterialInventoryVo)
    {
        return BaseResult.success(wmsMaterialInventoryService.updateWmsMaterialInventory(wmsMaterialInventoryVo));
    }

    /**
     * 删除物料库存
     */
    @ApiOperation("删除智能仓储WMS-物料库存")
    @Log(title = "物料库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult<Integer> remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(wmsMaterialInventoryService.deleteWmsMaterialInventoryByIds(ids));
    }
    /**
     * 查询智能仓储WMS-移库-查询移库信息
     */
    @ApiOperation("查询智能仓储WMS-移库-查询移库信息")
    @GetMapping(value = "/selectRelocationInfoById/{id}")
    public BaseResult<List<WmsInventoryRelocationInformationVo>> selectRelocationInfoById(@PathVariable("id") Long id)
    {
        return BaseResult.success(wmsMaterialInventoryService.selectRelocationInfoById(id));
    }
}
