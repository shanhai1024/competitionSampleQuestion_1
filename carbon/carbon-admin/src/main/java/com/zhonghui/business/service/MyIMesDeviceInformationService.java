package com.zhonghui.business.service;

import java.util.List;
import com.zhonghui.business.domain.MyMesDeviceInformation;

/**
 * 设备信息管理Service接口
 *
 * @author shanhai1024
 * @date 2024-07-01
 */
public interface MyIMesDeviceInformationService
{
    /**
     * 查询设备信息管理
     *
     * @param id 设备信息管理主键
     * @return 设备信息管理
     */
    public MyMesDeviceInformation selectMesDeviceInformationById(Long id);

    /**
     * 查询设备信息管理列表
     *
     * @param mesDeviceInformation 设备信息管理
     * @return 设备信息管理集合
     */
    public List<MyMesDeviceInformation> selectMesDeviceInformationList(MyMesDeviceInformation mesDeviceInformation);

    /**
     * 新增设备信息管理
     *
     * @param mesDeviceInformation 设备信息管理
     * @return 结果
     */
    public int insertMesDeviceInformation(MyMesDeviceInformation mesDeviceInformation);

    /**
     * 修改设备信息管理
     *
     * @param mesDeviceInformation 设备信息管理
     * @return 结果
     */
    public int updateMesDeviceInformation(MyMesDeviceInformation mesDeviceInformation);

    /**
     * 批量删除设备信息管理
     *
     * @param ids 需要删除的设备信息管理主键集合
     * @return 结果
     */
    public int deleteMesDeviceInformationByIds(Long[] ids);

    /**
     * 删除设备信息管理信息
     *
     * @param id 设备信息管理主键
     * @return 结果
     */
    public int deleteMesDeviceInformationById(Long id);
}
