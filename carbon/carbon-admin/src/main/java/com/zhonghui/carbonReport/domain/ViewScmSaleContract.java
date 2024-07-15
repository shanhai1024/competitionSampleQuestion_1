package com.zhonghui.carbonReport.domain;

import java.math.BigDecimal;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 销售合同报表对象 view_scm_sale_contract
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@ApiModel("销售合同报表对象")
public class ViewScmSaleContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同id */
    @ApiModelProperty("合同id")
    private Long contractId;

    /** 合同编号 */
    @Excel(name = "合同编号")
    @ApiModelProperty("合同编号")
    private String contractNumber;

    /** 销售订单id */
    @Excel(name = "销售订单id")
    @ApiModelProperty("销售订单id")
    private Long orderId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    @ApiModelProperty("订单编号")
    private String orderNo;

    /** 客户id */
    @Excel(name = "客户id")
    @ApiModelProperty("客户id")
    private Long customId;

    /** 客户名称 */
    @Excel(name = "客户名称")
    @ApiModelProperty("客户名称")
    private String customName;

    /** 合同金额 */
    @Excel(name = "合同金额")
    @ApiModelProperty("合同金额")
    private BigDecimal contractAmount;

    /** 合同年份 */
    @Excel(name = "合同年份")
    @ApiModelProperty("合同年份")
    private String contractYear;

    /** 合同季度 */
    @Excel(name = "合同季度")
    @ApiModelProperty("合同季度")
    private String contractQuarter;

    /** 合同月份 */
    @Excel(name = "合同月份")
    @ApiModelProperty("合同月份")
    private String contractMonth;

    /** 合同年月 */
    @Excel(name = "合同年月")
    @ApiModelProperty("合同年月")
    private String contractYearMonth;

    /** 合同日期 */
    @Excel(name = "合同日期")
    @ApiModelProperty("合同日期")
    private String contractDate;

    @ApiModelProperty("总金额")
    @Excel(name = "总金额")
    private BigDecimal totalAmount;

    public void setContractId(Long contractId)
    {
        this.contractId = contractId;
    }

    public Long getContractId()
    {
        return contractId;
    }
    public void setContractNumber(String contractNumber)
    {
        this.contractNumber = contractNumber;
    }

    public String getContractNumber()
    {
        return contractNumber;
    }
    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Long getOrderId()
    {
        return orderId;
    }
    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo()
    {
        return orderNo;
    }
    public void setCustomId(Long customId)
    {
        this.customId = customId;
    }

    public Long getCustomId()
    {
        return customId;
    }
    public void setCustomName(String customName)
    {
        this.customName = customName;
    }

    public String getCustomName()
    {
        return customName;
    }
    public void setContractAmount(BigDecimal contractAmount)
    {
        this.contractAmount = contractAmount;
    }

    public BigDecimal getContractAmount()
    {
        return contractAmount;
    }
    public void setContractYear(String contractYear)
    {
        this.contractYear = contractYear;
    }

    public String getContractYear()
    {
        return contractYear;
    }
    public void setContractQuarter(String contractQuarter)
    {
        this.contractQuarter = contractQuarter;
    }

    public String getContractQuarter()
    {
        return contractQuarter;
    }
    public void setContractMonth(String contractMonth)
    {
        this.contractMonth = contractMonth;
    }

    public String getContractMonth()
    {
        return contractMonth;
    }
    public void setContractYearMonth(String contractYearMonth)
    {
        this.contractYearMonth = contractYearMonth;
    }

    public String getContractYearMonth()
    {
        return contractYearMonth;
    }
    public void setContractDate(String contractDate)
    {
        this.contractDate = contractDate;
    }

    public String getContractDate()
    {
        return contractDate;
    }
    public void setTotalAmount(BigDecimal totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount()
    {
        return totalAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("contractId", getContractId())
            .append("contractNumber", getContractNumber())
            .append("orderId", getOrderId())
            .append("orderNo", getOrderNo())
            .append("customId", getCustomId())
            .append("customName", getCustomName())
            .append("contractAmount", getContractAmount())
            .append("contractYear", getContractYear())
            .append("contractQuarter", getContractQuarter())
            .append("contractMonth", getContractMonth())
            .append("contractYearMonth", getContractYearMonth())
            .append("contractDate", getContractDate())
            .append("totalAmount", getTotalAmount())
            .toString();
    }
}
