package com.zhonghui.dc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.dc.mapper.DcFixedCarbonEmissionsMapper;
import com.zhonghui.dc.domain.DcFixedCarbonEmissions;
import com.zhonghui.dc.service.IDcFixedCarbonEmissionsService;

/**
 * 固定碳排放Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-24
 */
@Service
public class DcFixedCarbonEmissionsServiceImpl implements IDcFixedCarbonEmissionsService 
{
    @Autowired
    private DcFixedCarbonEmissionsMapper dcFixedCarbonEmissionsMapper;

    /**
     * 查询固定碳排放
     * 
     * @param id 固定碳排放主键
     * @return 固定碳排放
     */
    @Override
    public DcFixedCarbonEmissions selectDcFixedCarbonEmissionsById(Long id)
    {
        return dcFixedCarbonEmissionsMapper.selectDcFixedCarbonEmissionsById(id);
    }

    /**
     * 查询固定碳排放列表
     * 
     * @param dcFixedCarbonEmissions 固定碳排放
     * @return 固定碳排放
     */
    @Override
    public List<DcFixedCarbonEmissions> selectDcFixedCarbonEmissionsList(DcFixedCarbonEmissions dcFixedCarbonEmissions)
    {
        return dcFixedCarbonEmissionsMapper.selectDcFixedCarbonEmissionsList(dcFixedCarbonEmissions);
    }

    /**
     * 新增固定碳排放
     * 
     * @param dcFixedCarbonEmissions 固定碳排放
     * @return 结果
     */
    @Override
    public int insertDcFixedCarbonEmissions(DcFixedCarbonEmissions dcFixedCarbonEmissions)
    {
        return dcFixedCarbonEmissionsMapper.insertDcFixedCarbonEmissions(dcFixedCarbonEmissions);
    }

    /**
     * 修改固定碳排放
     * 
     * @param dcFixedCarbonEmissions 固定碳排放
     * @return 结果
     */
    @Override
    public int updateDcFixedCarbonEmissions(DcFixedCarbonEmissions dcFixedCarbonEmissions)
    {
        return dcFixedCarbonEmissionsMapper.updateDcFixedCarbonEmissions(dcFixedCarbonEmissions);
    }

    /**
     * 批量删除固定碳排放
     * 
     * @param ids 需要删除的固定碳排放主键
     * @return 结果
     */
    @Override
    public int deleteDcFixedCarbonEmissionsByIds(Long[] ids)
    {
        return dcFixedCarbonEmissionsMapper.deleteDcFixedCarbonEmissionsByIds(ids);
    }

    /**
     * 删除固定碳排放信息
     * 
     * @param id 固定碳排放主键
     * @return 结果
     */
    @Override
    public int deleteDcFixedCarbonEmissionsById(Long id)
    {
        return dcFixedCarbonEmissionsMapper.deleteDcFixedCarbonEmissionsById(id);
    }

    @Override
    public double getProductWaterConsumeByMonth() {
        DcFixedCarbonEmissions dcFixedCarbonEmissions = new DcFixedCarbonEmissions();
        dcFixedCarbonEmissions.setTimeType(2);
        dcFixedCarbonEmissions.setProjectType(2);
        List<DcFixedCarbonEmissions> consumePwList = dcFixedCarbonEmissionsMapper
                .selectDcFixedCarbonEmissionsList(dcFixedCarbonEmissions);
        double total = 0;
        for (DcFixedCarbonEmissions consume : consumePwList) {
            double energy = consume.getEnergyConsumptionAmount() == null ? 0 : consume.getEnergyConsumptionAmount();
            total = total + energy;
        }
        return total;
    }

    @Override
    public double getOfficeWaterConsumeByMonth() {
        DcFixedCarbonEmissions dcFixedCarbonEmissions = new DcFixedCarbonEmissions();
        dcFixedCarbonEmissions.setTimeType(2);
        dcFixedCarbonEmissions.setProjectType(3);
        List<DcFixedCarbonEmissions> consumePwList = dcFixedCarbonEmissionsMapper
                .selectDcFixedCarbonEmissionsList(dcFixedCarbonEmissions);
        double total = 0;
        for (DcFixedCarbonEmissions consume : consumePwList) {
            double energy = consume.getEnergyConsumptionAmount() == null ? 0 : consume.getEnergyConsumptionAmount();
            total = total + energy;
        }
        return total;
    }

    @Override
    public double getOfficePowerConsumeByMonth() {
        DcFixedCarbonEmissions dcFixedCarbonEmissions = new DcFixedCarbonEmissions();
        dcFixedCarbonEmissions.setTimeType(2);
        dcFixedCarbonEmissions.setProjectType(1);
        List<DcFixedCarbonEmissions> consumePwList = dcFixedCarbonEmissionsMapper
                .selectDcFixedCarbonEmissionsList(dcFixedCarbonEmissions);
        double total = 0;
        for (DcFixedCarbonEmissions consume : consumePwList) {
            double energy = consume.getEnergyConsumptionAmount() == null ? 0 : consume.getEnergyConsumptionAmount();
            total = total + energy;
        }
        return total;
    }
}
