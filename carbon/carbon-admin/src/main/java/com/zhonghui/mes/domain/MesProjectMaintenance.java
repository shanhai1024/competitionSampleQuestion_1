package com.zhonghui.mes.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;

/**
 * 项目维护对象 mes_project_maintenance
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
@ApiModel("项目维护对象")
public class MesProjectMaintenance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目维护id */
    @Excel(name = "项目维护id")
    @ApiModelProperty("id")
    private Integer id;

    /** 项目名 */
    @Excel(name = "项目名")
    @ApiModelProperty("项目名")
    private String projectName;

    /** 负责人 */
    @Excel(name = "负责人")
    @ApiModelProperty("负责人")
    private String projectHeader;

    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("开始日期")
    private Date startDate;

    /** 结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("结束日期")
    private Date endDate;

    /** 项目状态 */
    @Excel(name = "项目状态")
    @ApiModelProperty("项目状态")
    private Integer status;

    /** 项目介绍 */
    @ApiModelProperty("项目介绍")
    private String introduce;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setProjectHeader(String projectHeader) 
    {
        this.projectHeader = projectHeader;
    }

    public String getProjectHeader() 
    {
        return projectHeader;
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
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setIntroduce(String introduce) 
    {
        this.introduce = introduce;
    }

    public String getIntroduce() 
    {
        return introduce;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectName", getProjectName())
            .append("projectHeader", getProjectHeader())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("status", getStatus())
            .append("introduce", getIntroduce())
            .toString();
    }
}
