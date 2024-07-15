package com.zhonghui.procurement.service;

import com.zhonghui.procurement.domain.vo.ProcurementHaveBidVo;

import java.util.List;

public interface ProcurementHaveBidService {

    List<ProcurementHaveBidVo> getHaveBidList(int userId);

    void setHaveBidList(int id, String fileList);

    ProcurementHaveBidVo getHaveBidById(int id);
}
