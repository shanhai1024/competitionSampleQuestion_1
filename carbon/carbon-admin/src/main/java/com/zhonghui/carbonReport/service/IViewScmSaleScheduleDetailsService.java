package com.zhonghui.carbonReport.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.zhonghui.carbonReport.domain.ViewScmSaleScheduleDetails;

/**
 * 销售计划达成率报表Service接口
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
public interface IViewScmSaleScheduleDetailsService 
{
    /**
     * 查询销售计划达成率报表列表
     * 
     * @param viewScmSaleScheduleDetails 销售计划达成率报表
     * @return 销售计划达成率报表集合
     */
    public List<ViewScmSaleScheduleDetails> selectViewScmSaleScheduleDetailsList(ViewScmSaleScheduleDetails viewScmSaleScheduleDetails);

    /**
     * 按月统计计划销售额与实际销售额
     * @param month
     * @return
     */
    public Map<String, BigDecimal> selectAchieveRateByMonth(String month);
}
