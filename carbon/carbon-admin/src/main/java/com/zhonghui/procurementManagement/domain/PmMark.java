package com.zhonghui.procurementManagement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 参与投标表对象 procurement_mark
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
public class PmMark extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标id */
    @Excel(name = "标id")
    private Long markId;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 招标公告id */
    @Excel(name = "招标公告id")
    private Long announcementId;

    /** 投标状态 */
    @Excel(name = "投标状态")
    private Long bidType;

    /** 标标题 */
    @Excel(name = "标标题")
    private String title;

    public void setMarkId(Long markId) 
    {
        this.markId = markId;
    }

    public Long getMarkId() 
    {
        return markId;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setAnnouncementId(Long announcementId) 
    {
        this.announcementId = announcementId;
    }

    public Long getAnnouncementId() 
    {
        return announcementId;
    }
    public void setBidType(Long bidType) 
    {
        this.bidType = bidType;
    }

    public Long getBidType() 
    {
        return bidType;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("markId", getMarkId())
            .append("endTime", getEndTime())
            .append("announcementId", getAnnouncementId())
            .append("bidType", getBidType())
            .append("title", getTitle())
            .toString();
    }
}
