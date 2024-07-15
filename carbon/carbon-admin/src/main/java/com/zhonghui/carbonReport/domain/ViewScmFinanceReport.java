package com.zhonghui.carbonReport.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 收支统计
 *
 * @author zhonghui
 * @date 2022-05-28
 */
@ApiModel("收支统计")
@Data
public class ViewScmFinanceReport extends BaseEntity {

    @Excel(name = "年份")
    @ApiModelProperty("年份")
    private String year;

    @Excel(name = "季度")
    @ApiModelProperty("季度")
    private String quarter;

    @Excel(name = "月份")
    @ApiModelProperty("月份")
    private String month;

    @Excel(name = "采购合同金额")
    @ApiModelProperty("采购合同金额")
    private BigDecimal purchaseContractTotal;

    @Excel(name = "采购退款金额")
    @ApiModelProperty("采购退款金额")
    private BigDecimal purchaseReturnTotal;

    @Excel(name = "销售合同金额")
    @ApiModelProperty("销售合同金额")
    private BigDecimal saleContractTotal;

    @Excel(name = "销售退款金额")
    @ApiModelProperty("销售退款金额")
    private BigDecimal saleReturnTotal;

    @Excel(name = "收入总金额")
    @ApiModelProperty("收入总金额")
    private BigDecimal incomeTotal;

    @Excel(name = "支出总金额")
    @ApiModelProperty("支出总金额")
    private BigDecimal outcomeTotal;
}
