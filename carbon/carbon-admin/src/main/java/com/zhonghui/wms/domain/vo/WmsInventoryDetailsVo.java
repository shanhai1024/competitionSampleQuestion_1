package com.zhonghui.wms.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 库存明细对象 wms_inventory_detailsVo
 *
 * @author zhonghui
 * @date 2022-05-20
 */
@ApiModel("库存明细对象出参")
public class WmsInventoryDetailsVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库存明细ID */
    @ApiModelProperty("编号")
    private Long id;

    /** 物料库存ID */
    @Excel(name = "物料库存ID")
    @ApiModelProperty("物料库存ID")
    private Long inventoryId;

    /** 库区ID */
    @Excel(name = "库区ID")
    @ApiModelProperty("库区ID")
    private Long warehouseAreaId;

    /** 库位ID */
    @Excel(name = "库位ID")
    @ApiModelProperty("库位ID")
    private Long warehouseSeatId;

    /** 现有库存 */
    @Excel(name = "现有库存")
    @ApiModelProperty("现有库存")
    private Double existingInventory;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("生产日期")
    private Date manufactureDate;

    /** 生产厂家 */
    @Excel(name = "生产厂家")
    @ApiModelProperty("生产厂家")
    private String manufacturer;

    /** 生产批号 */
    @Excel(name = "生产批号")
    @ApiModelProperty("生产批号")
    private String batchNumber;

    /** 仓库 */
    @Excel(name = "仓库")
    @ApiModelProperty("仓库")
    private String warehouse;

    /** 仓库ID */
    @Excel(name = "仓库ID")
    @ApiModelProperty("仓库ID")
    private Long warehouseId;

    /** 物料Id */
    @Excel(name = "物料Id")
    @ApiModelProperty("物料Id")
    private Long materialId;

    /** 物料 */
    @Excel(name = "物料")
    @ApiModelProperty("物料")
    private String material;

    /** 库区 */
    @Excel(name = "库区")
    @ApiModelProperty("库区")
    private String area;

    /** 库位 */
    @Excel(name = "库位")
    @ApiModelProperty("库位")
    private String seat;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Long getWarehouseAreaId() {
        return warehouseAreaId;
    }

    public void setWarehouseAreaId(Long warehouseAreaId) {
        this.warehouseAreaId = warehouseAreaId;
    }

    public Long getWarehouseSeatId() {
        return warehouseSeatId;
    }

    public void setWarehouseSeatId(Long warehouseSeatId) {
        this.warehouseSeatId = warehouseSeatId;
    }

    public Double getExistingInventory() {
        return existingInventory;
    }

    public void setExistingInventory(Double existingInventory) {
        this.existingInventory = existingInventory;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getMaterialModel() {
        return materialModel;
    }

    public void setMaterialModel(String materialModel) {
        this.materialModel = materialModel;
    }

    public String getMaterialSpecifications() {
        return materialSpecifications;
    }

    public void setMaterialSpecifications(String materialSpecifications) {
        this.materialSpecifications = materialSpecifications;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
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
}
