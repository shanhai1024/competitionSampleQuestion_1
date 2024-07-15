package com.zhonghui.task.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.task.mapper.MesJobAssemblyMapper;
import com.zhonghui.task.domain.MesJobAssembly;
import com.zhonghui.task.service.IMesJobAssemblyService;

/**
 * 作业装配Service业务层处理
 * 
 * @author shanhai1024
 * @date 2024-07-01
 */
@Service
public class MesJobAssemblyServiceImpl implements IMesJobAssemblyService 
{
    @Autowired
    private MesJobAssemblyMapper mesJobAssemblyMapper;

    /**
     * 查询作业装配
     * 
     * @param id 作业装配主键
     * @return 作业装配
     */
    @Override
    public MesJobAssembly selectMesJobAssemblyById(Long id)
    {
        return mesJobAssemblyMapper.selectMesJobAssemblyById(id);
    }

    /**
     * 查询作业装配列表
     * 
     * @param mesJobAssembly 作业装配
     * @return 作业装配
     */
    @Override
    public List<MesJobAssembly> selectMesJobAssemblyList(MesJobAssembly mesJobAssembly)
    {
        return mesJobAssemblyMapper.selectMesJobAssemblyList(mesJobAssembly);
    }

    /**
     * 新增作业装配
     * 
     * @param mesJobAssembly 作业装配
     * @return 结果
     */
    @Override
    public int insertMesJobAssembly(MesJobAssembly mesJobAssembly)
    {
        return mesJobAssemblyMapper.insertMesJobAssembly(mesJobAssembly);
    }

    /**
     * 修改作业装配
     * 
     * @param mesJobAssembly 作业装配
     * @return 结果
     */
    @Override
    public int updateMesJobAssembly(MesJobAssembly mesJobAssembly)
    {
        return mesJobAssemblyMapper.updateMesJobAssembly(mesJobAssembly);
    }

    /**
     * 批量删除作业装配
     * 
     * @param ids 需要删除的作业装配主键
     * @return 结果
     */
    @Override
    public int deleteMesJobAssemblyByIds(Long[] ids)
    {
        return mesJobAssemblyMapper.deleteMesJobAssemblyByIds(ids);
    }

    /**
     * 删除作业装配信息
     * 
     * @param id 作业装配主键
     * @return 结果
     */
    @Override
    public int deleteMesJobAssemblyById(Long id)
    {
        return mesJobAssemblyMapper.deleteMesJobAssemblyById(id);
    }
}
