package com.zhonghui.procurement.mapper;

import com.zhonghui.procurement.domain.ProcurementComplaint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcurementComplaintMapper {
    /**
     * 查询投诉列表
     *
     * @param type
     * @return
     */
    List<ProcurementComplaint> getComplaintList(@Param("type") Integer type);

    /**
     * 新增投诉
     *
     * @param procurementComplaint
     * @return
     */
    int setComplaint(ProcurementComplaint procurementComplaint);

    ProcurementComplaint getComplaintListItem(Integer id);
}
