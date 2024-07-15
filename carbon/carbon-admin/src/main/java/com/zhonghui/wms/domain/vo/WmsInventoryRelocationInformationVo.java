package com.zhonghui.wms.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("智能仓储WMS-移库信息对象出参")
public class WmsInventoryRelocationInformationVo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 移库信息ID */
    @ApiModelProperty("编号")
    private Long id;

    /** 总库存 */
    @Excel(name = "总库存")
    @ApiModelProperty("总库存")
    private Long totalInventory;

    /** 物料id */
    @Excel(name = "物料id")
    @ApiModelProperty("物料id")
    private Long materialId;

    /** 锁定库存 */
    @Excel(name = "锁定库存")
    @ApiModelProperty("锁定库存")
    private Long lockInventory;

    /** 物料 */
    @Excel(name = "物料")
    @ApiModelProperty("物料")
    private String material;

    /** 批号 */
    @Excel(name = "批号")
    @ApiModelProperty("批号")
    private String batchNumber;

    /** 源仓库 */
    @ApiModelProperty("源仓库")
    private Long sourceWarehouse;

    /** 源库区 */
    @ApiModelProperty("源库区")
    private Long sourceArea;

    /** 源库位 */
    @ApiModelProperty("源库位")
    private Long sourceSeat;

    /** 现库存 */
    @ApiModelProperty("现库存")
    private Long existingInventory;
    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("生产日期")
    private Date manufactureDate;

    /** 生产厂家 */
    @Excel(name = "生产厂家")
    @ApiModelProperty("生产厂家")
    private String manufacturer;

    /** 源仓库名称 */
    @Excel(name = "仓库名称")
    @ApiModelProperty("仓库名称")
    private String warehouseName;

    /** 源库区名称 */
    @Excel(name = "源库区名称")
    @ApiModelProperty("源库区名称")
    private String areaName;

    /** 源库位名称 */
    @Excel(name = "源库位名称")
    @ApiModelProperty("源库位名称")
    private String seatName;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(Long totalInventory) {
        this.totalInventory = totalInventory;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public Long getLockInventory() {
        return lockInventory;
    }

    public void setLockInventory(Long lockInventory) {
        this.lockInventory = lockInventory;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Long getSourceWarehouse() {
        return sourceWarehouse;
    }

    public void setSourceWarehouse(Long sourceWarehouse) {
        this.sourceWarehouse = sourceWarehouse;
    }

    public Long getSourceArea() {
        return sourceArea;
    }

    public void setSourceArea(Long sourceArea) {
        this.sourceArea = sourceArea;
    }

    public Long getSourceSeat() {
        return sourceSeat;
    }

    public void setSourceSeat(Long sourceSeat) {
        this.sourceSeat = sourceSeat;
    }

    public Long getExistingInventory() {
        return existingInventory;
    }

    public void setExistingInventory(Long existingInventory) {
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

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }
}
