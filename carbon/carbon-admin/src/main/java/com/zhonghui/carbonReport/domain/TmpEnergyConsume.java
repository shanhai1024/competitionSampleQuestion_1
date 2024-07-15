package com.zhonghui.carbonReport.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 能耗临时对象 tmp_energy_consume
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@ApiModel("能耗临时对象")
public class TmpEnergyConsume extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @ApiModelProperty("编号")
    private Long id;

    /** 类型：0消耗1节约 */
    @Excel(name = "类型：0消耗1节约")
    @ApiModelProperty("类型：0消耗1节约")
    private Integer type;

    /** 分类：1电2水 */
    @Excel(name = "分类：1电2水")
    @ApiModelProperty("分类：1电2水")
    private Integer category;

    /** 月份 */
    @Excel(name = "月份")
    @ApiModelProperty("月份")
    private String month;

    /** 日期 */
    @Excel(name = "日期")
    @ApiModelProperty("日期")
    private String day;

    /** 能耗数或节约数 */
    @Excel(name = "能耗数或节约数")
    @ApiModelProperty("能耗数或节约数")
    private Double energy;

    /** 项目类型 */
    @Excel(name = "项目类型")
    @ApiModelProperty("项目类型")
    private Integer itemCategory;

    /** 年份 */
    @Excel(name = "年份")
    @ApiModelProperty("年份")
    private String year;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setCategory(Integer category) 
    {
        this.category = category;
    }

    public Integer getCategory() 
    {
        return category;
    }
    public void setMonth(String month) 
    {
        this.month = month;
    }

    public String getMonth() 
    {
        return month;
    }
    public void setDay(String day) 
    {
        this.day = day;
    }

    public String getDay() 
    {
        return day;
    }
    public void setEnergy(Double energy) 
    {
        this.energy = energy;
    }

    public Double getEnergy() 
    {
        return energy;
    }
    public void setItemCategory(Integer itemCategory) 
    {
        this.itemCategory = itemCategory;
    }

    public Integer getItemCategory() 
    {
        return itemCategory;
    }
    public void setYear(String year) 
    {
        this.year = year;
    }

    public String getYear() 
    {
        return year;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("category", getCategory())
            .append("month", getMonth())
            .append("day", getDay())
            .append("energy", getEnergy())
            .append("itemCategory", getItemCategory())
            .append("year", getYear())
            .toString();
    }
}
