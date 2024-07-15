package com.zhonghui.dc.mapper;

import java.util.List;
import com.zhonghui.dc.domain.DcChangedCarbonEmissions;

/**
 * 变化碳排放Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-24
 */
public interface DcChangedCarbonEmissionsMapper 
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
     * 删除变化碳排放
     * 
     * @param id 变化碳排放主键
     * @return 结果
     */
    public int deleteDcChangedCarbonEmissionsById(Long id);

    /**
     * 批量删除变化碳排放
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDcChangedCarbonEmissionsByIds(Long[] ids);
}
