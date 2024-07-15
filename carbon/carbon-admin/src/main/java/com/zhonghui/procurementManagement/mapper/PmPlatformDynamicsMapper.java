package com.zhonghui.procurementManagement.mapper;

import com.zhonghui.procurementManagement.domain.PmPlatformDynamics;

import java.util.List;

/**
 * 平台动态Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
public interface PmPlatformDynamicsMapper 
{
    /**
     * 查询平台动态
     * 
     * @param listId 平台动态主键
     * @return 平台动态
     */
    public PmPlatformDynamics selectPmPlatformDynamicsByListId(Long listId);

    /**
     * 查询平台动态列表
     * 
     * @param pmPlatformDynamics 平台动态
     * @return 平台动态集合
     */
    public List<PmPlatformDynamics> selectPmPlatformDynamicsList(PmPlatformDynamics pmPlatformDynamics);

    /**
     * 新增平台动态
     * 
     * @param pmPlatformDynamics 平台动态
     * @return 结果
     */
    public int insertPmPlatformDynamics(PmPlatformDynamics pmPlatformDynamics);

    /**
     * 修改平台动态
     * 
     * @param pmPlatformDynamics 平台动态
     * @return 结果
     */
    public int updatePmPlatformDynamics(PmPlatformDynamics pmPlatformDynamics);

    /**
     * 删除平台动态
     * 
     * @param listId 平台动态主键
     * @return 结果
     */
    public int deletePmPlatformDynamicsByListId(Long listId);

    /**
     * 批量删除平台动态
     * 
     * @param listIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmPlatformDynamicsByListIds(Long[] listIds);
}
