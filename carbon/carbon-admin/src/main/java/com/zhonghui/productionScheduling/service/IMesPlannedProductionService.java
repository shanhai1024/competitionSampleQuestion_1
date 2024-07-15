package com.zhonghui.productionScheduling.service;

import java.util.List;
import com.zhonghui.productionScheduling.domain.MesPlannedProduction;

/**
 * 计划排产Service接口
 * 
 * @author shanhai1024
 * @date 2024-07-01
 */
public interface IMesPlannedProductionService 
{
    /**
     * 查询计划排产
     * 
     * @param id 计划排产主键
     * @return 计划排产
     */
    public MesPlannedProduction selectMesPlannedProductionById(Long id);

    /**
     * 查询计划排产列表
     * 
     * @param mesPlannedProduction 计划排产
     * @return 计划排产集合
     */
    public List<MesPlannedProduction> selectMesPlannedProductionList(MesPlannedProduction mesPlannedProduction);

    /**
     * 新增计划排产
     * 
     * @param mesPlannedProduction 计划排产
     * @return 结果
     */
    public int insertMesPlannedProduction(MesPlannedProduction mesPlannedProduction);

    /**
     * 修改计划排产
     * 
     * @param mesPlannedProduction 计划排产
     * @return 结果
     */
    public int updateMesPlannedProduction(MesPlannedProduction mesPlannedProduction);

    /**
     * 批量删除计划排产
     * 
     * @param ids 需要删除的计划排产主键集合
     * @return 结果
     */
    public int deleteMesPlannedProductionByIds(Long[] ids);

    /**
     * 删除计划排产信息
     * 
     * @param id 计划排产主键
     * @return 结果
     */
    public int deleteMesPlannedProductionById(Long id);
}
