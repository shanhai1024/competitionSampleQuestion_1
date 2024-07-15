package com.zhonghui.dc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.dc.mapper.DcNeutralityCalculationRatioMapper;
import com.zhonghui.dc.domain.DcNeutralityCalculationRatio;
import com.zhonghui.dc.service.IDcNeutralityCalculationRatioService;

/**
 * 碳中和计算比例Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-27
 */
@Service
public class DcNeutralityCalculationRatioServiceImpl implements IDcNeutralityCalculationRatioService 
{
    @Autowired
    private DcNeutralityCalculationRatioMapper dcNeutralityCalculationRatioMapper;

    /**
     * 查询碳中和计算比例
     * 
     * @param id 碳中和计算比例主键
     * @return 碳中和计算比例
     */
    @Override
    public DcNeutralityCalculationRatio selectDcNeutralityCalculationRatioById(Long id)
    {
        return dcNeutralityCalculationRatioMapper.selectDcNeutralityCalculationRatioById(id);
    }

    /**
     * 查询碳中和计算比例列表
     * 
     * @param dcNeutralityCalculationRatio 碳中和计算比例
     * @return 碳中和计算比例
     */
    @Override
    public List<DcNeutralityCalculationRatio> selectDcNeutralityCalculationRatioList(DcNeutralityCalculationRatio dcNeutralityCalculationRatio)
    {
        return dcNeutralityCalculationRatioMapper.selectDcNeutralityCalculationRatioList(dcNeutralityCalculationRatio);
    }

    /**
     * 新增碳中和计算比例
     * 
     * @param dcNeutralityCalculationRatio 碳中和计算比例
     * @return 结果
     */
    @Override
    public int insertDcNeutralityCalculationRatio(DcNeutralityCalculationRatio dcNeutralityCalculationRatio)
    {
        return dcNeutralityCalculationRatioMapper.insertDcNeutralityCalculationRatio(dcNeutralityCalculationRatio);
    }

    /**
     * 修改碳中和计算比例
     * 
     * @param dcNeutralityCalculationRatio 碳中和计算比例
     * @return 结果
     */
    @Override
    public int updateDcNeutralityCalculationRatio(DcNeutralityCalculationRatio dcNeutralityCalculationRatio)
    {
        return dcNeutralityCalculationRatioMapper.updateDcNeutralityCalculationRatio(dcNeutralityCalculationRatio);
    }

    /**
     * 批量删除碳中和计算比例
     * 
     * @param ids 需要删除的碳中和计算比例主键
     * @return 结果
     */
    @Override
    public int deleteDcNeutralityCalculationRatioByIds(Long[] ids)
    {
        return dcNeutralityCalculationRatioMapper.deleteDcNeutralityCalculationRatioByIds(ids);
    }

    /**
     * 删除碳中和计算比例信息
     * 
     * @param id 碳中和计算比例主键
     * @return 结果
     */
    @Override
    public int deleteDcNeutralityCalculationRatioById(Long id)
    {
        return dcNeutralityCalculationRatioMapper.deleteDcNeutralityCalculationRatioById(id);
    }

    @Override
    public double getElectricCo2() {
        DcNeutralityCalculationRatio dcNeutralityCalculationRatio = new DcNeutralityCalculationRatio();
        List<DcNeutralityCalculationRatio> ncList = dcNeutralityCalculationRatioMapper.selectDcNeutralityCalculationRatioList(dcNeutralityCalculationRatio);
        DcNeutralityCalculationRatio ncConfig = null;
        if (ncList != null && !ncList.isEmpty()) {
            ncConfig = ncList.get(0);
            return ncConfig.getElectricCo2() != null ? ncConfig.getElectricCo2() : 0;
        }
        return 0;
    }

    @Override
    public double getWaterCo2() {
        DcNeutralityCalculationRatio dcNeutralityCalculationRatio = new DcNeutralityCalculationRatio();
        List<DcNeutralityCalculationRatio> ncList = dcNeutralityCalculationRatioMapper.selectDcNeutralityCalculationRatioList(dcNeutralityCalculationRatio);
        DcNeutralityCalculationRatio ncConfig = null;
        if (ncList != null && !ncList.isEmpty()) {
            ncConfig = ncList.get(0);
            return ncConfig.getWaterCo2() != null ? ncConfig.getWaterCo2() : 0;
        }
        return 0;
    }
}
