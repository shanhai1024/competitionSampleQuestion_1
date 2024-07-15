package com.zhonghui.procurement.mapper;

import com.zhonghui.procurement.domain.ProcurementList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcurementListMapper {

    List<ProcurementList> getProcurementList(@Param("listType") Integer listType, @Param("announcementType") Integer announcementType);

    ProcurementList getProcurementListItem(int id);
}
