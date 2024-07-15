package com.zhonghui.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.business.mapper.MyMesDeviceInformationMapper;
import com.zhonghui.business.domain.MyMesDeviceInformation;
import com.zhonghui.business.service.MyIMesDeviceInformationService;

/**
 * 设备信息管理Service业务层处理
 *
 * @author shanhai1024
 * @date 2024-07-01
 */
@Service
public class MyMesDeviceInformationServiceImpl implements MyIMesDeviceInformationService
{
    @Autowired
    private MyMesDeviceInformationMapper mesDeviceInformationMapper;

    /**
     * 查询设备信息管理
     *
     * @param id 设备信息管理主键
     * @return 设备信息管理
     */
    @Override
    public MyMesDeviceInformation selectMesDeviceInformationById(Long id)
    {
        return mesDeviceInformationMapper.selectMesDeviceInformationById(id);
    }

    /**
     * 查询设备信息管理列表
     *
     * @param mesDeviceInformation 设备信息管理
     * @return 设备信息管理
     */
    @Override
    public List<MyMesDeviceInformation> selectMesDeviceInformationList(MyMesDeviceInformation mesDeviceInformation)
    {
        return mesDeviceInformationMapper.selectMesDeviceInformationList(mesDeviceInformation);
    }

    /**
     * 新增设备信息管理
     *
     * @param mesDeviceInformation 设备信息管理
     * @return 结果
     */
    @Override
    public int insertMesDeviceInformation(MyMesDeviceInformation mesDeviceInformation)
    {
        return mesDeviceInformationMapper.insertMesDeviceInformation(mesDeviceInformation);
    }

    /**
     * 修改设备信息管理
     *
     * @param mesDeviceInformation 设备信息管理
     * @return 结果
     */
    @Override
    public int updateMesDeviceInformation(MyMesDeviceInformation mesDeviceInformation)
    {
        return mesDeviceInformationMapper.updateMesDeviceInformation(mesDeviceInformation);
    }

    /**
     * 批量删除设备信息管理
     *
     * @param ids 需要删除的设备信息管理主键
     * @return 结果
     */
    @Override
    public int deleteMesDeviceInformationByIds(Long[] ids)
    {
        return mesDeviceInformationMapper.deleteMesDeviceInformationByIds(ids);
    }

    /**
     * 删除设备信息管理信息
     *
     * @param id 设备信息管理主键
     * @return 结果
     */
    @Override
    public int deleteMesDeviceInformationById(Long id)
    {
        return mesDeviceInformationMapper.deleteMesDeviceInformationById(id);
    }
}
