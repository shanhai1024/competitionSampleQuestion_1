package com.zhonghui.procurementManagement.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 我的投标对象 procurement_have_bid
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
public class PmBid extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 标id */
    @Excel(name = "标id")
    private Long bidId;

    /** 企业资料快照id */
    @Excel(name = "企业资料快照id")
    private Long snapshotInformation;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 提交资料 */
    @Excel(name = "提交资料")
    private String information;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBidId(Long bidId) 
    {
        this.bidId = bidId;
    }

    public Long getBidId() 
    {
        return bidId;
    }
    public void setSnapshotInformation(Long snapshotInformation) 
    {
        this.snapshotInformation = snapshotInformation;
    }

    public Long getSnapshotInformation() 
    {
        return snapshotInformation;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setInformation(String information) 
    {
        this.information = information;
    }

    public String getInformation() 
    {
        return information;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bidId", getBidId())
            .append("snapshotInformation", getSnapshotInformation())
            .append("userId", getUserId())
            .append("information", getInformation())
            .toString();
    }
}
