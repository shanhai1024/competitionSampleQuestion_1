package com.zhonghui.procurementManagement.mapper;

import com.zhonghui.procurementManagement.domain.PmComplaint;

import java.util.List;

/**
 * 采购—投诉Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
public interface PmComplaintMapper 
{
    /**
     * 查询采购—投诉
     * 
     * @param complaintId 采购—投诉主键
     * @return 采购—投诉
     */
    public PmComplaint selectPmComplaintByComplaintId(Long complaintId);

    /**
     * 查询采购—投诉列表
     * 
     * @param pmComplaint 采购—投诉
     * @return 采购—投诉集合
     */
    public List<PmComplaint> selectPmComplaintList(PmComplaint pmComplaint);

    /**
     * 新增采购—投诉
     * 
     * @param pmComplaint 采购—投诉
     * @return 结果
     */
    public int insertPmComplaint(PmComplaint pmComplaint);

    /**
     * 修改采购—投诉
     * 
     * @param pmComplaint 采购—投诉
     * @return 结果
     */
    public int updatePmComplaint(PmComplaint pmComplaint);

    /**
     * 删除采购—投诉
     * 
     * @param complaintId 采购—投诉主键
     * @return 结果
     */
    public int deletePmComplaintByComplaintId(Long complaintId);

    /**
     * 批量删除采购—投诉
     * 
     * @param complaintIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmComplaintByComplaintIds(Long[] complaintIds);
}
