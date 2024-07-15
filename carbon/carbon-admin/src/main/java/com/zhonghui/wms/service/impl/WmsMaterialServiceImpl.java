package com.zhonghui.wms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.wms.mapper.WmsMaterialMapper;
import com.zhonghui.wms.domain.WmsMaterial;
import com.zhonghui.wms.service.IWmsMaterialService;

/**
 * 物料档案Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-19
 */
@Service
public class WmsMaterialServiceImpl implements IWmsMaterialService 
{
    @Autowired
    private WmsMaterialMapper wmsMaterialMapper;

    /**
     * 查询物料档案
     * 
     * @param id 物料档案主键
     * @return 物料档案
     */
    @Override
    public WmsMaterial selectWmsMaterialById(Long id)
    {
        return wmsMaterialMapper.selectWmsMaterialById(id);
    }

    /**
     * 查询物料档案列表
     * 
     * @param wmsMaterial 物料档案
     * @return 物料档案
     */
    @Override
    public List<WmsMaterial> selectWmsMaterialList(WmsMaterial wmsMaterial)
    {
        return wmsMaterialMapper.selectWmsMaterialList(wmsMaterial);
    }

    /**
     * 新增物料档案
     * 
     * @param wmsMaterial 物料档案
     * @return 结果
     */
    @Override
    public int insertWmsMaterial(WmsMaterial wmsMaterial)
    {
        return wmsMaterialMapper.insertWmsMaterial(wmsMaterial);
    }

    /**
     * 修改物料档案
     * 
     * @param wmsMaterial 物料档案
     * @return 结果
     */
    @Override
    public int updateWmsMaterial(WmsMaterial wmsMaterial)
    {
        return wmsMaterialMapper.updateWmsMaterial(wmsMaterial);
    }

    /**
     * 批量删除物料档案
     * 
     * @param ids 需要删除的物料档案主键
     * @return 结果
     */
    @Override
    public int deleteWmsMaterialByIds(Long[] ids)
    {
        return wmsMaterialMapper.deleteWmsMaterialByIds(ids);
    }

    /**
     * 删除物料档案信息
     * 
     * @param id 物料档案主键
     * @return 结果
     */
    @Override
    public int deleteWmsMaterialById(Long id)
    {
        return wmsMaterialMapper.deleteWmsMaterialById(id);
    }
}
