package com.zhonghui.procurementManagement.service.impl;

import com.zhonghui.procurementManagement.domain.PmComplaint;
import com.zhonghui.procurementManagement.mapper.PmComplaintMapper;
import com.zhonghui.procurementManagement.service.IPmComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 采购—投诉Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Service
public class PmComplaintServiceImpl implements IPmComplaintService 
{
    @Autowired
    private PmComplaintMapper pmComplaintMapper;

    /**
     * 查询采购—投诉
     * 
     * @param complaintId 采购—投诉主键
     * @return 采购—投诉
     */
    @Override
    public PmComplaint selectPmComplaintByComplaintId(Long complaintId)
    {
        return pmComplaintMapper.selectPmComplaintByComplaintId(complaintId);
    }

    /**
     * 查询采购—投诉列表
     * 
     * @param pmComplaint 采购—投诉
     * @return 采购—投诉
     */
    @Override
    public List<PmComplaint> selectPmComplaintList(PmComplaint pmComplaint)
    {
        return pmComplaintMapper.selectPmComplaintList(pmComplaint);
    }

    /**
     * 新增采购—投诉
     * 
     * @param pmComplaint 采购—投诉
     * @return 结果
     */
    @Override
    public int insertPmComplaint(PmComplaint pmComplaint)
    {
        return pmComplaintMapper.insertPmComplaint(pmComplaint);
    }

    /**
     * 修改采购—投诉
     * 
     * @param pmComplaint 采购—投诉
     * @return 结果
     */
    @Override
    public int updatePmComplaint(PmComplaint pmComplaint)
    {
        return pmComplaintMapper.updatePmComplaint(pmComplaint);
    }

    /**
     * 批量删除采购—投诉
     * 
     * @param complaintIds 需要删除的采购—投诉主键
     * @return 结果
     */
    @Override
    public int deletePmComplaintByComplaintIds(Long[] complaintIds)
    {
        return pmComplaintMapper.deletePmComplaintByComplaintIds(complaintIds);
    }

    /**
     * 删除采购—投诉信息
     * 
     * @param complaintId 采购—投诉主键
     * @return 结果
     */
    @Override
    public int deletePmComplaintByComplaintId(Long complaintId)
    {
        return pmComplaintMapper.deletePmComplaintByComplaintId(complaintId);
    }
}
