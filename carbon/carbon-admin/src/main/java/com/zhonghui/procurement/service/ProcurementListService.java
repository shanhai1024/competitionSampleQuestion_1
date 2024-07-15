package com.zhonghui.procurement.service;

import com.zhonghui.procurement.domain.ProcurementList;

import java.util.List;

/**
 * 公告法规动态表mapper层
 */
public interface ProcurementListService {
    /**
     * 查询公告法规动态列表
     *
     * @param type 列表类型
     * @return 公告法规动态列表
     */
    List<ProcurementList> getProcurementList(Integer type,Integer announcementType);

    ProcurementList getProcurementListItem(int id);
}
