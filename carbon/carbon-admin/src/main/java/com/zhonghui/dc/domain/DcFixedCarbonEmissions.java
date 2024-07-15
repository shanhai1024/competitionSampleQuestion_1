package com.zhonghui.dc.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 固定碳排放对象 dc_fixed_carbon_emissions
 * 
 * @author zhonghui
 * @date 2022-05-24
 */
@ApiModel("智造双碳—固定碳排放对象")
public class DcFixedCarbonEmissions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @ApiModelProperty("编号")
    private Long id;

    /** 能耗项 */
    @Excel(name = "能耗项")
    @ApiModelProperty("能耗项")
    private String name;

    /** 项目类型 */
    @Excel(name = "项目类型")
    @ApiModelProperty("项目类型")
    private Integer projectType;

    /** 时间类型 */
    @Excel(name = "时间类型")
    @ApiModelProperty("时间类型")
    private Integer timeType;

    /** 能耗数 */
    @Excel(name = "能耗数")
    @ApiModelProperty("能耗数")
    private Double energyConsumptionAmount;

    /** 预警阈值 */
    @Excel(name = "预警阈值")
    @ApiModelProperty("预警阈值")
    private Double warningThreshold;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setProjectType(Integer projectType) 
    {
        this.projectType = projectType;
    }

    public Integer getProjectType() 
    {
        return projectType;
    }
    public void setTimeType(Integer timeType) 
    {
        this.timeType = timeType;
    }

    public Integer getTimeType() 
    {
        return timeType;
    }
    public void setEnergyConsumptionAmount(Double energyConsumptionAmount) 
    {
        this.energyConsumptionAmount = energyConsumptionAmount;
    }

    public Double getEnergyConsumptionAmount() 
    {
        return energyConsumptionAmount;
    }
    public void setWarningThreshold(Double warningThreshold) 
    {
        this.warningThreshold = warningThreshold;
    }

    public Double getWarningThreshold() 
    {
        return warningThreshold;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("projectType", getProjectType())
            .append("timeType", getTimeType())
            .append("energyConsumptionAmount", getEnergyConsumptionAmount())
            .append("warningThreshold", getWarningThreshold())
            .append("remark", getRemark())
            .toString();
    }
}
