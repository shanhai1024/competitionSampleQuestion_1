package com.zhonghui.mes.mapper;

import java.util.List;
import com.zhonghui.mes.domain.MesProjectMaintenance;

/**
 * 项目维护Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-21
 */
public interface MesProjectMaintenanceMapper 
{
    /**
     * 查询项目维护
     * 
     * @param id 项目维护主键
     * @return 项目维护
     */
    public MesProjectMaintenance selectMesProjectMaintenanceById(Integer id);

    /**
     * 查询项目维护列表
     * 
     * @param mesProjectMaintenance 项目维护
     * @return 项目维护集合
     */
    public List<MesProjectMaintenance> selectMesProjectMaintenanceList(MesProjectMaintenance mesProjectMaintenance);

    /**
     * 新增项目维护
     * 
     * @param mesProjectMaintenance 项目维护
     * @return 结果
     */
    public int insertMesProjectMaintenance(MesProjectMaintenance mesProjectMaintenance);

    /**
     * 修改项目维护
     * 
     * @param mesProjectMaintenance 项目维护
     * @return 结果
     */
    public int updateMesProjectMaintenance(MesProjectMaintenance mesProjectMaintenance);

    /**
     * 删除项目维护
     * 
     * @param id 项目维护主键
     * @return 结果
     */
    public int deleteMesProjectMaintenanceById(Integer id);

    /**
     * 批量删除项目维护
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesProjectMaintenanceByIds(Integer[] ids);
}
