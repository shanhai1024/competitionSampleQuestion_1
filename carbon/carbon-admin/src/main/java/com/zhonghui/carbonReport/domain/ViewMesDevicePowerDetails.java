package com.zhonghui.carbonReport.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 设备能耗数据采集对象 view_mes_device_power_details
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@ApiModel("设备能耗数据采集对象")
public class ViewMesDevicePowerDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备ID */
    @Excel(name = "设备ID")
    @ApiModelProperty("设备ID")
    private Long deviceId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    @ApiModelProperty("设备名称")
    private String deviceName;

    /** 工厂id */
    @Excel(name = "工厂id")
    @ApiModelProperty("工厂id")
    private Long factoryId;

    /** 生产计划id */
    @Excel(name = "生产计划id")
    @ApiModelProperty("生产计划id")
    private Long productionPlanId;

    /** 物料id */
    @Excel(name = "物料id")
    @ApiModelProperty("物料id")
    private Long materialId;

    /** bomid */
    @Excel(name = "bomid")
    @ApiModelProperty("bomid")
    private Long bomId;

    /** 工艺id */
    @Excel(name = "工艺id")
    @ApiModelProperty("工艺id")
    private Long technologyId;

    /** 待产数量 */
    @Excel(name = "待产数量")
    @ApiModelProperty("待产数量")
    private Double producedQuantity;

    /** 已产数量 */
    @Excel(name = "已产数量")
    @ApiModelProperty("已产数量")
    private Double quantityProduced;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("生产日期")
    private Date manufactureDate;

    /** 工艺名称 */
    @Excel(name = "工艺名称")
    @ApiModelProperty("工艺名称")
    private String technologyName;

    /** 单位耗电量 */
    @Excel(name = "单位耗电量")
    @ApiModelProperty("单位耗电量")
    private Double unitPowerConsumption;

    /** 总耗电量 */
    @Excel(name = "总耗电量")
    @ApiModelProperty("总耗电量")
    private Double totalPowerConsume;

    /** 生产线名称 */
    @Excel(name = "生产线名称")
    @ApiModelProperty("生产线名称")
    private String productionLine;

    /** 订单编号 */
    @Excel(name = "订单编号")
    @ApiModelProperty("订单编号")
    private Long saleOrderId;

    /** 单位碳排放量 */
    @ApiModelProperty("单位碳排放量")
    @Excel(name = "单位碳排放量")
    private Double carbonEmission;

    /** 总碳排放量 */
    @ApiModelProperty("总碳排放量")
    @Excel(name = "总碳排放量")
    private Double totalCarbonEmission;

    private String hour;

    public void setDeviceId(Long deviceId) 
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId() 
    {
        return deviceId;
    }
    public void setDeviceName(String deviceName) 
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName() 
    {
        return deviceName;
    }
    public void setFactoryId(Long factoryId) 
    {
        this.factoryId = factoryId;
    }

    public Long getFactoryId() 
    {
        return factoryId;
    }
    public void setProductionPlanId(Long productionPlanId) 
    {
        this.productionPlanId = productionPlanId;
    }

    public Long getProductionPlanId() 
    {
        return productionPlanId;
    }
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setBomId(Long bomId) 
    {
        this.bomId = bomId;
    }

    public Long getBomId() 
    {
        return bomId;
    }
    public void setTechnologyId(Long technologyId) 
    {
        this.technologyId = technologyId;
    }

    public Long getTechnologyId() 
    {
        return technologyId;
    }
    public void setProducedQuantity(Double producedQuantity) 
    {
        this.producedQuantity = producedQuantity;
    }

    public Double getProducedQuantity() 
    {
        return producedQuantity;
    }
    public void setQuantityProduced(Double quantityProduced) 
    {
        this.quantityProduced = quantityProduced;
    }

    public Double getQuantityProduced() 
    {
        return quantityProduced;
    }
    public void setManufactureDate(Date manufactureDate) 
    {
        this.manufactureDate = manufactureDate;
    }

    public Date getManufactureDate() 
    {
        return manufactureDate;
    }
    public void setTechnologyName(String technologyName) 
    {
        this.technologyName = technologyName;
    }

    public String getTechnologyName() 
    {
        return technologyName;
    }
    public void setUnitPowerConsumption(Double unitPowerConsumption) 
    {
        this.unitPowerConsumption = unitPowerConsumption;
    }

    public Double getUnitPowerConsumption() 
    {
        return unitPowerConsumption;
    }
    public void setTotalPowerConsume(Double totalPowerConsume) 
    {
        this.totalPowerConsume = totalPowerConsume;
    }

    public Double getTotalPowerConsume() 
    {
        return totalPowerConsume;
    }
    public void setProductionLine(String productionLine) 
    {
        this.productionLine = productionLine;
    }

    public String getProductionLine() 
    {
        return productionLine;
    }
    public void setSaleOrderId(Long saleOrderId) 
    {
        this.saleOrderId = saleOrderId;
    }

    public Long getSaleOrderId() 
    {
        return saleOrderId;
    }
    public Double getCarbonEmission() {
        return carbonEmission;
    }

    public void setCarbonEmission(Double carbonEmission) {
        this.carbonEmission = carbonEmission;
    }

    public Double getTotalCarbonEmission() {
        return totalCarbonEmission;
    }

    public void setTotalCarbonEmission(Double totalCarbonEmission) {
        this.totalCarbonEmission = totalCarbonEmission;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("deviceId", getDeviceId())
            .append("deviceName", getDeviceName())
            .append("factoryId", getFactoryId())
            .append("productionPlanId", getProductionPlanId())
            .append("materialId", getMaterialId())
            .append("bomId", getBomId())
            .append("technologyId", getTechnologyId())
            .append("producedQuantity", getProducedQuantity())
            .append("quantityProduced", getQuantityProduced())
            .append("manufactureDate", getManufactureDate())
            .append("technologyName", getTechnologyName())
            .append("unitPowerConsumption", getUnitPowerConsumption())
            .append("totalPowerConsume", getTotalPowerConsume())
            .append("productionLine", getProductionLine())
            .append("saleOrderId", getSaleOrderId())
            .append("carbonEmission", getCarbonEmission())
            .append("totalCarbonEmission", getTotalCarbonEmission())
            .append("hour", getHour())
            .toString();
    }
}
