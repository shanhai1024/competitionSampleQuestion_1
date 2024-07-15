package com.zhonghui.carbonReport.service;

import java.util.List;
import com.zhonghui.carbonReport.domain.TmpEnergyConsume;

/**
 * 能耗临时Service接口
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
public interface ITmpEnergyConsumeService 
{
    /**
     * 查询能耗临时
     * 
     * @param id 能耗临时主键
     * @return 能耗临时
     */
    public TmpEnergyConsume selectTmpEnergyConsumeById(Long id);

    /**
     * 查询能耗临时列表
     * 
     * @param tmpEnergyConsume 能耗临时
     * @return 能耗临时集合
     */
    public List<TmpEnergyConsume> selectTmpEnergyConsumeList(TmpEnergyConsume tmpEnergyConsume);

    /**
     * 新增能耗临时
     * 
     * @param tmpEnergyConsume 能耗临时
     * @return 结果
     */
    public int insertTmpEnergyConsume(TmpEnergyConsume tmpEnergyConsume);

    /**
     * 修改能耗临时
     * 
     * @param tmpEnergyConsume 能耗临时
     * @return 结果
     */
    public int updateTmpEnergyConsume(TmpEnergyConsume tmpEnergyConsume);

    /**
     * 批量删除能耗临时
     * 
     * @param ids 需要删除的能耗临时主键集合
     * @return 结果
     */
    public int deleteTmpEnergyConsumeByIds(Long[] ids);

    /**
     * 删除能耗临时信息
     * 
     * @param id 能耗临时主键
     * @return 结果
     */
    public int deleteTmpEnergyConsumeById(Long id);
}
