package com.zhonghui.mes.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.mes.mapper.MesProjectMaintenanceMapper;
import com.zhonghui.mes.domain.MesProjectMaintenance;
import com.zhonghui.mes.service.IMesProjectMaintenanceService;

/**
 * 项目维护Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
@Service
public class MesProjectMaintenanceServiceImpl implements IMesProjectMaintenanceService 
{
    @Autowired
    private MesProjectMaintenanceMapper mesProjectMaintenanceMapper;

    /**
     * 查询项目维护
     * 
     * @param id 项目维护主键
     * @return 项目维护
     */
    @Override
    public MesProjectMaintenance selectMesProjectMaintenanceById(Integer id)
    {
        return mesProjectMaintenanceMapper.selectMesProjectMaintenanceById(id);
    }

    /**
     * 查询项目维护列表
     * 
     * @param mesProjectMaintenance 项目维护
     * @return 项目维护
     */
    @Override
    public List<MesProjectMaintenance> selectMesProjectMaintenanceList(MesProjectMaintenance mesProjectMaintenance)
    {
        return mesProjectMaintenanceMapper.selectMesProjectMaintenanceList(mesProjectMaintenance);
    }

    /**
     * 新增项目维护
     * 
     * @param mesProjectMaintenance 项目维护
     * @return 结果
     */
    @Override
    public int insertMesProjectMaintenance(MesProjectMaintenance mesProjectMaintenance)
    {
        return mesProjectMaintenanceMapper.insertMesProjectMaintenance(mesProjectMaintenance);
    }

    /**
     * 修改项目维护
     * 
     * @param mesProjectMaintenance 项目维护
     * @return 结果
     */
    @Override
    public int updateMesProjectMaintenance(MesProjectMaintenance mesProjectMaintenance)
    {
        return mesProjectMaintenanceMapper.updateMesProjectMaintenance(mesProjectMaintenance);
    }

    /**
     * 批量删除项目维护
     * 
     * @param ids 需要删除的项目维护主键
     * @return 结果
     */
    @Override
    public int deleteMesProjectMaintenanceByIds(Integer[] ids)
    {
        return mesProjectMaintenanceMapper.deleteMesProjectMaintenanceByIds(ids);
    }

    /**
     * 删除项目维护信息
     * 
     * @param id 项目维护主键
     * @return 结果
     */
    @Override
    public int deleteMesProjectMaintenanceById(Integer id)
    {
        return mesProjectMaintenanceMapper.deleteMesProjectMaintenanceById(id);
    }
}
