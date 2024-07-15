package com.zhonghui.procurementManagement.service.impl;

import com.zhonghui.procurementManagement.domain.PmPoliciesRegulations;
import com.zhonghui.procurementManagement.mapper.PmPoliciesRegulationsMapper;
import com.zhonghui.procurementManagement.service.IPmPoliciesRegulationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 政策法规Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Service
public class PmPoliciesRegulationsServiceImpl implements IPmPoliciesRegulationsService 
{
    @Autowired
    private PmPoliciesRegulationsMapper pmPoliciesRegulationsMapper;

    /**
     * 查询政策法规
     * 
     * @param listId 政策法规主键
     * @return 政策法规
     */
    @Override
    public PmPoliciesRegulations selectPmPoliciesRegulationsByListId(Integer listId)
    {
        return pmPoliciesRegulationsMapper.selectPmPoliciesRegulationsByListId(listId);
    }

    /**
     * 查询政策法规列表
     * 
     * @param pmPoliciesRegulations 政策法规
     * @return 政策法规
     */
    @Override
    public List<PmPoliciesRegulations> selectPmPoliciesRegulationsList(PmPoliciesRegulations pmPoliciesRegulations)
    {
        pmPoliciesRegulations.setListType(2);
        return pmPoliciesRegulationsMapper.selectPmPoliciesRegulationsList(pmPoliciesRegulations);
    }

    /**
     * 新增政策法规
     * 
     * @param pmPoliciesRegulations 政策法规
     * @return 结果
     */
    @Override
    public int insertPmPoliciesRegulations(PmPoliciesRegulations pmPoliciesRegulations)
    {
        pmPoliciesRegulations.setListType(2);
        return pmPoliciesRegulationsMapper.insertPmPoliciesRegulations(pmPoliciesRegulations);
    }

    /**
     * 修改政策法规
     * 
     * @param pmPoliciesRegulations 政策法规
     * @return 结果
     */
    @Override
    public int updatePmPoliciesRegulations(PmPoliciesRegulations pmPoliciesRegulations)
    {
        return pmPoliciesRegulationsMapper.updatePmPoliciesRegulations(pmPoliciesRegulations);
    }

    /**
     * 批量删除政策法规
     * 
     * @param listIds 需要删除的政策法规主键
     * @return 结果
     */
    @Override
    public int deletePmPoliciesRegulationsByListIds(Integer[] listIds)
    {
        return pmPoliciesRegulationsMapper.deletePmPoliciesRegulationsByListIds(listIds);
    }

    /**
     * 删除政策法规信息
     * 
     * @param listId 政策法规主键
     * @return 结果
     */
    @Override
    public int deletePmPoliciesRegulationsByListId(Integer listId)
    {
        return pmPoliciesRegulationsMapper.deletePmPoliciesRegulationsByListId(listId);
    }
}
