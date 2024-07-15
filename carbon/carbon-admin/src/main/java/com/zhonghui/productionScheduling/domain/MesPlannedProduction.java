package com.zhonghui.productionScheduling.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 计划排产对象 mes_planned_production
 *
 * @author shanhai1024
 * @date 2024-07-01
 */
public class MesPlannedProduction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 流水号 */
    @Excel(name = "流水号")
    private String serialNo;

    /** 生产计划id */
    @Excel(name = "生产计划id")
    private Long productionPlanId;

    /** 物料id */
    @Excel(name = "物料id")
    private Long materialId;

    /** bomid */
    @Excel(name = "bomid")
    private Long bomId;

    /** 工厂id */
    @Excel(name = "工厂id")
    private Long factoryId;

    /** 工艺id */
    @Excel(name = "工艺id")
    private Long technologyId;

    /** 待产数量 */
    @Excel(name = "待产数量")
    private Long producedQuantity;

    /** 已产数量 */
    @Excel(name = "已产数量")
    private Long quantityProduced;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date manufactureDate;

    /** 交货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "交货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryDate;

    /** 发布状态：0未发布，1已下发 */
    @Excel(name = "发布状态：0未发布，1已下发")
    private Long status;

    /** 领料状态：0未领料，1已领料 */
    @Excel(name = "领料状态：0未领料，1已领料")
    private Long pickingStatus;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setSerialNo(String serialNo)
    {
        this.serialNo = serialNo;
    }

    public String getSerialNo()
    {
        return serialNo;
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
    public void setFactoryId(Long factoryId)
    {
        this.factoryId = factoryId;
    }

    public Long getFactoryId()
    {
        return factoryId;
    }
    public void setTechnologyId(Long technologyId)
    {
        this.technologyId = technologyId;
    }

    public Long getTechnologyId()
    {
        return technologyId;
    }
    public void setProducedQuantity(Long producedQuantity)
    {
        this.producedQuantity = producedQuantity;
    }

    public Long getProducedQuantity()
    {
        return producedQuantity;
    }
    public void setQuantityProduced(Long quantityProduced)
    {
        this.quantityProduced = quantityProduced;
    }

    public Long getQuantityProduced()
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
    public void setDeliveryDate(Date deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }

    public Date getDeliveryDate()
    {
        return deliveryDate;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }
    public void setPickingStatus(Long pickingStatus)
    {
        this.pickingStatus = pickingStatus;
    }

    public Long getPickingStatus()
    {
        return pickingStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("serialNo", getSerialNo())
            .append("productionPlanId", getProductionPlanId())
            .append("materialId", getMaterialId())
            .append("bomId", getBomId())
            .append("factoryId", getFactoryId())
            .append("technologyId", getTechnologyId())
            .append("producedQuantity", getProducedQuantity())
            .append("quantityProduced", getQuantityProduced())
            .append("manufactureDate", getManufactureDate())
            .append("deliveryDate", getDeliveryDate())
            .append("status", getStatus())
            .append("pickingStatus", getPickingStatus())
            .append("remark", getRemark())
            .toString();
    }
}
