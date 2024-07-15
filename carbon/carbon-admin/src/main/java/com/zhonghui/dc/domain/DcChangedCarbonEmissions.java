package com.zhonghui.dc.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 变化碳排放对象 dc_changed_carbon_emissions
 * 
 * @author zhonghui
 * @date 2022-05-24
 */
@ApiModel("智造双碳—变化碳排放对象")
public class DcChangedCarbonEmissions extends BaseEntity
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

    /** 日节约水 */
    @Excel(name = "日节约水")
    @ApiModelProperty("日节约水")
    private Double daySaveWater;

    /** 日节约电 */
    @ApiModelProperty("日节约电")
    @Excel(name = "日节约电")
    private Double daySaveElectric;

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
    public void setDaySaveWater(Double daySaveWater) 
    {
        this.daySaveWater = daySaveWater;
    }

    public Double getDaySaveWater() 
    {
        return daySaveWater;
    }
    public void setDaySaveElectric(Double daySaveElectric) 
    {
        this.daySaveElectric = daySaveElectric;
    }

    public Double getDaySaveElectric() 
    {
        return daySaveElectric;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("projectType", getProjectType())
            .append("daySaveWater", getDaySaveWater())
            .append("daySaveElectric", getDaySaveElectric())
            .append("remark", getRemark())
            .toString();
    }
}
