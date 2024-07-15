package com.zhonghui.carbonReport.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.zhonghui.carbonReport.domain.ViewScmFinanceReport;
import com.zhonghui.carbonReport.domain.ViewScmSaleContract;
import org.apache.ibatis.annotations.Param;

/**
 * 销售合同报表Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
public interface ViewScmSaleContractMapper 
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
     * 查询按月统计销售合同报表列表
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
     * 按季度统计财务报告
     * @param viewScmFinanceReport
     * @return
     */
    List<ViewScmFinanceReport> selectMonthFinanceReport(ViewScmFinanceReport viewScmFinanceReport);

    /**
     * 按月统计财务报告
     * @param viewScmFinanceReport
     * @return
     */
    List<ViewScmFinanceReport> selectQuarterFinanceReport(ViewScmFinanceReport viewScmFinanceReport);

    /**
     * 销售客户榜单
     * @param
     * @return
     */
    List<Map<String, BigDecimal>> selectSaleCustomerRank();

    /**
     * 按月统计销售额
     * @param month
     * @return
     */
    Map<String, BigDecimal> selectSaleStatByMonth(@Param("month") String month);


    /**
     * 大屏销售总览
     * @return
     */
    Map<String,BigDecimal> selectSaleOverall();
}
