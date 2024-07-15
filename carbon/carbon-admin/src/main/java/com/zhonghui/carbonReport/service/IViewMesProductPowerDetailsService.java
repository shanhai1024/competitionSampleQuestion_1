package com.zhonghui.carbonReport.service;

import java.util.List;
import com.zhonghui.carbonReport.domain.ViewMesProductPowerDetails;

/**
 * 产品能耗报表Service接口
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
public interface IViewMesProductPowerDetailsService 
{
    /**
     * 查询产品能耗报表
     * 
     * @param productionPlanId 产品能耗报表主键
     * @return 产品能耗报表
     */
    public ViewMesProductPowerDetails selectViewMesProductPowerDetailsByFactoryId(Long productionPlanId);

    /**
     * 查询产品能耗报表列表
     * 
     * @param viewMesProductPowerDetails 产品能耗报表
     * @return 产品能耗报表集合
     */
    public List<ViewMesProductPowerDetails> selectViewMesProductPowerDetailsList(ViewMesProductPowerDetails viewMesProductPowerDetails);

    /**
     * 生产能耗月度报表
     * @param viewMesProductPowerDetails 产品能耗报表
     * @return 生产能耗月度报表
     */
    public List<ViewMesProductPowerDetails> selectProductPowerReportByMonth(ViewMesProductPowerDetails viewMesProductPowerDetails);

    /**
     * 生产能耗年度报表
     * @param viewMesProductPowerDetails 产品能耗报表
     * @return 生产能耗年度报表
     */
    public List<ViewMesProductPowerDetails> selectProductPowerReportByYear(ViewMesProductPowerDetails viewMesProductPowerDetails);

    /**
     * 获取统计的月份
     * @param viewMesProductPowerDetails 产品能耗报表
     * @return 获取统计的月份
     */
    public List<ViewMesProductPowerDetails> selectReportMonth(ViewMesProductPowerDetails viewMesProductPowerDetails);

    /**
     * 生产能耗日报表
     * @param viewMesProductPowerDetails 产品能耗报表
     * @return 生产能耗日报表
     */
    public List<ViewMesProductPowerDetails> selectProductPowerReportByDay(ViewMesProductPowerDetails viewMesProductPowerDetails);
}
