package com.zhonghui.dc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.dc.mapper.DcChangedCarbonEmissionsMapper;
import com.zhonghui.dc.domain.DcChangedCarbonEmissions;
import com.zhonghui.dc.service.IDcChangedCarbonEmissionsService;

/**
 * 变化碳排放Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-24
 */
@Service
public class DcChangedCarbonEmissionsServiceImpl implements IDcChangedCarbonEmissionsService 
{
    @Autowired
    private DcChangedCarbonEmissionsMapper dcChangedCarbonEmissionsMapper;

    /**
     * 查询变化碳排放
     * 
     * @param id 变化碳排放主键
     * @return 变化碳排放
     */
    @Override
    public DcChangedCarbonEmissions selectDcChangedCarbonEmissionsById(Long id)
    {
        return dcChangedCarbonEmissionsMapper.selectDcChangedCarbonEmissionsById(id);
    }

    /**
     * 查询变化碳排放列表
     * 
     * @param dcChangedCarbonEmissions 变化碳排放
     * @return 变化碳排放
     */
    @Override
    public List<DcChangedCarbonEmissions> selectDcChangedCarbonEmissionsList(DcChangedCarbonEmissions dcChangedCarbonEmissions)
    {
        return dcChangedCarbonEmissionsMapper.selectDcChangedCarbonEmissionsList(dcChangedCarbonEmissions);
    }

    /**
     * 新增变化碳排放
     * 
     * @param dcChangedCarbonEmissions 变化碳排放
     * @return 结果
     */
    @Override
    public int insertDcChangedCarbonEmissions(DcChangedCarbonEmissions dcChangedCarbonEmissions)
    {
        return dcChangedCarbonEmissionsMapper.insertDcChangedCarbonEmissions(dcChangedCarbonEmissions);
    }

    /**
     * 修改变化碳排放
     * 
     * @param dcChangedCarbonEmissions 变化碳排放
     * @return 结果
     */
    @Override
    public int updateDcChangedCarbonEmissions(DcChangedCarbonEmissions dcChangedCarbonEmissions)
    {
        return dcChangedCarbonEmissionsMapper.updateDcChangedCarbonEmissions(dcChangedCarbonEmissions);
    }

    /**
     * 批量删除变化碳排放
     * 
     * @param ids 需要删除的变化碳排放主键
     * @return 结果
     */
    @Override
    public int deleteDcChangedCarbonEmissionsByIds(Long[] ids)
    {
        return dcChangedCarbonEmissionsMapper.deleteDcChangedCarbonEmissionsByIds(ids);
    }

    /**
     * 删除变化碳排放信息
     * 
     * @param id 变化碳排放主键
     * @return 结果
     */
    @Override
    public int deleteDcChangedCarbonEmissionsById(Long id)
    {
        return dcChangedCarbonEmissionsMapper.deleteDcChangedCarbonEmissionsById(id);
    }

    @Override
    public double getProductPowerSaveAmount(int days) {
        return calcSavePower(3, days);
    }

    @Override
    public double getOfficePowerSaveAmount(int days) {
        return calcSavePower(4, days);
    }

    /**
     * 计算节约电量
     * @param category
     * @param days
     * @return
     */
    private double calcSavePower(Integer category, int days) {
        DcChangedCarbonEmissions dcChangedCarbonEmissions = new DcChangedCarbonEmissions();
        dcChangedCarbonEmissions.setProjectType(category);
        List<DcChangedCarbonEmissions> cfgList = dcChangedCarbonEmissionsMapper
                .selectDcChangedCarbonEmissionsList(dcChangedCarbonEmissions);
        double total = 0;
        for (DcChangedCarbonEmissions cfg : cfgList) {
            double daySave = cfg.getDaySaveElectric() == null ? 0 : cfg.getDaySaveElectric();
            total = total + daySave * days;
        }
        return total;
    }

    /**
     * 计算节约水量
     * @param category
     * @param days
     * @return
     */
    private double calcSaveWater(Integer category, int days) {
        DcChangedCarbonEmissions dcChangedCarbonEmissions = new DcChangedCarbonEmissions();
        dcChangedCarbonEmissions.setProjectType(category);
        List<DcChangedCarbonEmissions> cfgList = dcChangedCarbonEmissionsMapper
                .selectDcChangedCarbonEmissionsList(dcChangedCarbonEmissions);
        double total = 0;
        for (DcChangedCarbonEmissions cfg : cfgList) {
            double daySave = cfg.getDaySaveWater() == null ? 0 : cfg.getDaySaveWater();
            total = total + daySave * days;
        }
        return total;
    }
}
