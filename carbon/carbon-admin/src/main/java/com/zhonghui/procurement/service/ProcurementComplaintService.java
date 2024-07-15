package com.zhonghui.procurement.service;

import com.zhonghui.procurement.domain.ProcurementComplaint;

import java.util.List;

public interface ProcurementComplaintService {
    /**
     * 查询投诉列表
     *
     * @param type
     * @return
     */
    public List<ProcurementComplaint> getComplaintList(Integer type);

    /**
     * 新增投诉
     *
     * @param procurementComplaint
     * @return
     */
    public int setProcurement(ProcurementComplaint procurementComplaint);

    /**
     * 投诉详情
     *
     * @param id
     * @return
     */
    ProcurementComplaint getComplaintListItem(Integer id);
}
