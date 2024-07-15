package com.zhonghui.dc.service;

import java.util.List;
import com.zhonghui.dc.domain.DcChangedCarbonEmissions;

/**
 * 变化碳排放Service接口
 * 
 * @author zhonghui
 * @date 2022-05-24
 */
public interface IDcChangedCarbonEmissionsService 
{
    /**
     * 查询变化碳排放
     * 
     * @param id 变化碳排放主键
     * @return 变化碳排放
     */
    public DcChangedCarbonEmissions selectDcChangedCarbonEmissionsById(Long id);

    /**
     * 查询变化碳排放列表
     * 
     * @param dcChangedCarbonEmissions 变化碳排放
     * @return 变化碳排放集合
     */
    public List<DcChangedCarbonEmissions> selectDcChangedCarbonEmissionsList(DcChangedCarbonEmissions dcChangedCarbonEmissions);

    /**
     * 新增变化碳排放
     * 
     * @param dcChangedCarbonEmissions 变化碳排放
     * @return 结果
     */
    public int insertDcChangedCarbonEmissions(DcChangedCarbonEmissions dcChangedCarbonEmissions);

    /**
     * 修改变化碳排放
     * 
     * @param dcChangedCarbonEmissions 变化碳排放
     * @return 结果
     */
    public int updateDcChangedCarbonEmissions(DcChangedCarbonEmissions dcChangedCarbonEmissions);

    /**
     * 批量删除变化碳排放
     * 
     * @param ids 需要删除的变化碳排放主键集合
     * @return 结果
     */
    public int deleteDcChangedCarbonEmissionsByIds(Long[] ids);

    /**
     * 删除变化碳排放信息
     * 
     * @param id 变化碳排放主键
     * @return 结果
     */
    public int deleteDcChangedCarbonEmissionsById(Long id);

    /**
     * 获取生产节电数
     * @param days
     * @return
     */
    public double getProductPowerSaveAmount(int days);

    /**
     * 获取办公节电数
     * @param days
     * @return
     */
    public double getOfficePowerSaveAmount(int days);
}
