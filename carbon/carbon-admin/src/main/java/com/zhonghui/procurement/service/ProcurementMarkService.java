package com.zhonghui.procurement.service;

import com.zhonghui.procurement.domain.ProcurementHaveBid;
import com.zhonghui.procurement.domain.vo.ProcurementMarkVo;

import java.util.List;

public interface ProcurementMarkService {

    List<ProcurementMarkVo> getMarkList(Integer type);

    boolean updMarkListById(ProcurementHaveBid procurementHaveBid);
}
