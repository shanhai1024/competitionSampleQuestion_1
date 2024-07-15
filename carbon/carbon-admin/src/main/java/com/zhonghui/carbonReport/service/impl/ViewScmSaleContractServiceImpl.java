package com.zhonghui.carbonReport.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.zhonghui.carbonReport.domain.ViewScmFinanceReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.carbonReport.mapper.ViewScmSaleContractMapper;
import com.zhonghui.carbonReport.domain.ViewScmSaleContract;
import com.zhonghui.carbonReport.service.IViewScmSaleContractService;

/**
 * 销售合同报表Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@Service
public class ViewScmSaleContractServiceImpl implements IViewScmSaleContractService 
{
    @Autowired
    private ViewScmSaleContractMapper viewScmSaleContractMapper;

    /**
     * 查询销售合同报表
     * 
     * @param contractId 销售合同报表主键
     * @return 销售合同报表
     */
    @Override
    public ViewScmSaleContract selectViewScmSaleContractById(Long contractId)
    {
        return viewScmSaleContractMapper.selectViewScmSaleContractById(contractId);
    }

    /**
     * 查询销售合同报表列表
     * 
     * @param viewScmSaleContract 销售合同报表
     * @return 销售合同报表
     */
    @Override
    public List<ViewScmSaleContract> selectViewScmSaleContractList(ViewScmSaleContract viewScmSaleContract)
    {
        return viewScmSaleContractMapper.selectViewScmSaleContractList(viewScmSaleContract);
    }

    /**
     * 查询按月统计销售合同报表列表
     *
     * @param viewScmSaleContract 销售合同报表
     * @return 销售合同报表集合
     */
    @Override
    public List<ViewScmSaleContract> selectMonthSaleContractReport(ViewScmSaleContract viewScmSaleContract){
        return viewScmSaleContractMapper.selectMonthSaleContractReport(viewScmSaleContract);
    }


    /**
     * 查询按季度统计销售合同报表列表
     *
     * @param viewScmSaleContract 销售合同报表
     * @return 销售合同报表集合
     */
    @Override
    public List<ViewScmSaleContract> selectQuarterSaleContractReport(ViewScmSaleContract viewScmSaleContract){
        return viewScmSaleContractMapper.selectQuarterSaleContractReport(viewScmSaleContract);
    }

    /**
     * 查询按季度统计销售合同报表列表
     *
     * @param viewScmSaleContract 销售合同报表
     * @return 销售合同报表集合
     */
    @Override
    public List<ViewScmSaleContract> selectMonthOrderStatReport(ViewScmSaleContract viewScmSaleContract){
        return viewScmSaleContractMapper.selectMonthOrderStatReport(viewScmSaleContract);
    }

    /**
     * 订单收款季度统计
     *
     * @param viewScmSaleContract 销售合同报表
     * @return 销售合同报表集合
     */
    @Override
    public List<ViewScmSaleContract> selectQuarterOrderStatReport(ViewScmSaleContract viewScmSaleContract){
        return viewScmSaleContractMapper.selectQuarterOrderStatReport(viewScmSaleContract);
    }

    /**
     * 财务收支统计
     *
     * @return 销售合同报表集合
     */
    @Override
    public List<ViewScmFinanceReport> selectMonthFinanceReport(ViewScmFinanceReport viewScmFinanceReport) {
        return viewScmSaleContractMapper.selectMonthFinanceReport(viewScmFinanceReport);
    }

    /**
     * 财务收支统计
     *
     * @return 销售合同报表集合
     */
    @Override
    public List<ViewScmFinanceReport> selectQuarterFinanceReport(ViewScmFinanceReport viewScmFinanceReport) {
        return viewScmSaleContractMapper.selectQuarterFinanceReport(viewScmFinanceReport);
    }

    /**
     * 客户销售排名
     * @return
     */
    @Override
    public List<Map<String, BigDecimal>> selectSaleCustomerRank() {
        return viewScmSaleContractMapper.selectSaleCustomerRank();
    }

    /**
     * 按月统计销售额
     * @param month
     * @return
     */
    @Override
    public Map<String, BigDecimal> selectSaleStatByMonth(String month) {
        return viewScmSaleContractMapper.selectSaleStatByMonth(month);
    }

    /**
     * 大屏销售总览
     * @return
     */
    @Override
    public Map<String, BigDecimal> selectSaleOverall() {
        return viewScmSaleContractMapper.selectSaleOverall();
    }
}
