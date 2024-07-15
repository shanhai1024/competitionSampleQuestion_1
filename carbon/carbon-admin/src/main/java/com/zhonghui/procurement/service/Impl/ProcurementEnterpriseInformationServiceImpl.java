package com.zhonghui.procurement.service.Impl;


import com.zhonghui.procurement.domain.ProcurementEnterpriseInformation;
import com.zhonghui.procurement.mapper.ProcurementEnterpriseInformationMapper;
import com.zhonghui.procurement.service.ProcurementEnterpriseInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcurementEnterpriseInformationServiceImpl implements ProcurementEnterpriseInformationService {
    @Autowired
    private ProcurementEnterpriseInformationMapper enterpriseInformationMapper;

    @Override
    public void setEnterpriseInformation(ProcurementEnterpriseInformation enterpriseInformation) {
        int i = enterpriseInformationMapper.setEnterpriseInformation(enterpriseInformation);
    }

    @Override
    public ProcurementEnterpriseInformation getEnterpriseInformation(Integer userId) {
        return enterpriseInformationMapper.getEnterpriseInformation(userId);
    }
}
