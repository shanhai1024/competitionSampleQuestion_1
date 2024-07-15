package com.zhonghui.dc.mapper;

import java.util.List;
import com.zhonghui.dc.domain.DcFixedCarbonEmissions;

/**
 * 固定碳排放Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-24
 */
public interface DcFixedCarbonEmissionsMapper 
{
    /**
     * 查询固定碳排放
     * 
     * @param id 固定碳排放主键
     * @return 固定碳排放
     */
    public DcFixedCarbonEmissions selectDcFixedCarbonEmissionsById(Long id);

    /**
     * 查询固定碳排放列表
     * 
     * @param dcFixedCarbonEmissions 固定碳排放
     * @return 固定碳排放集合
     */
    public List<DcFixedCarbonEmissions> selectDcFixedCarbonEmissionsList(DcFixedCarbonEmissions dcFixedCarbonEmissions);

    /**
     * 新增固定碳排放
     * 
     * @param dcFixedCarbonEmissions 固定碳排放
     * @return 结果
     */
    public int insertDcFixedCarbonEmissions(DcFixedCarbonEmissions dcFixedCarbonEmissions);

    /**
     * 修改固定碳排放
     * 
     * @param dcFixedCarbonEmissions 固定碳排放
     * @return 结果
     */
    public int updateDcFixedCarbonEmissions(DcFixedCarbonEmissions dcFixedCarbonEmissions);

    /**
     * 删除固定碳排放
     * 
     * @param id 固定碳排放主键
     * @return 结果
     */
    public int deleteDcFixedCarbonEmissionsById(Long id);

    /**
     * 批量删除固定碳排放
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDcFixedCarbonEmissionsByIds(Long[] ids);
}
