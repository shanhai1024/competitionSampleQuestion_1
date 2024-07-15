package com.zhonghui.wms.mapper;

import java.util.List;
import com.zhonghui.common.core.domain.entity.WmsMaterialClassify;

/**
 * 物料分类Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-19
 */
public interface WmsMaterialClassifyMapper 
{
    /**
     * 查询物料分类
     * 
     * @param id 物料分类主键
     * @return 物料分类
     */
    public WmsMaterialClassify selectWmsMaterialClassifyById(String id);

    /**
     * 查询物料分类列表
     * 
     * @param wmsMaterialClassify 物料分类
     * @return 物料分类集合
     */
    public List<WmsMaterialClassify> selectWmsMaterialClassifyList(WmsMaterialClassify wmsMaterialClassify);

    /**
     * 新增物料分类
     * 
     * @param wmsMaterialClassify 物料分类
     * @return 结果
     */
    public int insertWmsMaterialClassify(WmsMaterialClassify wmsMaterialClassify);

    /**
     * 修改物料分类
     * 
     * @param wmsMaterialClassify 物料分类
     * @return 结果
     */
    public int updateWmsMaterialClassify(WmsMaterialClassify wmsMaterialClassify);

    /**
     * 删除物料分类
     * 
     * @param id 物料分类主键
     * @return 结果
     */
    public int deleteWmsMaterialClassifyById(String id);

    /**
     * 批量删除物料分类
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmsMaterialClassifyByIds(String[] ids);
}
