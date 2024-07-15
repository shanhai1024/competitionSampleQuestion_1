package com.zhonghui.procurementManagement.service.impl;

import com.zhonghui.procurementManagement.domain.PmPlatformDynamics;
import com.zhonghui.procurementManagement.mapper.PmPlatformDynamicsMapper;
import com.zhonghui.procurementManagement.service.IPmPlatformDynamicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 平台动态Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Service
public class PmPlatformDynamicsServiceImpl implements IPmPlatformDynamicsService 
{
    @Autowired
    private PmPlatformDynamicsMapper pmPlatformDynamicsMapper;

    /**
     * 查询平台动态
     * 
     * @param listId 平台动态主键
     * @return 平台动态
     */
    @Override
    public PmPlatformDynamics selectPmPlatformDynamicsByListId(Long listId)
    {
        return pmPlatformDynamicsMapper.selectPmPlatformDynamicsByListId(listId);
    }

    /**
     * 查询平台动态列表
     * 
     * @param pmPlatformDynamics 平台动态
     * @return 平台动态
     */
    @Override
    public List<PmPlatformDynamics> selectPmPlatformDynamicsList(PmPlatformDynamics pmPlatformDynamics)
    {
        pmPlatformDynamics.setListType(3);
        return pmPlatformDynamicsMapper.selectPmPlatformDynamicsList(pmPlatformDynamics);
    }

    /**
     * 新增平台动态
     * 
     * @param pmPlatformDynamics 平台动态
     * @return 结果
     */
    @Override
    public int insertPmPlatformDynamics(PmPlatformDynamics pmPlatformDynamics)
    {
        pmPlatformDynamics.setListType(3);
        return pmPlatformDynamicsMapper.insertPmPlatformDynamics(pmPlatformDynamics);
    }

    /**
     * 修改平台动态
     * 
     * @param pmPlatformDynamics 平台动态
     * @return 结果
     */
    @Override
    public int updatePmPlatformDynamics(PmPlatformDynamics pmPlatformDynamics)
    {
        return pmPlatformDynamicsMapper.updatePmPlatformDynamics(pmPlatformDynamics);
    }

    /**
     * 批量删除平台动态
     * 
     * @param listIds 需要删除的平台动态主键
     * @return 结果
     */
    @Override
    public int deletePmPlatformDynamicsByListIds(Long[] listIds)
    {
        return pmPlatformDynamicsMapper.deletePmPlatformDynamicsByListIds(listIds);
    }

    /**
     * 删除平台动态信息
     * 
     * @param listId 平台动态主键
     * @return 结果
     */
    @Override
    public int deletePmPlatformDynamicsByListId(Long listId)
    {
        return pmPlatformDynamicsMapper.deletePmPlatformDynamicsByListId(listId);
    }
}
