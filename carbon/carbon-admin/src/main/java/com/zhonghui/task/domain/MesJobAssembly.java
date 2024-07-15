package com.zhonghui.task.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 作业装配对象 mes_job_assembly
 *
 * @author shanhai1024
 * @date 2024-07-01
 */
public class MesJobAssembly extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 作业名称 */
    @Excel(name = "作业名称")
    private String jobName;

    /** 计划排产id */
    @Excel(name = "计划排产id")
    private Long plannedProductionId;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 生产数量 */
    @Excel(name = "生产数量")
    private Long quantity;

    /** 作业状态：0未执行1执行中2已完成3异常 */
    @Excel(name = "作业状态：0未执行1执行中2已完成3异常")
    private Long status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setJobName(String jobName)
    {
        this.jobName = jobName;
    }

    public String getJobName()
    {
        return jobName;
    }
    public void setPlannedProductionId(Long plannedProductionId)
    {
        this.plannedProductionId = plannedProductionId;
    }

    public Long getPlannedProductionId()
    {
        return plannedProductionId;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
    public void setQuantity(Long quantity)
    {
        this.quantity = quantity;
    }

    public Long getQuantity()
    {
        return quantity;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("jobName", getJobName())
            .append("plannedProductionId", getPlannedProductionId())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("quantity", getQuantity())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
