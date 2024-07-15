package com.zhonghui.carbonReport.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.carbonReport.mapper.ViewMesProductPowerDetailsMapper;
import com.zhonghui.carbonReport.domain.ViewMesProductPowerDetails;
import com.zhonghui.carbonReport.service.IViewMesProductPowerDetailsService;

/**
 * 产品能耗报表Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@Service
public class ViewMesProductPowerDetailsServiceImpl implements IViewMesProductPowerDetailsService 
{
    @Autowired
    private ViewMesProductPowerDetailsMapper viewMesProductPowerDetailsMapper;

    /**
     * 查询产品能耗报表
     * 
     * @param productionPlanId 产品能耗报表主键
     * @return 产品能耗报表
     */
    @Override
    public ViewMesProductPowerDetails selectViewMesProductPowerDetailsByFactoryId(Long productionPlanId)
    {
        return viewMesProductPowerDetailsMapper.selectViewMesProductPowerDetailsByFactoryId(productionPlanId);
    }

    /**
     * 查询产品能耗报表列表
     * 
     * @param viewMesProductPowerDetails 产品能耗报表
     * @return 产品能耗报表
     */
    @Override
    public List<ViewMesProductPowerDetails> selectViewMesProductPowerDetailsList(ViewMesProductPowerDetails viewMesProductPowerDetails)
    {
        return viewMesProductPowerDetailsMapper.selectViewMesProductPowerDetailsList(viewMesProductPowerDetails);
    }

    @Override
    public List<ViewMesProductPowerDetails> selectProductPowerReportByMonth(ViewMesProductPowerDetails viewMesProductPowerDetails) {
        return viewMesProductPowerDetailsMapper.selectProductPowerReportByMonth(viewMesProductPowerDetails);
    }

    @Override
    public List<ViewMesProductPowerDetails> selectProductPowerReportByYear(ViewMesProductPowerDetails viewMesProductPowerDetails) {
        return viewMesProductPowerDetailsMapper.selectProductPowerReportByYear(viewMesProductPowerDetails);
    }

    @Override
    public List<ViewMesProductPowerDetails> selectReportMonth(ViewMesProductPowerDetails viewMesProductPowerDetails) {
        return viewMesProductPowerDetailsMapper.selectReportMonth(viewMesProductPowerDetails);
    }

    @Override
    public List<ViewMesProductPowerDetails> selectProductPowerReportByDay(ViewMesProductPowerDetails viewMesProductPowerDetails) {
        return viewMesProductPowerDetailsMapper.selectProductPowerReportByDay(viewMesProductPowerDetails);
    }
}
