package com.zhonghui.wms.domain.vo;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import com.zhonghui.wms.domain.WmsInventoryDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.List;

/**
 * 物料库存出参
 *
 * @author zhonghui
 * @date 2022-05-20
 */
@ApiModel("物料库存出参")
public class WmsMaterialInventoryVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 物料库存ID */
    @ApiModelProperty("编号")
    private Long id;

    /** 仓库ID */
    @Excel(name = "仓库ID")
    @ApiModelProperty("仓库ID")
    private Long warehouseId;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    @ApiModelProperty("仓库名称")
    private String warehouseName;

    /** 物料ID */
    @Excel(name = "物料ID")
    @ApiModelProperty("物料ID")
    private Long materialId;

    /** 物料编码 */
    @ApiModelProperty("物料编码")
    private String materialCode;

    /** 物料名称 */
    @Excel(name = "物料名称")
    @ApiModelProperty("物料名称")
    private String materialName;

    /** 型号 */
    @Excel(name = "型号")
    @ApiModelProperty("型号")
    private String materialModel;

    /** 规格 */
    @Excel(name = "规格")
    @ApiModelProperty("规格")
    private String materialSpecifications;

    /** 单位 */
    @Excel(name = "单位")
    @ApiModelProperty("单位")
    private String materialUnit;

    /** 单价 */
    @Excel(name = "单价")
    @ApiModelProperty("单价")
    private BigDecimal materialPrice;

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
    @Excel(name = "库存明细信息")
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
    public void setWarehouseName(String warehouseName)
    {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseName()
    {
        return warehouseName;
    }
    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }

    public Long getMaterialId()
    {
        return materialId;
    }
    public void setMaterialCode(String materialCode)
    {
        this.materialCode = materialCode;
    }

    public String getMaterialCode()
    {
        return materialCode;
    }
    public void setMaterialName(String materialName)
    {
        this.materialName = materialName;
    }

    public String getMaterialName()
    {
        return materialName;
    }
    public void setMaterialModel(String materialModel)
    {
        this.materialModel = materialModel;
    }

    public String getMaterialModel()
    {
        return materialModel;
    }
    public void setMaterialSpecifications(String materialSpecifications)
    {
        this.materialSpecifications = materialSpecifications;
    }

    public String getMaterialSpecifications()
    {
        return materialSpecifications;
    }
    public void setMaterialUnit(String materialUnit)
    {
        this.materialUnit = materialUnit;
    }

    public String getMaterialUnit()
    {
        return materialUnit;
    }
    public void setMaterialPrice(BigDecimal materialPrice)
    {
        this.materialPrice = materialPrice;
    }

    public BigDecimal getMaterialPrice()
    {
        return materialPrice;
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("warehouseId", getWarehouseId())
                .append("warehouseName", getWarehouseName())
                .append("materialId", getMaterialId())
                .append("materialCode", getMaterialCode())
                .append("materialName", getMaterialName())
                .append("materialModel", getMaterialModel())
                .append("materialSpecifications", getMaterialSpecifications())
                .append("materialUnit", getMaterialUnit())
                .append("materialPrice", getMaterialPrice())
                .append("totalInventory", getTotalInventory())
                .append("lockInventory", getLockInventory())
                .append("inventoryLimit", getInventoryLimit())
                .append("inventoryLower", getInventoryLower())
                .append("wmsInventoryDetailsList", getWmsInventoryDetailsList())
                .toString();
    }
}
