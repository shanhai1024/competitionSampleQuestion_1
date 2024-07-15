package com.zhonghui.procurementManagement.mapper;


import com.zhonghui.procurement.domain.ProcurementEnterpriseInformation;
import com.zhonghui.procurement.domain.ProcurementSnapshotInformation;

/**
* @author admin
* @description 针对表【procurement_snapshot_information(采购—企业信息提交表)】的数据库操作Mapper
* @createDate 2023-07-27 16:03:00
* @Entity com.zhonghui.domain.ProcurementSnapshotInformation
*/
public interface PmSnapshotInformationMapper {

    int insert(ProcurementEnterpriseInformation record);
    ProcurementSnapshotInformation selectById(int id);

    int delById(int id);
}
