package com.zhonghui.common.core.domain.entity;

import com.zhonghui.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhonghui.common.annotation.Excel;

import java.util.ArrayList;
import java.util.List;

/**
 * 物料分类对象 wms_material_classify
 * 
 * @author zhonghui
 * @date 2022-05-19
 */
public class WmsMaterialClassify extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料分类ID */
    private Long id;

    /** 父级ID */
    @Excel(name = "父级ID")
    private Long pid;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String name;

    /** 分类编号 */
    @Excel(name = "分类编号")
    private String code;

    /** 子菜单 */
    private List<WmsMaterialClassify> children = new ArrayList<WmsMaterialClassify>();

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPid(Long pid) 
    {
        this.pid = pid;
    }

    public Long getPid() 
    {
        return pid;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }

    public List<WmsMaterialClassify> getChildren()
    {
        return children;
    }

    public void setChildren(List<WmsMaterialClassify> children)
    {
        this.children = children;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pid", getPid())
            .append("name", getName())
            .append("code", getCode())
            .append("remark", getRemark())
            .toString();
    }
}
