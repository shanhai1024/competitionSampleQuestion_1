package com.zhonghui.carbonReport.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.carbonReport.mapper.ViewMesDevicePowerDetailsMapper;
import com.zhonghui.carbonReport.domain.ViewMesDevicePowerDetails;
import com.zhonghui.carbonReport.service.IViewMesDevicePowerDetailsService;

/**
 * 设备能耗数据采集Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@Service
public class ViewMesDevicePowerDetailsServiceImpl implements IViewMesDevicePowerDetailsService 
{
    @Autowired
    private ViewMesDevicePowerDetailsMapper viewMesDevicePowerDetailsMapper;

    /**
     * 查询设备能耗数据采集
     * 
     * @param deviceId 设备能耗数据采集主键
     * @return 设备能耗数据采集
     */
    @Override
    public ViewMesDevicePowerDetails selectViewMesDevicePowerDetailsByDeviceId(Long deviceId)
    {
        return viewMesDevicePowerDetailsMapper.selectViewMesDevicePowerDetailsByDeviceId(deviceId);
    }

    /**
     * 查询设备能耗数据采集列表
     * 
     * @param viewMesDevicePowerDetails 设备能耗数据采集
     * @return 设备能耗数据采集
     */
    @Override
    public List<ViewMesDevicePowerDetails> selectViewMesDevicePowerDetailsList(ViewMesDevicePowerDetails viewMesDevicePowerDetails)
    {
        return viewMesDevicePowerDetailsMapper.selectViewMesDevicePowerDetailsList(viewMesDevicePowerDetails);
    }

    /**
     * 查询设备日能耗报表
     *
     * @param viewMesDevicePowerDetails 查询设备日能耗报表
     * @return 设备日能耗报表
     */
    @Override
    public List<ViewMesDevicePowerDetails> selectDevicePowerReportByDay(ViewMesDevicePowerDetails viewMesDevicePowerDetails) {
        return viewMesDevicePowerDetailsMapper.selectDevicePowerReportByDay(viewMesDevicePowerDetails);
    }
}
