package com.zhonghui.procurement.service.Impl;

import com.zhonghui.procurement.domain.ProcurementList;
import com.zhonghui.procurement.mapper.ProcurementListMapper;
import com.zhonghui.procurement.service.ProcurementListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcurementListServiceImpl implements ProcurementListService {

    @Autowired
    private ProcurementListMapper procurementListMapper;

    @Override
    public List<ProcurementList> getProcurementList(Integer type,Integer announcementType) {
        List<ProcurementList> procurementList = procurementListMapper.getProcurementList(type,announcementType);
        return procurementList;
    }

    @Override
    public ProcurementList getProcurementListItem(int id) {
        ProcurementList procurementList = procurementListMapper.getProcurementListItem(id);
        return procurementList;
    }

}
