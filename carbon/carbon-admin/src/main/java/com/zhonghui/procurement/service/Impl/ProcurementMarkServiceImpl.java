package com.zhonghui.procurement.service.Impl;

import com.zhonghui.procurement.domain.ProcurementEnterpriseInformation;
import com.zhonghui.procurement.domain.ProcurementHaveBid;
import com.zhonghui.procurement.domain.vo.ProcurementMarkVo;
import com.zhonghui.procurement.mapper.ProcurementEnterpriseInformationMapper;
import com.zhonghui.procurement.mapper.ProcurementHaveBidMapper;
import com.zhonghui.procurement.mapper.ProcurementMarkMapper;
import com.zhonghui.procurement.mapper.ProcurementSnapshotInformationMapper;
import com.zhonghui.procurement.service.ProcurementMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProcurementMarkServiceImpl implements ProcurementMarkService {

    @Autowired
    private ProcurementMarkMapper procurementMarkMapper;

    @Autowired
    private ProcurementSnapshotInformationMapper procurementSnapshotInformationMapper;

    @Autowired
    private ProcurementEnterpriseInformationMapper procurementEnterpriseInformationMapper;

    @Autowired
    private ProcurementHaveBidMapper procurementHaveBidMapper;

    @Override
    public List<ProcurementMarkVo> getMarkList(Integer type) {
        List<ProcurementMarkVo> markList = procurementMarkMapper.getMarkList(type);
        return markList;
    }

    @Override
    @Transactional
    public boolean updMarkListById(ProcurementHaveBid procurementHaveBid) {
        System.out.println(procurementHaveBid);
        ProcurementEnterpriseInformation enterpriseInformation1 = procurementEnterpriseInformationMapper.getEnterpriseInformation(procurementHaveBid.getUserId());
        System.out.println(enterpriseInformation1);
        if (enterpriseInformation1==null){
            System.out.println("企业为空");
            return false;
        }
        Integer bidType = procurementMarkMapper.selectMarkListById(procurementHaveBid.getBidId()).getBidType();
        if ( bidType == 5){
            // 修改标状态
            int i = procurementMarkMapper.updMarkListById(procurementHaveBid.getBidId(), 0);
            // 添加企业信息快照
            ProcurementEnterpriseInformation enterpriseInformation = procurementEnterpriseInformationMapper.getEnterpriseInformation(procurementHaveBid.getUserId());
            procurementSnapshotInformationMapper.insert(enterpriseInformation);
            // 添加我的标列表
            procurementHaveBid.setSnapshotInformation(enterpriseInformation.getId());
            procurementHaveBidMapper.insert(procurementHaveBid);
            return true;
        }else {
            return false;
        }
    }
}
