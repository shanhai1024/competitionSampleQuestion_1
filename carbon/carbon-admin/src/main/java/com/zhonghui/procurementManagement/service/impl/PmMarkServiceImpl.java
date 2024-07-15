package com.zhonghui.procurementManagement.service.impl;

import com.zhonghui.procurementManagement.domain.PmMark;
import com.zhonghui.procurementManagement.mapper.PmMarkMapper;
import com.zhonghui.procurementManagement.service.IPmMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 参与投标表Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Service
public class PmMarkServiceImpl implements IPmMarkService 
{
    @Autowired
    private PmMarkMapper pmMarkMapper;

    /**
     * 查询参与投标表
     * 
     * @param markId 参与投标表主键
     * @return 参与投标表
     */
    @Override
    public PmMark selectPmMarkByMarkId(Long markId)
    {
        return pmMarkMapper.selectPmMarkByMarkId(markId);
    }

    /**
     * 查询参与投标表列表
     * 
     * @param pmMark 参与投标表
     * @return 参与投标表
     */
    @Override
    public List<PmMark> selectPmMarkList(PmMark pmMark)
    {
        return pmMarkMapper.selectPmMarkList(pmMark);
    }

    /**
     * 新增参与投标表
     * 
     * @param pmMark 参与投标表
     * @return 结果
     */
    @Override
    public int insertPmMark(PmMark pmMark)
    {
        return pmMarkMapper.insertPmMark(pmMark);
    }

    /**
     * 修改参与投标表
     * 
     * @param pmMark 参与投标表
     * @return 结果
     */
    @Override
    public int updatePmMark(PmMark pmMark)
    {
        return pmMarkMapper.updatePmMark(pmMark);
    }

    /**
     * 批量删除参与投标表
     * 
     * @param markIds 需要删除的参与投标表主键
     * @return 结果
     */
    @Override
    public int deletePmMarkByMarkIds(Long[] markIds)
    {
        return pmMarkMapper.deletePmMarkByMarkIds(markIds);

    }

    /**
     * 删除参与投标表信息
     * 
     * @param markId 参与投标表主键
     * @return 结果
     */
    @Override
    public int deletePmMarkByMarkId(Long markId)
    {
        return pmMarkMapper.deletePmMarkByMarkId(markId);
    }
}
