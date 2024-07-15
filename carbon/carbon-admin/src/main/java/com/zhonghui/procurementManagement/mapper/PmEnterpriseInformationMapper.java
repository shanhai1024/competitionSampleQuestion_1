package com.zhonghui.procurementManagement.mapper;

import com.zhonghui.procurementManagement.domain.PmEnterpriseInformation;

import java.util.List;

/**
 * 采购—企业信息Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
public interface PmEnterpriseInformationMapper 
{
    /**
     * 查询采购—企业信息
     * 
     * @param id 采购—企业信息主键
     * @return 采购—企业信息
     */
    public PmEnterpriseInformation selectPmEnterpriseInformationById(Long id);

    /**
     * 查询采购—企业信息列表
     * 
     * @param pmEnterpriseInformation 采购—企业信息
     * @return 采购—企业信息集合
     */
    public List<PmEnterpriseInformation> selectPmEnterpriseInformationList(PmEnterpriseInformation pmEnterpriseInformation);

    /**
     * 新增采购—企业信息
     * 
     * @param pmEnterpriseInformation 采购—企业信息
     * @return 结果
     */
    public int insertPmEnterpriseInformation(PmEnterpriseInformation pmEnterpriseInformation);

    /**
     * 修改采购—企业信息
     * 
     * @param pmEnterpriseInformation 采购—企业信息
     * @return 结果
     */
    public int updatePmEnterpriseInformation(PmEnterpriseInformation pmEnterpriseInformation);

    /**
     * 删除采购—企业信息
     * 
     * @param id 采购—企业信息主键
     * @return 结果
     */
    public int deletePmEnterpriseInformationById(Long id);

    /**
     * 批量删除采购—企业信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmEnterpriseInformationByIds(Long[] ids);
}
