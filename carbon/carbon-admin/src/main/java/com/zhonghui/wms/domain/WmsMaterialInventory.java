package com.zhonghui.wms.domain;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;

/**
 * 物料库存对象 wms_material_inventory
 *
 * @author zhonghui
 * @date 2022-05-20
 */
@ApiModel("物料库存对象")
public class WmsMaterialInventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料库存ID */
    @Excel(name = "编号")
    @ApiModelProperty("编号")
    private Long id;

    /** 仓库ID */
    @Excel(name = "仓库ID")
    @ApiModelProperty("仓库ID")
    private Long warehouseId;

    /** 物料ID */
    @Excel(name = "物料ID")
    @ApiModelProperty("物料ID")
    private Long materialId;

    /** 总库存 */
    @Excel(name = "总库存")
    @ApiModelProperty("总库存")
    private Double totalInventory;

    /** 锁定库存 */
    @Excel(name = "锁定库存")
    @ApiModelProperty("锁定库存")
    private Double lockInventory;

    /** 库存上限 */
    @Excel(name = "库存上限")
    @ApiModelProperty("库存上限")
    private Double inventoryLimit;

    /** 库存下限 */
    @Excel(name = "库存下限")
    @ApiModelProperty("库存下限")
    private Double inventoryLower;

    /** 库存明细信息 */
    @ApiModelProperty("库存明细信息")
    private List<WmsInventoryDetails> wmsInventoryDetailsList;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setWarehouseId(Long warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId()
    {
        return warehouseId;
    }
    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }

    public Long getMaterialId()
    {
        return materialId;
    }

    public Double getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(Double totalInventory) {
        this.totalInventory = totalInventory;
    }

    public Double getLockInventory() {
        return lockInventory;
    }

    public void setLockInventory(Double lockInventory) {
        this.lockInventory = lockInventory;
    }

    public Double getInventoryLimit() {
        return inventoryLimit;
    }

    public void setInventoryLimit(Double inventoryLimit) {
        this.inventoryLimit = inventoryLimit;
    }

    public Double getInventoryLower() {
        return inventoryLower;
    }

    public void setInventoryLower(Double inventoryLower) {
        this.inventoryLower = inventoryLower;
    }

    public List<WmsInventoryDetails> getWmsInventoryDetailsList()
    {
        return wmsInventoryDetailsList;
    }

    public void setWmsInventoryDetailsList(List<WmsInventoryDetails> wmsInventoryDetailsList)
    {
        this.wmsInventoryDetailsList = wmsInventoryDetailsList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("warehouseId", getWarehouseId())
            .append("materialId", getMaterialId())
            .append("totalInventory", getTotalInventory())
            .append("lockInventory", getLockInventory())
            .append("inventoryLimit", getInventoryLimit())
            .append("inventoryLower", getInventoryLower())
            .append("wmsInventoryDetailsList", getWmsInventoryDetailsList())
            .toString();
    }
}
