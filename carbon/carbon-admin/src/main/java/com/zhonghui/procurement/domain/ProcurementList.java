package com.zhonghui.procurement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
* 采购—公告法规动态
* @TableName procurement_list
*/
public class ProcurementList implements Serializable {

    /**
    * 列表id
    */
    @ApiModelProperty("列表id")
    private Integer listId;
    /**
    * 标题
    */
    @ApiModelProperty("标题")
    private String title;
    /**
    * 发布时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("发布时间")
    private Date releaseTime;
    /**
    * 内容
    */
    @ApiModelProperty("内容")
    private String text;
    /**
    * 附件下载地址
    */
    @ApiModelProperty("附件下载地址")
    private String attachment;
    /**
    * 发布者/发布企业
    */
    @ApiModelProperty("发布者/发布企业")
    private String publisher;
    /**
    * 类型 1公告，2法规，3动态
    */
    @ApiModelProperty("类型 1公告，2法规，3动态")
    private Integer listType;
    /**
    * 公告分类  1招标预告 2招标公告 3 中标公告 4企业采购
    */
    @ApiModelProperty("公告分类  1招标预告 2招标公告 3 中标公告 4企业采购")
    private String announcementType;

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getListType() {
        return listType;
    }

    public void setListType(Integer listType) {
        this.listType = listType;
    }

    public String getAnnouncementType() {
        return announcementType;
    }

    public void setAnnouncementType(String announcementType) {
        this.announcementType = announcementType;
    }
}
