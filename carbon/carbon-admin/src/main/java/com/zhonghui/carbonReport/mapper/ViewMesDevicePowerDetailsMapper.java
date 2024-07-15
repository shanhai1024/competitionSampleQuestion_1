package com.zhonghui.carbonReport.mapper;

import java.util.List;
import com.zhonghui.carbonReport.domain.ViewMesDevicePowerDetails;

/**
 * 设备能耗数据采集Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
public interface ViewMesDevicePowerDetailsMapper 
{
    /**
     * 查询设备能耗数据采集
     * 
     * @param deviceId 设备能耗数据采集主键
     * @return 设备能耗数据采集
     */
    public ViewMesDevicePowerDetails selectViewMesDevicePowerDetailsByDeviceId(Long deviceId);

    /**
     * 查询设备能耗数据采集列表
     * 
     * @param viewMesDevicePowerDetails 设备能耗数据采集
     * @return 设备能耗数据采集集合
     */
    public List<ViewMesDevicePowerDetails> selectViewMesDevicePowerDetailsList(ViewMesDevicePowerDetails viewMesDevicePowerDetails);

    /**
     * 查询设备日能耗报表
     * @param viewMesDevicePowerDetails
     * @return
     */
    public List<ViewMesDevicePowerDetails> selectDevicePowerReportByDay(ViewMesDevicePowerDetails viewMesDevicePowerDetails);
}
