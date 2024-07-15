package com.zhonghui.dc.service;

import java.util.List;
import com.zhonghui.dc.domain.DcNeutralityCalculationRatio;

/**
 * 碳中和计算比例Service接口
 * 
 * @author zhonghui
 * @date 2022-05-27
 */
public interface IDcNeutralityCalculationRatioService 
{
    /**
     * 查询碳中和计算比例
     * 
     * @param id 碳中和计算比例主键
     * @return 碳中和计算比例
     */
    public DcNeutralityCalculationRatio selectDcNeutralityCalculationRatioById(Long id);

    /**
     * 查询碳中和计算比例列表
     * 
     * @param dcNeutralityCalculationRatio 碳中和计算比例
     * @return 碳中和计算比例集合
     */
    public List<DcNeutralityCalculationRatio> selectDcNeutralityCalculationRatioList(DcNeutralityCalculationRatio dcNeutralityCalculationRatio);

    /**
     * 新增碳中和计算比例
     * 
     * @param dcNeutralityCalculationRatio 碳中和计算比例
     * @return 结果
     */
    public int insertDcNeutralityCalculationRatio(DcNeutralityCalculationRatio dcNeutralityCalculationRatio);

    /**
     * 修改碳中和计算比例
     * 
     * @param dcNeutralityCalculationRatio 碳中和计算比例
     * @return 结果
     */
    public int updateDcNeutralityCalculationRatio(DcNeutralityCalculationRatio dcNeutralityCalculationRatio);

    /**
     * 批量删除碳中和计算比例
     * 
     * @param ids 需要删除的碳中和计算比例主键集合
     * @return 结果
     */
    public int deleteDcNeutralityCalculationRatioByIds(Long[] ids);

    /**
     * 删除碳中和计算比例信息
     * 
     * @param id 碳中和计算比例主键
     * @return 结果
     */
    public int deleteDcNeutralityCalculationRatioById(Long id);

    /**
     * 获取碳中和耗电计算比例
     * @return
     */
    public double getElectricCo2();

    /**
     * 获取碳中和用水计算比例
     * @return
     */
    public double getWaterCo2();
}
