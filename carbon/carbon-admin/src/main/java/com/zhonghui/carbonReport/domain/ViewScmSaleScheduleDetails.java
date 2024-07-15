package com.zhonghui.carbonReport.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 销售计划达成率报表对象 view_scm_sale_schedule_details
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@ApiModel("销售计划达成率报表对象")
public class ViewScmSaleScheduleDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料id */
    @Excel(name = "物料id")
    @ApiModelProperty("物料id")
    private Long materialId;

    /** 计划销售额 */
    @Excel(name = "计划销售额")
    @ApiModelProperty("计划销售额")
    private BigDecimal sales;

    /** 销售额 */
    @ApiModelProperty("销售额")
    @Excel(name = "销售额")
    private BigDecimal saleAmount;

    /** 计划单号 */
    @Excel(name = "计划单号")
    @ApiModelProperty("计划单号")
    private String scheduleNumber;

    /** 计划标题 */
    @Excel(name = "计划标题")
    @ApiModelProperty("计划标题")
    private String scheduleTitle;

    /** 计划类型 */
    @Excel(name = "计划类型")
    @ApiModelProperty("计划类型")
    private Integer scheduleType;

    /** 起始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "起始时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("起始时间")
    private Date startDate;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("结束时间")
    private Date endDate;

    /** 物料名称 */
    @Excel(name = "物料名称")
    @ApiModelProperty("物料名称")
    private String materialName;

    /** 达成状态 0未达成 1已达成 */
    @ApiModelProperty("达成状态 0未达成 1已达成 ")
    @Excel(name = "达成状态 0未达成 1已达成 ")
    private String status = "0";

    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setSales(BigDecimal sales) 
    {
        this.sales = sales;
    }

    public BigDecimal getSales() 
    {
        return sales;
    }
    public void setSaleAmount(BigDecimal saleAmount)
    {
        this.saleAmount = saleAmount;
    }

    public BigDecimal getSaleAmount()
    {
        return saleAmount;
    }
    public void setScheduleNumber(String scheduleNumber) 
    {
        this.scheduleNumber = scheduleNumber;
    }

    public String getScheduleNumber() 
    {
        return scheduleNumber;
    }
    public void setScheduleTitle(String scheduleTitle) 
    {
        this.scheduleTitle = scheduleTitle;
    }

    public String getScheduleTitle() 
    {
        return scheduleTitle;
    }
    public void setScheduleType(Integer scheduleType) 
    {
        this.scheduleType = scheduleType;
    }

    public Integer getScheduleType() 
    {
        return scheduleType;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("materialId", getMaterialId())
            .append("sales", getSales())
            .append("saleAmount", getSaleAmount())
            .append("scheduleNumber", getScheduleNumber())
            .append("scheduleTitle", getScheduleTitle())
            .append("scheduleType", getScheduleType())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("materialName", getMaterialName())
            .toString();
    }
}
