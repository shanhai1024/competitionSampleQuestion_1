package com.zhonghui.task.service;

import java.util.List;
import com.zhonghui.task.domain.MesJobAssembly;

/**
 * 作业装配Service接口
 * 
 * @author shanhai1024
 * @date 2024-07-01
 */
public interface IMesJobAssemblyService 
{
    /**
     * 查询作业装配
     * 
     * @param id 作业装配主键
     * @return 作业装配
     */
    public MesJobAssembly selectMesJobAssemblyById(Long id);

    /**
     * 查询作业装配列表
     * 
     * @param mesJobAssembly 作业装配
     * @return 作业装配集合
     */
    public List<MesJobAssembly> selectMesJobAssemblyList(MesJobAssembly mesJobAssembly);

    /**
     * 新增作业装配
     * 
     * @param mesJobAssembly 作业装配
     * @return 结果
     */
    public int insertMesJobAssembly(MesJobAssembly mesJobAssembly);

    /**
     * 修改作业装配
     * 
     * @param mesJobAssembly 作业装配
     * @return 结果
     */
    public int updateMesJobAssembly(MesJobAssembly mesJobAssembly);

    /**
     * 批量删除作业装配
     * 
     * @param ids 需要删除的作业装配主键集合
     * @return 结果
     */
    public int deleteMesJobAssemblyByIds(Long[] ids);

    /**
     * 删除作业装配信息
     * 
     * @param id 作业装配主键
     * @return 结果
     */
    public int deleteMesJobAssemblyById(Long id);
}
