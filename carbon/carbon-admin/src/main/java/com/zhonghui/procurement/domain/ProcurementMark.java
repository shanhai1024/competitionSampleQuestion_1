package com.zhonghui.procurement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 采购—标表
 *
 * @TableName procurement_mark
 */
public class ProcurementMark implements Serializable {

    /**
     * 标id
     */
    @ApiModelProperty("标id")
    private Integer markId;
    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("结束时间")
    private Date endTime;
    /**
     * 招标公告id
     */
    @ApiModelProperty("招标公告id")
    private Integer announcementId;
    /**
     * 投标状态 (0报名成功、1已过期、2资质审核、3待开标、4开标结果)
     */
    @ApiModelProperty("投标状态 (0报名成功、1已过期、2资质审核、3待开标、4开标结果)")
    private Integer bidType;
    /**
     * 标标题
     */
    @ApiModelProperty("标标题")
    private String title;

    public Integer getMarkId() {
        return markId;
    }

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Integer announcementId) {
        this.announcementId = announcementId;
    }

    public Integer getBidType() {
        return bidType;
    }

    public void setBidType(Integer bidType) {
        this.bidType = bidType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ProcurementMark{" +
                "markId=" + markId +
                ", endTime=" + endTime +
                ", announcementId=" + announcementId +
                ", bidType=" + bidType +
                ", title='" + title + '\'' +
                '}';
    }
}
