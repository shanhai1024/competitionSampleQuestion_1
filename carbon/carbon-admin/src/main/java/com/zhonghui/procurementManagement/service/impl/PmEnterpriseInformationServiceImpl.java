package com.zhonghui.procurementManagement.service.impl;

import com.zhonghui.procurementManagement.domain.PmEnterpriseInformation;
import com.zhonghui.procurementManagement.mapper.PmEnterpriseInformationMapper;
import com.zhonghui.procurementManagement.service.IPmEnterpriseInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 采购—企业信息Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Service
public class PmEnterpriseInformationServiceImpl implements IPmEnterpriseInformationService 
{
    @Autowired
    private PmEnterpriseInformationMapper pmEnterpriseInformationMapper;

    /**
     * 查询采购—企业信息
     * 
     * @param id 采购—企业信息主键
     * @return 采购—企业信息
     */
    @Override
    public PmEnterpriseInformation selectPmEnterpriseInformationById(Long id)
    {
        return pmEnterpriseInformationMapper.selectPmEnterpriseInformationById(id);
    }

    /**
     * 查询采购—企业信息列表
     * 
     * @param pmEnterpriseInformation 采购—企业信息
     * @return 采购—企业信息
     */
    @Override
    public List<PmEnterpriseInformation> selectPmEnterpriseInformationList(PmEnterpriseInformation pmEnterpriseInformation)
    {
        return pmEnterpriseInformationMapper.selectPmEnterpriseInformationList(pmEnterpriseInformation);
    }

    /**
     * 新增采购—企业信息
     * 
     * @param pmEnterpriseInformation 采购—企业信息
     * @return 结果
     */
    @Override
    public int insertPmEnterpriseInformation(PmEnterpriseInformation pmEnterpriseInformation)
    {
        return pmEnterpriseInformationMapper.insertPmEnterpriseInformation(pmEnterpriseInformation);
    }

    /**
     * 修改采购—企业信息
     * 
     * @param pmEnterpriseInformation 采购—企业信息
     * @return 结果
     */
    @Override
    public int updatePmEnterpriseInformation(PmEnterpriseInformation pmEnterpriseInformation)
    {
        return pmEnterpriseInformationMapper.updatePmEnterpriseInformation(pmEnterpriseInformation);
    }

    /**
     * 批量删除采购—企业信息
     * 
     * @param ids 需要删除的采购—企业信息主键
     * @return 结果
     */
    @Override
    public int deletePmEnterpriseInformationByIds(Long[] ids)
    {
        return pmEnterpriseInformationMapper.deletePmEnterpriseInformationByIds(ids);
    }

    /**
     * 删除采购—企业信息信息
     * 
     * @param id 采购—企业信息主键
     * @return 结果
     */
    @Override
    public int deletePmEnterpriseInformationById(Long id)
    {
        return pmEnterpriseInformationMapper.deletePmEnterpriseInformationById(id);
    }
}
