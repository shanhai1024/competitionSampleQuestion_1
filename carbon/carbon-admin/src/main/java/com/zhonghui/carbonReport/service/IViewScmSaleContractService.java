package com.zhonghui.carbonReport.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.zhonghui.carbonReport.domain.ViewScmFinanceReport;
import com.zhonghui.carbonReport.domain.ViewScmSaleContract;

/**
 * 销售合同报表Service接口
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
public interface IViewScmSaleContractService 
{
    /**
     * 查询销售合同报表
     * 
     * @param contractId 销售合同报表主键
     * @return 销售合同报表
     */
    public ViewScmSaleContract selectViewScmSaleContractById(Long contractId);

    /**
     * 查询销售合同报表列表
     * 
     * @param viewScmSaleContract 销售合同报表
     * @return 销售合同报表集合
     */
    public List<ViewScmSaleContract> selectViewScmSaleContractList(ViewScmSaleContract viewScmSaleContract);

    /**
     * 查询按月统计销售合同报表列表
     *
     * @param viewScmSaleContract 销售合同报表
     * @return 销售合同报表集合
     */
    public List<ViewScmSaleContract> selectMonthSaleContractReport(ViewScmSaleContract viewScmSaleContract);

    /**
     * 查询按季度统计销售合同报表列表
     *
     * @param viewScmSaleContract 销售合同报表
     * @return 销售合同报表集合
     */
    public List<ViewScmSaleContract> selectQuarterSaleContractReport(ViewScmSaleContract viewScmSaleContract);


    /**
     * 订单收款月统计
     *
     * @param viewScmSaleContract 销售合同报表
     * @return 销售合同报表集合
     */
    public List<ViewScmSaleContract> selectMonthOrderStatReport(ViewScmSaleContract viewScmSaleContract);

    /**
     * 订单收款季度统计
     *
     * @param viewScmSaleContract 销售合同报表
     * @return 销售合同报表集合
     */
    public List<ViewScmSaleContract> selectQuarterOrderStatReport(ViewScmSaleContract viewScmSaleContract);



    /**
     * 财务收支月份统计
     *
     * @return 销售合同报表
     */
    public List<ViewScmFinanceReport> selectMonthFinanceReport(ViewScmFinanceReport viewScmFinanceReport);


    /**
     * 财务收支季度统计
     *
     * @return 销售合同报表
     */
    public List<ViewScmFinanceReport> selectQuarterFinanceReport(ViewScmFinanceReport viewScmFinanceReport);


    /**
     * 客户销售排名
     * @return
     */
    List<Map<String, BigDecimal>> selectSaleCustomerRank();

    /**
     * 按月统计销售额
     * @param month
     * @return
     */
    public Map<String, BigDecimal> selectSaleStatByMonth(String month);

    /**
     * 大屏销售总览
     * @return
     */
    public Map<String,BigDecimal> selectSaleOverall();

}
