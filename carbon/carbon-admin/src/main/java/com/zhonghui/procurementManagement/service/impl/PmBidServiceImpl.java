package com.zhonghui.procurementManagement.service.impl;

import com.zhonghui.procurementManagement.domain.PmBid;
import com.zhonghui.procurementManagement.domain.PmMark;
import com.zhonghui.procurementManagement.mapper.PmBidMapper;
import com.zhonghui.procurementManagement.mapper.PmMarkMapper;
import com.zhonghui.procurementManagement.mapper.PmSnapshotInformationMapper;
import com.zhonghui.procurementManagement.service.IPmBidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 我的投标Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Service
public class PmBidServiceImpl implements IPmBidService 
{
    @Autowired
    private PmBidMapper pmBidMapper;
    @Autowired
    private PmSnapshotInformationMapper pmSnapshotInformationMapper;
    @Autowired
    private PmMarkMapper pmMarkMapper;

    /**
     * 查询我的投标
     * 
     * @param id 我的投标主键
     * @return 我的投标
     */
    @Override
    public PmBid selectPmBidById(Long id)
    {
        return pmBidMapper.selectPmBidById(id);
    }

    @Override
    public List<PmBid> selectPmBidListVo(PmBid pmBid) {
        return pmBidMapper.selectPmBidListVo(pmBid);
    }

    /**
     * 查询我的投标列表
     * 
     * @param pmBid 我的投标
     * @return 我的投标
     */
    @Override
    public List<PmBid> selectPmBidList(PmBid pmBid)
    {
        return pmBidMapper.selectPmBidList(pmBid);
    }

    /**
     * 新增我的投标
     * 
     * @param pmBid 我的投标
     * @return 结果
     */
    @Override
    public int insertPmBid(PmBid pmBid)
    {
        return pmBidMapper.insertPmBid(pmBid);
    }

    /**
     * 修改我的投标
     * 
     * @param pmBid 我的投标
     * @return 结果
     */
    @Override
    public int updatePmBid(PmBid pmBid)
    {
        return pmBidMapper.updatePmBid(pmBid);
    }

    /**
     * 批量删除我的投标
     * 
     * @param ids 需要删除的我的投标主键
     * @return 结果
     */
    @Override
    @Transactional
    public void deletePmBidByIds(Long[] ids)
    {
        for (int i = 0; i < ids.length; i++) {
            // 删除企业信息快照
            PmBid pmBid = pmBidMapper.selectPmBidById(ids[i]);
            System.out.println(pmBid);
            pmSnapshotInformationMapper.delById(Math.toIntExact(pmBid.getSnapshotInformation()));
            // 更改标状态为未报名
            PmMark pmMark = new PmMark();
            pmMark.setBidType(5L);
            pmMark.setMarkId(pmBid.getBidId());
            pmMarkMapper.updatePmMark(pmMark);
        }
        pmBidMapper.deletePmBidByIds(ids);
    }

    /**
     * 删除我的投标信息
     * 
     * @param id 我的投标主键
     * @return 结果
     */
    @Override
    public int deletePmBidById(Long id)
    {
        return pmBidMapper.deletePmBidById(id);
    }
}
