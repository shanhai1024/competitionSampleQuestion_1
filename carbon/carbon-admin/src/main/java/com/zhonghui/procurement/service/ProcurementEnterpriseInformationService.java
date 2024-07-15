package com.zhonghui.procurement.service;

import com.zhonghui.procurement.domain.ProcurementEnterpriseInformation;

public interface ProcurementEnterpriseInformationService {
    void setEnterpriseInformation(ProcurementEnterpriseInformation enterpriseInformation);

    ProcurementEnterpriseInformation getEnterpriseInformation(Integer userId);
}
