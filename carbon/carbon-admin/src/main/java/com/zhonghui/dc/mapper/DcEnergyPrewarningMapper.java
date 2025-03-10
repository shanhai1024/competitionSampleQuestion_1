package com.zhonghui.dc.mapper;

import java.util.List;
import com.zhonghui.dc.domain.DcEnergyPrewarning;

/**
 * 智造双碳-能效预警Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-24
 */
public interface DcEnergyPrewarningMapper 
{
    /**
     * 查询智造双碳-能效预警
     * 
     * @param id 智造双碳-能效预警主键
     * @return 智造双碳-能效预警
     */
    public DcEnergyPrewarning selectDcEnergyPrewarningById(Long id);

    /**
     * 查询智造双碳-能效预警列表
     * 
     * @param dcEnergyPrewarning 智造双碳-能效预警
     * @return 智造双碳-能效预警集合
     */
    public List<DcEnergyPrewarning> selectDcEnergyPrewarningList(DcEnergyPrewarning dcEnergyPrewarning);

    /**
     * 新增智造双碳-能效预警
     * 
     * @param dcEnergyPrewarning 智造双碳-能效预警
     * @return 结果
     */
    public int insertDcEnergyPrewarning(DcEnergyPrewarning dcEnergyPrewarning);

    /**
     * 修改智造双碳-能效预警
     * 
     * @param dcEnergyPrewarning 智造双碳-能效预警
     * @return 结果
     */
    public int updateDcEnergyPrewarning(DcEnergyPrewarning dcEnergyPrewarning);

    /**
     * 删除智造双碳-能效预警
     * 
     * @param id 智造双碳-能效预警主键
     * @return 结果
     */
    public int deleteDcEnergyPrewarningById(Long id);

    /**
     * 批量删除智造双碳-能效预警
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDcEnergyPrewarningByIds(Long[] ids);
}
