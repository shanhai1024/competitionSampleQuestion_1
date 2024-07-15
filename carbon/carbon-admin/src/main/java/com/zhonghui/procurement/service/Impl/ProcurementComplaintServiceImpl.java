package com.zhonghui.procurement.service.Impl;

import com.zhonghui.procurement.domain.ProcurementComplaint;
import com.zhonghui.procurement.mapper.ProcurementComplaintMapper;
import com.zhonghui.procurement.service.ProcurementComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ProcurementComplaintServiceImpl implements ProcurementComplaintService {

    @Autowired
    private ProcurementComplaintMapper procurementComplaintMapper;

    @Override
    public List<ProcurementComplaint> getComplaintList(Integer type) {
        List<ProcurementComplaint> complaintList = procurementComplaintMapper.getComplaintList(type);
        return complaintList;
    }

    @Override
    public int setProcurement(ProcurementComplaint procurementComplaint) {
        Long timestamp = new Long(System.currentTimeMillis());
        procurementComplaint.setCreationTime(new Date(timestamp));
        int i = procurementComplaintMapper.setComplaint(procurementComplaint);
        return i;
    }

    @Override
    public ProcurementComplaint getComplaintListItem(Integer id) {
        ProcurementComplaint complaintList = procurementComplaintMapper.getComplaintListItem(id);
        return complaintList;
    }
}
