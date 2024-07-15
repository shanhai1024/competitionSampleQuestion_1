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
 * 产品能耗报表对象 view_mes_product_power_details
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@ApiModel("产品能耗报表对象")
public class ViewMesProductPowerDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工厂id */
    @ApiModelProperty("工厂id")
    @Excel(name = "工厂id")
    private Long factoryId;

    /** 生产计划id */
    @ApiModelProperty("生产计划id")
    @Excel(name = "生产计划id")
    private Long productionPlanId;

    /** 物料id */
    @ApiModelProperty("物料id")
    @Excel(name = "物料id")
    private Long materialId;

    /** bomid */
    @ApiModelProperty("bomid")
    @Excel(name = "bomid")
    private Long bomId;

    /** 工艺id */
    @ApiModelProperty("工艺id")
    @Excel(name = "工艺id")
    private Long technologyId;

    /** 待产数量 */
    @ApiModelProperty("待产数量")
    @Excel(name = "待产数量")
    private Double producedQuantity;

    /** 已产数量 */
    @ApiModelProperty("已产数量")
    @Excel(name = "已产数量")
    private Double quantityProduced;

    /** 生产日期 */
    @ApiModelProperty("生产日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date manufactureDate;

    /** 工艺名称 */
    @ApiModelProperty("工艺名称")
    @Excel(name = "工艺名称")
    private String technologyName;

    /** 单位耗电量 */
    @ApiModelProperty("单位耗电量")
    @Excel(name = "单位耗电量")
    private Double unitPowerConsumption;

    /** 总耗电量 */
    @ApiModelProperty("总耗电量")
    @Excel(name = "总耗电量")
    private Double totalPowerConsume;

    /** 物料名称 */
    @ApiModelProperty("物料名称")
    @Excel(name = "物料名称")
    private String materialName;

    /** 型号 */
    @ApiModelProperty("型号")
    @Excel(name = "型号")
    private String materialModel;

    /** 规格 */
    @ApiModelProperty("规格")
    @Excel(name = "规格")
    private String materialSpecifications;

    /** 单位 */
    @ApiModelProperty("单位")
    @Excel(name = "单位")
    private String materialUnit;

    /** 生产线名称 */
    @ApiModelProperty("生产线名称")
    @Excel(name = "生产线名称")
    private String productionLine;

    /** 订单编号 */
    @ApiModelProperty("订单编号")
    @Excel(name = "订单编号")
    private Long saleOrderId;

    /** 总库存 */
    @ApiModelProperty("总库存")
    @Excel(name = "总库存")
    private Double totalInventory;

    /** 生产总节电量 */
    @ApiModelProperty("生产总节电量")
    @Excel(name = "生产总节电量")
    private Double totalProductPowerSave;

    /** 办公总节电量 */
    @ApiModelProperty("办公总节电量")
    @Excel(name = "办公总节电量")
    private Double totalOfficePowerSave;

    @ApiModelProperty("月份")
    @Excel(name = "月份")
    private String productMonth;

    @ApiModelProperty("年份")
    @Excel(name = "年份")
    private String productYear;

    /** 碳排放总量 */
    @ApiModelProperty("碳排放总量")
    @Excel(name = "碳排放总量")
    private Double totalCarbonEmission;

    /** 减少碳排放总量 */
    @ApiModelProperty("减少碳排放总量")
    @Excel(name = "减少碳排放总量")
    private Double totalCarbonSave;

    /** 单位碳排放量 */
    @ApiModelProperty("单位碳排放量")
    @Excel(name = "单位碳排放量")
    private Double carbonEmission;

    /** 生产总用水量 */
    @ApiModelProperty("生产总用水量")
    @Excel(name = "生产总用水量")
    private Double totalWaterConsume;

    /** 办公总用水量 */
    @ApiModelProperty("办公总用水量")
    @Excel(name = "办公总用水量")
    private Double totalOfficeWaterConsume;

    /** 办公总用电量 */
    @ApiModelProperty("办公总用电量")
    @Excel(name = "办公总用电量")
    private Double totalOfficePowerConsume;

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
    public Double getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(Double totalInventory) {
        this.totalInventory = totalInventory;
    }
    public Double getTotalProductPowerSave() {
        return totalProductPowerSave;
    }

    public void setTotalProductPowerSave(Double totalProductPowerSave) {
        this.totalProductPowerSave = totalProductPowerSave;
    }

    public String getProductMonth() {
        return productMonth;
    }

    public void setProductMonth(String productMonth) {
        this.productMonth = productMonth;
    }

    public Double getTotalOfficePowerSave() {
        return totalOfficePowerSave;
    }

    public void setTotalOfficePowerSave(Double totalOfficePowerSave) {
        this.totalOfficePowerSave = totalOfficePowerSave;
    }

    public Double getTotalCarbonEmission() {
        return totalCarbonEmission;
    }

    public void setTotalCarbonEmission(Double totalCarbonEmission) {
        this.totalCarbonEmission = totalCarbonEmission;
    }

    public Double getTotalCarbonSave() {
        return totalCarbonSave;
    }

    public void setTotalCarbonSave(Double totalCarbonSave) {
        this.totalCarbonSave = totalCarbonSave;
    }

    public String getProductYear() {
        return productYear;
    }

    public void setProductYear(String productYear) {
        this.productYear = productYear;
    }

    public Double getCarbonEmission() {
        return carbonEmission;
    }

    public void setCarbonEmission(Double carbonEmission) {
        this.carbonEmission = carbonEmission;
    }
    public Double getTotalWaterConsume() {
        return totalWaterConsume;
    }

    public void setTotalWaterConsume(Double totalWaterConsume) {
        this.totalWaterConsume = totalWaterConsume;
    }

    public Double getTotalOfficeWaterConsume() {
        return totalOfficeWaterConsume;
    }

    public void setTotalOfficeWaterConsume(Double totalOfficeWaterConsume) {
        this.totalOfficeWaterConsume = totalOfficeWaterConsume;
    }

    public Double getTotalOfficePowerConsume() {
        return totalOfficePowerConsume;
    }

    public void setTotalOfficePowerConsume(Double totalOfficePowerConsume) {
        this.totalOfficePowerConsume = totalOfficePowerConsume;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
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
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialSpecifications", getMaterialSpecifications())
            .append("materialUnit", getMaterialUnit())
            .append("productionLine", getProductionLine())
            .append("saleOrderId", getSaleOrderId())
            .append("totalInventory", getTotalInventory())
            .append("productMonth", getProductMonth())
            .append("productYear", getProductYear())
            .toString();
    }
}
