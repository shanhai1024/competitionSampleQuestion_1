package com.zhonghui.procurement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

/**
 * 投诉表 procurement_complaint
 */
@ApiModel("采购管理系统-投诉对象")
public class ProcurementComplaint {
    /**
     * 投诉id
     */
    @Excel(name = "投诉id")
    @ApiModelProperty("投诉id")
    private Integer complaintId;

    /**
     * 投诉标题
     */
    @Excel(name = "投诉标题")
    @ApiModelProperty("投诉标题")
    private String title;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("创建时间")
    private Date creationTime;

    /**
     * 处理状态（0：未处理，1：已处理）
     */
    @Excel(name = "处理状态（0：未处理，1：已处理）")
    @ApiModelProperty("处理状态（0：未处理，1：已处理）")
    private Integer complaintType;

    /**
     * 联系电话
     */
    @Excel(name = "联系电话")
    @ApiModelProperty("联系电话")
    private String contactNumber;

    /**
     * 联系人
     */
    @Excel(name = "联系人")
    @ApiModelProperty("联系人")
    private String contactPerson;

    /**
     * 附件地址
     */
    @Excel(name = "附件地址")
    @ApiModelProperty("附件地址")
    private String attachment;

    /**
     * 投诉内容
     */
    @Excel(name = "投诉内容")
    @ApiModelProperty("投诉内容")
    private String complaintText;

    /**
     * 处理结果
     */
    @Excel(name = "处理结果")
    @ApiModelProperty("处理结果")
    private String processingResult;

    public ProcurementComplaint() {
    }

    public ProcurementComplaint(Integer complaintId, String title, Date creationTime, Integer complaintType, String contactNumber, String contactPerson, String attachment, String complaintText, String processingResult) {
        this.complaintId = complaintId;
        this.title = title;
        this.creationTime = creationTime;
        this.complaintType = complaintType;
        this.contactNumber = contactNumber;
        this.contactPerson = contactPerson;
        this.attachment = attachment;
        this.complaintText = complaintText;
        this.processingResult = processingResult;
    }

    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(Integer complaintType) {
        this.complaintType = complaintType;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getComplaintText() {
        return complaintText;
    }

    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }

    public String getProcessingResult() {
        return processingResult;
    }

    public void setProcessingResult(String processingResult) {
        this.processingResult = processingResult;
    }

    @Override
    public String toString() {
        return "procurementComplaint{" +
                "complaintId=" + complaintId +
                ", title='" + title + '\'' +
                ", creationTime=" + creationTime +
                ", complaintType=" + complaintType +
                ", contactNumber='" + contactNumber + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", attachment='" + attachment + '\'' +
                ", complaintText='" + complaintText + '\'' +
                ", processingResult='" + processingResult + '\'' +
                '}';
    }
}
