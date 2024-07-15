package com.zhonghui.procurementManagement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 政策法规对象 procurement_list
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
public class PmPoliciesRegulations extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 列表id */
    private Integer listId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseTime;

    /** 内容 */
    private String text;

    /** 附件下载地址 */
    private String attachment;

    /** 发布者/发布企业 */
    @Excel(name = "发布者/发布企业")
    private String publisher;

    /** 类型 */
    private Integer listType;

    /** 公告分类 */
    private String announcementType;

    public void setListId(Integer listId) 
    {
        this.listId = listId;
    }

    public Integer getListId() 
    {
        return listId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setReleaseTime(Date releaseTime) 
    {
        this.releaseTime = releaseTime;
    }

    public Date getReleaseTime() 
    {
        return releaseTime;
    }
    public void setText(String text) 
    {
        this.text = text;
    }

    public String getText() 
    {
        return text;
    }
    public void setAttachment(String attachment) 
    {
        this.attachment = attachment;
    }

    public String getAttachment() 
    {
        return attachment;
    }
    public void setPublisher(String publisher) 
    {
        this.publisher = publisher;
    }

    public String getPublisher() 
    {
        return publisher;
    }
    public void setListType(Integer listType) 
    {
        this.listType = listType;
    }

    public Integer getListType() 
    {
        return listType;
    }
    public void setAnnouncementType(String announcementType) 
    {
        this.announcementType = announcementType;
    }

    public String getAnnouncementType() 
    {
        return announcementType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("listId", getListId())
            .append("title", getTitle())
            .append("releaseTime", getReleaseTime())
            .append("text", getText())
            .append("attachment", getAttachment())
            .append("publisher", getPublisher())
            .append("listType", getListType())
            .append("announcementType", getAnnouncementType())
            .toString();
    }
}
