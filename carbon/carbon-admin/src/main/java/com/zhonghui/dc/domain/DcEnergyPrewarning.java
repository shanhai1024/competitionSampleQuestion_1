package com.zhonghui.dc.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 智造双碳-能效预警对象 dc_energy_prewarning
 * 
 * @author zhonghui
 * @date 2022-05-24
 */
@ApiModel("智造双碳—能效预警对象")
public class DcEnergyPrewarning extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @ApiModelProperty("编号")
    private Long id;

    /** 检测点名称 */
    @Excel(name = "检测点名称")
    @ApiModelProperty("检测点名称")
    private String pointsName;

    /** 检测点地址 */
    @Excel(name = "检测点地址")
    @ApiModelProperty("检测点地址")
    private String pointsAddress;

    /** 实时功率 */
    @Excel(name = "实时功率")
    @ApiModelProperty("实时功率")
    private Double realTimePower;

    /** 实时电压 */
    @Excel(name = "实时电压")
    @ApiModelProperty("实时电压")
    private Double realTimeVolt;

    /** 状态：0未过载，1已过载 */
    @Excel(name = "状态：0未过载，1已过载")
    @ApiModelProperty("状态：0未过载，1已过载")
    private Integer status;

    /** 上报时间 */
    @ApiModelProperty("上报时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上报时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reportTime;

    /** 备注 */
    @Excel(name = "备注")
    @ApiModelProperty("备注")
    private String mark;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPointsName(String pointsName) 
    {
        this.pointsName = pointsName;
    }

    public String getPointsName() 
    {
        return pointsName;
    }
    public void setPointsAddress(String pointsAddress) 
    {
        this.pointsAddress = pointsAddress;
    }

    public String getPointsAddress() 
    {
        return pointsAddress;
    }
    public void setRealTimePower(Double realTimePower) 
    {
        this.realTimePower = realTimePower;
    }

    public Double getRealTimePower() 
    {
        return realTimePower;
    }
    public void setRealTimeVolt(Double realTimeVolt) 
    {
        this.realTimeVolt = realTimeVolt;
    }

    public Double getRealTimeVolt() 
    {
        return realTimeVolt;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setReportTime(Date reportTime) 
    {
        this.reportTime = reportTime;
    }

    public Date getReportTime() 
    {
        return reportTime;
    }
    public void setMark(String mark) 
    {
        this.mark = mark;
    }

    public String getMark() 
    {
        return mark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pointsName", getPointsName())
            .append("pointsAddress", getPointsAddress())
            .append("realTimePower", getRealTimePower())
            .append("realTimeVolt", getRealTimeVolt())
            .append("status", getStatus())
            .append("reportTime", getReportTime())
            .append("mark", getMark())
            .toString();
    }
}
