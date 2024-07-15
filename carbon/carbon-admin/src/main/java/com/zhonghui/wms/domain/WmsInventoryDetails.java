package com.zhonghui.wms.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;

/**
 * 库存明细对象 wms_inventory_details
 *
 * @author zhonghui
 * @date 2022-05-20
 */
@ApiModel("库存明细对象")
public class WmsInventoryDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库存明细ID */
    @Excel(name = "编号")
    @ApiModelProperty("编号")
    private Long id;

    /** 物料库存ID */
    @Excel(name = "物料库存ID")
    @ApiModelProperty("物料库存ID")
    private Long materialInventoryId;

    /** 物料ID */
    @Excel(name = "物料ID")
    @ApiModelProperty("物料ID")
    private Long materialId;

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

    /** 锁定库存 */
    @Excel(name = "锁定库存")
    @ApiModelProperty("锁定库存")
    private Double lockInventory;

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

    /** 库区列表 */
    @ApiModelProperty("库区列表")
    private List<WmsWarehouseArea> wmsWarehouseAreaList;

    /** 库位列表 */
    @ApiModelProperty("库位列表")
    private List<WmsWarehouseSeat> wmsWarehouseSeatList;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public Long getMaterialInventoryId() {
        return materialInventoryId;
    }

    public void setMaterialInventoryId(Long materialInventoryId) {
        this.materialInventoryId = materialInventoryId;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
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

    public Double getLockInventory() {
        return lockInventory;
    }

    public void setLockInventory(Double lockInventory) {
        this.lockInventory = lockInventory;
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

    public List<WmsWarehouseArea> getWmsWarehouseAreaList() {
        return wmsWarehouseAreaList;
    }

    public void setWmsWarehouseAreaList(List<WmsWarehouseArea> wmsWarehouseAreaList) {
        this.wmsWarehouseAreaList = wmsWarehouseAreaList;
    }

    public List<WmsWarehouseSeat> getWmsWarehouseSeatList() {
        return wmsWarehouseSeatList;
    }

    public void setWmsWarehouseSeatList(List<WmsWarehouseSeat> wmsWarehouseSeatList) {
        this.wmsWarehouseSeatList = wmsWarehouseSeatList;
    }

    @Override
    public String toString() {
        return "WmsInventoryDetails{" +
                "id=" + id +
                ", materialInventoryId=" + materialInventoryId +
                ", warehouseAreaId=" + warehouseAreaId +
                ", warehouseSeatId=" + warehouseSeatId +
                ", existingInventory=" + existingInventory +
                ", manufactureDate=" + manufactureDate +
                ", manufacturer='" + manufacturer + '\'' +
                ", batchNumber='" + batchNumber + '\'' +
                ", wmsWarehouseAreaList=" + wmsWarehouseAreaList +
                ", wmsWarehouseSeatList=" + wmsWarehouseSeatList +
                '}';
    }
}
