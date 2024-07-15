package com.zhonghui.procurement.mapper;

import com.zhonghui.procurement.domain.ProcurementEnterpriseInformation;

public interface ProcurementEnterpriseInformationMapper {
    int setEnterpriseInformation(ProcurementEnterpriseInformation enterpriseInformation);

    ProcurementEnterpriseInformation getEnterpriseInformation(Integer userId);
}
