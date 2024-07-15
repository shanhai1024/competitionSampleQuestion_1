package com.zhonghui.procurementManagement.service.impl;

import com.zhonghui.procurementManagement.domain.PmInformationBulletin;
import com.zhonghui.procurementManagement.mapper.PmInformationBulletinMapper;
import com.zhonghui.procurementManagement.service.IPmInformationBulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 信息公告Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Service
public class PmInformationBulletinServiceImpl implements IPmInformationBulletinService 
{
    @Autowired
    private PmInformationBulletinMapper pmInformationBulletinMapper;

    /**
     * 查询信息公告
     * 
     * @param listId 信息公告主键
     * @return 信息公告
     */
    @Override
    public PmInformationBulletin selectPmInformationBulletinByListId(Integer listId)
    {
        return pmInformationBulletinMapper.selectPmInformationBulletinByListId(listId);
    }

    /**
     * 查询信息公告列表
     * 
     * @param pmInformationBulletin 信息公告
     * @return 信息公告
     */
    @Override
    public List<PmInformationBulletin> selectPmInformationBulletinList(PmInformationBulletin pmInformationBulletin)
    {
        pmInformationBulletin.setListType(1);
        return pmInformationBulletinMapper.selectPmInformationBulletinList(pmInformationBulletin);
    }

    /**
     * 新增信息公告
     * 
     * @param pmInformationBulletin 信息公告
     * @return 结果
     */
    @Override
    public int insertPmInformationBulletin(PmInformationBulletin pmInformationBulletin)
    {
        pmInformationBulletin.setListType(1);
        return pmInformationBulletinMapper.insertPmInformationBulletin(pmInformationBulletin);
    }

    /**
     * 修改信息公告
     * 
     * @param pmInformationBulletin 信息公告
     * @return 结果
     */
    @Override
    public int updatePmInformationBulletin(PmInformationBulletin pmInformationBulletin)
    {
        return pmInformationBulletinMapper.updatePmInformationBulletin(pmInformationBulletin);
    }

    /**
     * 批量删除信息公告
     * 
     * @param listIds 需要删除的信息公告主键
     * @return 结果
     */
    @Override
    public int deletePmInformationBulletinByListIds(Integer[] listIds)
    {
        return pmInformationBulletinMapper.deletePmInformationBulletinByListIds(listIds);
    }

    /**
     * 删除信息公告信息
     * 
     * @param listId 信息公告主键
     * @return 结果
     */
    @Override
    public int deletePmInformationBulletinByListId(Integer listId)
    {
        return pmInformationBulletinMapper.deletePmInformationBulletinByListId(listId);
    }
}
