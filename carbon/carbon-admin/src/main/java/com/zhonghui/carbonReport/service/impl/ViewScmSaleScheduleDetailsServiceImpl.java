package com.zhonghui.carbonReport.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.carbonReport.mapper.ViewScmSaleScheduleDetailsMapper;
import com.zhonghui.carbonReport.domain.ViewScmSaleScheduleDetails;
import com.zhonghui.carbonReport.service.IViewScmSaleScheduleDetailsService;

/**
 * 销售计划达成率报表Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Service
public class ViewScmSaleScheduleDetailsServiceImpl implements IViewScmSaleScheduleDetailsService 
{
    @Autowired
    private ViewScmSaleScheduleDetailsMapper viewScmSaleScheduleDetailsMapper;

    /**
     * 查询销售计划达成率报表列表
     * 
     * @param viewScmSaleScheduleDetails 销售计划达成率报表
     * @return 销售计划达成率报表
     */
    @Override
    public List<ViewScmSaleScheduleDetails> selectViewScmSaleScheduleDetailsList(ViewScmSaleScheduleDetails viewScmSaleScheduleDetails)
    {
        return viewScmSaleScheduleDetailsMapper.selectViewScmSaleScheduleDetailsList(viewScmSaleScheduleDetails);
    }

    /**
     * 按月统计计划销售额与实际销售额
     * @param month
     * @return
     */
    @Override
    public Map<String, BigDecimal> selectAchieveRateByMonth(String month) {
        return viewScmSaleScheduleDetailsMapper.selectAchieveRateByMonth(month);
    }
}
