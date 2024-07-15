package com.zhonghui.procurementManagement.service;

import com.zhonghui.procurementManagement.domain.PmBid;

import java.util.List;

/**
 * 我的投标Service接口
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
public interface IPmBidService 
{
    /**
     * 查询我的投标
     * 
     * @param id 我的投标主键
     * @return 我的投标
     */
    public PmBid selectPmBidById(Long id);

    /**
     * 查询我的投标列表Vo
     *
     * @param pmBid 我的投标
     * @return 我的投标集合
     */
    public List<PmBid> selectPmBidListVo(PmBid pmBid);

    /**
     * 查询我的投标列表
     * 
     * @param pmBid 我的投标
     * @return 我的投标集合
     */
    public List<PmBid> selectPmBidList(PmBid pmBid);

    /**
     * 新增我的投标
     * 
     * @param pmBid 我的投标
     * @return 结果
     */
    public int insertPmBid(PmBid pmBid);

    /**
     * 修改我的投标
     * 
     * @param pmBid 我的投标
     * @return 结果
     */
    public int updatePmBid(PmBid pmBid);

    /**
     * 批量删除我的投标
     * 
     * @param ids 需要删除的我的投标主键集合
     * @return 结果
     */
    public void deletePmBidByIds(Long[] ids);

    /**
     * 删除我的投标信息
     * 
     * @param id 我的投标主键
     * @return 结果
     */
    public int deletePmBidById(Long id);
}
