package com.zhonghui.wms.service;

import java.util.List;

import com.zhonghui.common.core.domain.TreeSelect;
import com.zhonghui.common.core.domain.entity.WmsMaterialClassify;

/**
 * 物料分类Service接口
 * 
 * @author zhonghui
 * @date 2022-05-19
 */
public interface IWmsMaterialClassifyService 
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
     * 批量删除物料分类
     * 
     * @param ids 需要删除的物料分类主键集合
     * @return 结果
     */
    public int deleteWmsMaterialClassifyByIds(String[] ids);

    /**
     * 删除物料分类信息
     * 
     * @param id 物料分类主键
     * @return 结果
     */
    public int deleteWmsMaterialClassifyById(String id);

    /**
     * 查询物料分类树结构信息
     *
     * @param wmsMaterialClassify 物料分类信息
     * @return 料分类树信息集合
     */
    public List<TreeSelect> selectClassifyTreeList(WmsMaterialClassify wmsMaterialClassify);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param wmsMaterialClassifyList 物料分类
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildClassifyTreeSelect(List<WmsMaterialClassify> wmsMaterialClassifyList);

    /**
     * 构建前端所需要树结构
     *
     * @param wmsMaterialClassifies 物料分类
     * @return 树结构列表
     */
    public List<WmsMaterialClassify> buildClassifyTree(List<WmsMaterialClassify> wmsMaterialClassifies);
}
