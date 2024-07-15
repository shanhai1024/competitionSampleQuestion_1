package com.zhonghui.wms.domain;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;

/**
 * 物料档案对象 wms_material
 *
 * @author zhonghui
 * @date 2022-05-19
 */
@ApiModel("物料档案对象")
public class WmsMaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料档案ID */
    @Excel(name = "编号")
    @ApiModelProperty("编号")
    private Long id;

    /** 物料分类ID */
    @Excel(name = "物料分类ID")
    @ApiModelProperty("物料分类ID")
    private Long classifyId;

    /** 物料编码 */
    @Excel(name = "物料编码")
    @ApiModelProperty("物料编码")
    private String materialCode;

    /** 物料名称 */
    @Excel(name = "物料名称")
    @ApiModelProperty("物料名称")
    private String materialName;

    /** 型号 */
    @Excel(name = "型号")
    @ApiModelProperty("型号")
    private String materialModel;

    /** 规格 */
    @Excel(name = "规格")
    @ApiModelProperty("规格")
    private String materialSpecifications;

    /** 单位 */
    @Excel(name = "单位")
    @ApiModelProperty("单位")
    private String materialUnit;

    /** 单价 */
    @Excel(name = "单价")
    @ApiModelProperty("单价")
    private BigDecimal materialPrice;

    /** 类型 */
    @Excel(name = "类型")
    @ApiModelProperty("类型")
    private Long materialType;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setClassifyId(Long classifyId)
    {
        this.classifyId = classifyId;
    }

    public Long getClassifyId()
    {
        return classifyId;
    }
    public void setMaterialCode(String materialCode)
    {
        this.materialCode = materialCode;
    }

    public String getMaterialCode()
    {
        return materialCode;
    }
    public void setMaterialName(String materialName)
    {
        this.materialName = materialName;
    }

    public String getMaterialName()
    {
        return materialName;
    }
    public void setMaterialModel(String materialModel)
    {
        this.materialModel = materialModel;
    }

    public String getMaterialModel()
    {
        return materialModel;
    }
    public void setMaterialSpecifications(String materialSpecifications)
    {
        this.materialSpecifications = materialSpecifications;
    }

    public String getMaterialSpecifications()
    {
        return materialSpecifications;
    }
    public void setMaterialUnit(String materialUnit)
    {
        this.materialUnit = materialUnit;
    }

    public String getMaterialUnit()
    {
        return materialUnit;
    }
    public void setMaterialPrice(BigDecimal materialPrice)
    {
        this.materialPrice = materialPrice;
    }

    public BigDecimal getMaterialPrice()
    {
        return materialPrice;
    }
    public void setMaterialType(Long materialType)
    {
        this.materialType = materialType;
    }

    public Long getMaterialType()
    {
        return materialType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("classifyId", getClassifyId())
            .append("materialCode", getMaterialCode())
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialSpecifications", getMaterialSpecifications())
            .append("materialUnit", getMaterialUnit())
            .append("materialPrice", getMaterialPrice())
            .append("materialType", getMaterialType())
            .append("remark", getRemark())
            .toString();
    }
}
