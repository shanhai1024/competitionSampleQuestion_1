package com.zhonghui.procurementManagement.mapper;

import com.zhonghui.procurementManagement.domain.PmInformationBulletin;

import java.util.List;

/**
 * 信息公告Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
public interface PmInformationBulletinMapper 
{
    /**
     * 查询信息公告
     * 
     * @param listId 信息公告主键
     * @return 信息公告
     */
    public PmInformationBulletin selectPmInformationBulletinByListId(Integer listId);

    /**
     * 查询信息公告列表
     * 
     * @param pmInformationBulletin 信息公告
     * @return 信息公告集合
     */
    public List<PmInformationBulletin> selectPmInformationBulletinList(PmInformationBulletin pmInformationBulletin);

    /**
     * 新增信息公告
     * 
     * @param pmInformationBulletin 信息公告
     * @return 结果
     */
    public int insertPmInformationBulletin(PmInformationBulletin pmInformationBulletin);

    /**
     * 修改信息公告
     * 
     * @param pmInformationBulletin 信息公告
     * @return 结果
     */
    public int updatePmInformationBulletin(PmInformationBulletin pmInformationBulletin);

    /**
     * 删除信息公告
     * 
     * @param listId 信息公告主键
     * @return 结果
     */
    public int deletePmInformationBulletinByListId(Integer listId);

    /**
     * 批量删除信息公告
     * 
     * @param listIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmInformationBulletinByListIds(Integer[] listIds);
}
