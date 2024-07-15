package com.zhonghui.carbonReport.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.carbonReport.mapper.TmpEnergyConsumeMapper;
import com.zhonghui.carbonReport.domain.TmpEnergyConsume;
import com.zhonghui.carbonReport.service.ITmpEnergyConsumeService;

/**
 * 能耗临时Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Service
public class TmpEnergyConsumeServiceImpl implements ITmpEnergyConsumeService 
{
    @Autowired
    private TmpEnergyConsumeMapper tmpEnergyConsumeMapper;

    /**
     * 查询能耗临时
     * 
     * @param id 能耗临时主键
     * @return 能耗临时
     */
    @Override
    public TmpEnergyConsume selectTmpEnergyConsumeById(Long id)
    {
        return tmpEnergyConsumeMapper.selectTmpEnergyConsumeById(id);
    }

    /**
     * 查询能耗临时列表
     * 
     * @param tmpEnergyConsume 能耗临时
     * @return 能耗临时
     */
    @Override
    public List<TmpEnergyConsume> selectTmpEnergyConsumeList(TmpEnergyConsume tmpEnergyConsume)
    {
        return tmpEnergyConsumeMapper.selectTmpEnergyConsumeList(tmpEnergyConsume);
    }

    /**
     * 新增能耗临时
     * 
     * @param tmpEnergyConsume 能耗临时
     * @return 结果
     */
    @Override
    public int insertTmpEnergyConsume(TmpEnergyConsume tmpEnergyConsume)
    {
        return tmpEnergyConsumeMapper.insertTmpEnergyConsume(tmpEnergyConsume);
    }

    /**
     * 修改能耗临时
     * 
     * @param tmpEnergyConsume 能耗临时
     * @return 结果
     */
    @Override
    public int updateTmpEnergyConsume(TmpEnergyConsume tmpEnergyConsume)
    {
        return tmpEnergyConsumeMapper.updateTmpEnergyConsume(tmpEnergyConsume);
    }

    /**
     * 批量删除能耗临时
     * 
     * @param ids 需要删除的能耗临时主键
     * @return 结果
     */
    @Override
    public int deleteTmpEnergyConsumeByIds(Long[] ids)
    {
        return tmpEnergyConsumeMapper.deleteTmpEnergyConsumeByIds(ids);
    }

    /**
     * 删除能耗临时信息
     * 
     * @param id 能耗临时主键
     * @return 结果
     */
    @Override
    public int deleteTmpEnergyConsumeById(Long id)
    {
        return tmpEnergyConsumeMapper.deleteTmpEnergyConsumeById(id);
    }
}
