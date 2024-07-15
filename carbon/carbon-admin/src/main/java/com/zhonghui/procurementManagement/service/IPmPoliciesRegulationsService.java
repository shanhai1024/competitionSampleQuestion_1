package com.zhonghui.procurementManagement.service;

import com.zhonghui.procurementManagement.domain.PmPoliciesRegulations;

import java.util.List;

/**
 * 政策法规Service接口
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
public interface IPmPoliciesRegulationsService 
{
    /**
     * 查询政策法规
     * 
     * @param listId 政策法规主键
     * @return 政策法规
     */
    public PmPoliciesRegulations selectPmPoliciesRegulationsByListId(Integer listId);

    /**
     * 查询政策法规列表
     * 
     * @param pmPoliciesRegulations 政策法规
     * @return 政策法规集合
     */
    public List<PmPoliciesRegulations> selectPmPoliciesRegulationsList(PmPoliciesRegulations pmPoliciesRegulations);

    /**
     * 新增政策法规
     * 
     * @param pmPoliciesRegulations 政策法规
     * @return 结果
     */
    public int insertPmPoliciesRegulations(PmPoliciesRegulations pmPoliciesRegulations);

    /**
     * 修改政策法规
     * 
     * @param pmPoliciesRegulations 政策法规
     * @return 结果
     */
    public int updatePmPoliciesRegulations(PmPoliciesRegulations pmPoliciesRegulations);

    /**
     * 批量删除政策法规
     * 
     * @param listIds 需要删除的政策法规主键集合
     * @return 结果
     */
    public int deletePmPoliciesRegulationsByListIds(Integer[] listIds);

    /**
     * 删除政策法规信息
     * 
     * @param listId 政策法规主键
     * @return 结果
     */
    public int deletePmPoliciesRegulationsByListId(Integer listId);
}
