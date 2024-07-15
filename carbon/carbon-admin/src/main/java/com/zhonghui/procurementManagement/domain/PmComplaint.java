package com.zhonghui.procurementManagement.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 采购—投诉对象 procurement_complaint
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
public class PmComplaint extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 投诉id */
    private Long complaintId;

    /** 投诉标题 */
    @Excel(name = "投诉标题")
    private String title;

    /** 创建时间 */
    private Date creationTime;

    /** 处理状态（0：未处理，1：已处理） */
    @Excel(name = "处理状态", readConverterExp = "0=：未处理，1：已处理")
    private Long complaintType;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactNumber;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contactPerson;

    /** 附件地址 */
    private String attachment;

    /** 投诉内容 */
    private String complaintText;

    /** 处理结果 */
    private String processingResult;

    public void setComplaintId(Long complaintId) 
    {
        this.complaintId = complaintId;
    }

    public Long getComplaintId() 
    {
        return complaintId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setCreationTime(Date creationTime) 
    {
        this.creationTime = creationTime;
    }

    public Date getCreationTime() 
    {
        return creationTime;
    }
    public void setComplaintType(Long complaintType) 
    {
        this.complaintType = complaintType;
    }

    public Long getComplaintType() 
    {
        return complaintType;
    }
    public void setContactNumber(String contactNumber) 
    {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() 
    {
        return contactNumber;
    }
    public void setContactPerson(String contactPerson) 
    {
        this.contactPerson = contactPerson;
    }

    public String getContactPerson() 
    {
        return contactPerson;
    }
    public void setAttachment(String attachment) 
    {
        this.attachment = attachment;
    }

    public String getAttachment() 
    {
        return attachment;
    }
    public void setComplaintText(String complaintText) 
    {
        this.complaintText = complaintText;
    }

    public String getComplaintText() 
    {
        return complaintText;
    }
    public void setProcessingResult(String processingResult) 
    {
        this.processingResult = processingResult;
    }

    public String getProcessingResult() 
    {
        return processingResult;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("complaintId", getComplaintId())
            .append("title", getTitle())
            .append("creationTime", getCreationTime())
            .append("complaintType", getComplaintType())
            .append("contactNumber", getContactNumber())
            .append("contactPerson", getContactPerson())
            .append("attachment", getAttachment())
            .append("complaintText", getComplaintText())
            .append("processingResult", getProcessingResult())
            .toString();
    }
}
