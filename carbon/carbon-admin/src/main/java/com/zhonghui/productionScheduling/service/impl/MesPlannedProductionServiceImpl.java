package com.zhonghui.productionScheduling.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.productionScheduling.mapper.MesPlannedProductionMapper;
import com.zhonghui.productionScheduling.domain.MesPlannedProduction;
import com.zhonghui.productionScheduling.service.IMesPlannedProductionService;

/**
 * 计划排产Service业务层处理
 * 
 * @author shanhai1024
 * @date 2024-07-01
 */
@Service
public class MesPlannedProductionServiceImpl implements IMesPlannedProductionService 
{
    @Autowired
    private MesPlannedProductionMapper mesPlannedProductionMapper;

    /**
     * 查询计划排产
     * 
     * @param id 计划排产主键
     * @return 计划排产
     */
    @Override
    public MesPlannedProduction selectMesPlannedProductionById(Long id)
    {
        return mesPlannedProductionMapper.selectMesPlannedProductionById(id);
    }

    /**
     * 查询计划排产列表
     * 
     * @param mesPlannedProduction 计划排产
     * @return 计划排产
     */
    @Override
    public List<MesPlannedProduction> selectMesPlannedProductionList(MesPlannedProduction mesPlannedProduction)
    {
        return mesPlannedProductionMapper.selectMesPlannedProductionList(mesPlannedProduction);
    }

    /**
     * 新增计划排产
     * 
     * @param mesPlannedProduction 计划排产
     * @return 结果
     */
    @Override
    public int insertMesPlannedProduction(MesPlannedProduction mesPlannedProduction)
    {
        return mesPlannedProductionMapper.insertMesPlannedProduction(mesPlannedProduction);
    }

    /**
     * 修改计划排产
     * 
     * @param mesPlannedProduction 计划排产
     * @return 结果
     */
    @Override
    public int updateMesPlannedProduction(MesPlannedProduction mesPlannedProduction)
    {
        return mesPlannedProductionMapper.updateMesPlannedProduction(mesPlannedProduction);
    }

    /**
     * 批量删除计划排产
     * 
     * @param ids 需要删除的计划排产主键
     * @return 结果
     */
    @Override
    public int deleteMesPlannedProductionByIds(Long[] ids)
    {
        return mesPlannedProductionMapper.deleteMesPlannedProductionByIds(ids);
    }

    /**
     * 删除计划排产信息
     * 
     * @param id 计划排产主键
     * @return 结果
     */
    @Override
    public int deleteMesPlannedProductionById(Long id)
    {
        return mesPlannedProductionMapper.deleteMesPlannedProductionById(id);
    }
}
