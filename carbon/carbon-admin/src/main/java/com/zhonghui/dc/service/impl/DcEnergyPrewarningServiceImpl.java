package com.zhonghui.dc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.dc.mapper.DcEnergyPrewarningMapper;
import com.zhonghui.dc.domain.DcEnergyPrewarning;
import com.zhonghui.dc.service.IDcEnergyPrewarningService;

/**
 * 智造双碳-能效预警Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-24
 */
@Service
public class DcEnergyPrewarningServiceImpl implements IDcEnergyPrewarningService 
{
    @Autowired
    private DcEnergyPrewarningMapper dcEnergyPrewarningMapper;

    /**
     * 查询智造双碳-能效预警
     * 
     * @param id 智造双碳-能效预警主键
     * @return 智造双碳-能效预警
     */
    @Override
    public DcEnergyPrewarning selectDcEnergyPrewarningById(Long id)
    {
        return dcEnergyPrewarningMapper.selectDcEnergyPrewarningById(id);
    }

    /**
     * 查询智造双碳-能效预警列表
     * 
     * @param dcEnergyPrewarning 智造双碳-能效预警
     * @return 智造双碳-能效预警
     */
    @Override
    public List<DcEnergyPrewarning> selectDcEnergyPrewarningList(DcEnergyPrewarning dcEnergyPrewarning)
    {
        return dcEnergyPrewarningMapper.selectDcEnergyPrewarningList(dcEnergyPrewarning);
    }

    /**
     * 新增智造双碳-能效预警
     * 
     * @param dcEnergyPrewarning 智造双碳-能效预警
     * @return 结果
     */
    @Override
    public int insertDcEnergyPrewarning(DcEnergyPrewarning dcEnergyPrewarning)
    {
        return dcEnergyPrewarningMapper.insertDcEnergyPrewarning(dcEnergyPrewarning);
    }

    /**
     * 修改智造双碳-能效预警
     * 
     * @param dcEnergyPrewarning 智造双碳-能效预警
     * @return 结果
     */
    @Override
    public int updateDcEnergyPrewarning(DcEnergyPrewarning dcEnergyPrewarning)
    {
        return dcEnergyPrewarningMapper.updateDcEnergyPrewarning(dcEnergyPrewarning);
    }

    /**
     * 批量删除智造双碳-能效预警
     * 
     * @param ids 需要删除的智造双碳-能效预警主键
     * @return 结果
     */
    @Override
    public int deleteDcEnergyPrewarningByIds(Long[] ids)
    {
        return dcEnergyPrewarningMapper.deleteDcEnergyPrewarningByIds(ids);
    }

    /**
     * 删除智造双碳-能效预警信息
     * 
     * @param id 智造双碳-能效预警主键
     * @return 结果
     */
    @Override
    public int deleteDcEnergyPrewarningById(Long id)
    {
        return dcEnergyPrewarningMapper.deleteDcEnergyPrewarningById(id);
    }
}
