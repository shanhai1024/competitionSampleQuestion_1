package com.zhonghui.mes.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.mes.mapper.MesDeviceInformationMapper;
import com.zhonghui.mes.domain.MesDeviceInformation;
import com.zhonghui.mes.service.IMesDeviceInformationService;

/**
 * 设备信息Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
@Service
public class MesDeviceInformationServiceImpl implements IMesDeviceInformationService 
{
    @Autowired
    private MesDeviceInformationMapper mesDeviceInformationMapper;

    /**
     * 查询设备信息
     * 
     * @param id 设备信息主键
     * @return 设备信息
     */
    @Override
    public MesDeviceInformation selectMesDeviceInformationById(Integer id)
    {
        return mesDeviceInformationMapper.selectMesDeviceInformationById(id);
    }

    /**
     * 查询设备信息列表
     * 
     * @param mesDeviceInformation 设备信息
     * @return 设备信息
     */
    @Override
    public List<MesDeviceInformation> selectMesDeviceInformationList(MesDeviceInformation mesDeviceInformation)
    {
        return mesDeviceInformationMapper.selectMesDeviceInformationList(mesDeviceInformation);
    }

    /**
     * 新增设备信息
     * 
     * @param mesDeviceInformation 设备信息
     * @return 结果
     */
    @Override
    public int insertMesDeviceInformation(MesDeviceInformation mesDeviceInformation)
    {
        return mesDeviceInformationMapper.insertMesDeviceInformation(mesDeviceInformation);
    }

    /**
     * 修改设备信息
     * 
     * @param mesDeviceInformation 设备信息
     * @return 结果
     */
    @Override
    public int updateMesDeviceInformation(MesDeviceInformation mesDeviceInformation)
    {
        return mesDeviceInformationMapper.updateMesDeviceInformation(mesDeviceInformation);
    }

    /**
     * 批量删除设备信息
     * 
     * @param ids 需要删除的设备信息主键
     * @return 结果
     */
    @Override
    public int deleteMesDeviceInformationByIds(Integer[] ids)
    {
        return mesDeviceInformationMapper.deleteMesDeviceInformationByIds(ids);
    }

    /**
     * 删除设备信息信息
     * 
     * @param id 设备信息主键
     * @return 结果
     */
    @Override
    public int deleteMesDeviceInformationById(Integer id)
    {
        return mesDeviceInformationMapper.deleteMesDeviceInformationById(id);
    }
}
