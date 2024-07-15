package com.zhonghui.mes.mapper;

import java.util.List;
import com.zhonghui.mes.domain.MesDeviceInformation;

/**
 * 设备信息Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
public interface MesDeviceInformationMapper 
{
    /**
     * 查询设备信息
     * 
     * @param id 设备信息主键
     * @return 设备信息
     */
    public MesDeviceInformation selectMesDeviceInformationById(Integer id);

    /**
     * 查询设备信息列表
     * 
     * @param mesDeviceInformation 设备信息
     * @return 设备信息集合
     */
    public List<MesDeviceInformation> selectMesDeviceInformationList(MesDeviceInformation mesDeviceInformation);

    /**
     * 新增设备信息
     * 
     * @param mesDeviceInformation 设备信息
     * @return 结果
     */
    public int insertMesDeviceInformation(MesDeviceInformation mesDeviceInformation);

    /**
     * 修改设备信息
     * 
     * @param mesDeviceInformation 设备信息
     * @return 结果
     */
    public int updateMesDeviceInformation(MesDeviceInformation mesDeviceInformation);

    /**
     * 删除设备信息
     * 
     * @param id 设备信息主键
     * @return 结果
     */
    public int deleteMesDeviceInformationById(Integer id);

    /**
     * 批量删除设备信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesDeviceInformationByIds(Integer[] ids);
}
