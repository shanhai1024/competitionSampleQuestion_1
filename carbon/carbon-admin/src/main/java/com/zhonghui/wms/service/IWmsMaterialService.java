package com.zhonghui.wms.service;

import java.util.List;
import com.zhonghui.wms.domain.WmsMaterial;

/**
 * 物料档案Service接口
 * 
 * @author zhonghui
 * @date 2022-05-19
 */
public interface IWmsMaterialService 
{
    /**
     * 查询物料档案
     * 
     * @param id 物料档案主键
     * @return 物料档案
     */
    public WmsMaterial selectWmsMaterialById(Long id);

    /**
     * 查询物料档案列表
     * 
     * @param wmsMaterial 物料档案
     * @return 物料档案集合
     */
    public List<WmsMaterial> selectWmsMaterialList(WmsMaterial wmsMaterial);

    /**
     * 新增物料档案
     * 
     * @param wmsMaterial 物料档案
     * @return 结果
     */
    public int insertWmsMaterial(WmsMaterial wmsMaterial);

    /**
     * 修改物料档案
     * 
     * @param wmsMaterial 物料档案
     * @return 结果
     */
    public int updateWmsMaterial(WmsMaterial wmsMaterial);

    /**
     * 批量删除物料档案
     * 
     * @param ids 需要删除的物料档案主键集合
     * @return 结果
     */
    public int deleteWmsMaterialByIds(Long[] ids);

    /**
     * 删除物料档案信息
     * 
     * @param id 物料档案主键
     * @return 结果
     */
    public int deleteWmsMaterialById(Long id);
}
