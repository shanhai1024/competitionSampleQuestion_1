package com.zhonghui.procurement.service.Impl;

import com.zhonghui.procurement.domain.vo.ProcurementHaveBidVo;
import com.zhonghui.procurement.mapper.ProcurementHaveBidMapper;
import com.zhonghui.procurement.mapper.ProcurementMarkMapper;
import com.zhonghui.procurement.service.ProcurementHaveBidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProcurementHaveBidServiceImpl implements ProcurementHaveBidService {

    @Autowired
    private ProcurementHaveBidMapper procurementHaveBidMapper;

    @Autowired
    private ProcurementMarkMapper procurementMarkMapper;

    @Override
    public List<ProcurementHaveBidVo> getHaveBidList(int userId) {
        return procurementHaveBidMapper.getHaveBidList(userId);
    }

    @Override
    @Transactional
    public void setHaveBidList(int id, String fileList) {
        // 提交资料
        int i = procurementHaveBidMapper.setHaveBidList(id,fileList);
        // 修改标状态
        ProcurementHaveBidVo haveBidById = procurementHaveBidMapper.getHaveBidById(id);
        System.out.println(haveBidById.getBidId());
        procurementMarkMapper.updMarkListById(haveBidById.getBidId(),2);
    }

    @Override
    public ProcurementHaveBidVo getHaveBidById(int id) {
        return procurementHaveBidMapper.getHaveBidById(id);
    }
}
