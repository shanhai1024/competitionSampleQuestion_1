package com.zhonghui.wms.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.zhonghui.common.core.domain.TreeSelect;
import com.zhonghui.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.wms.mapper.WmsMaterialClassifyMapper;
import com.zhonghui.common.core.domain.entity.WmsMaterialClassify;
import com.zhonghui.wms.service.IWmsMaterialClassifyService;

/**
 * 物料分类Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-19
 */
@Service
public class WmsMaterialClassifyServiceImpl implements IWmsMaterialClassifyService 
{
    @Autowired
    private WmsMaterialClassifyMapper wmsMaterialClassifyMapper;

    /**
     * 查询物料分类
     * 
     * @param id 物料分类主键
     * @return 物料分类
     */
    @Override
    public WmsMaterialClassify selectWmsMaterialClassifyById(String id)
    {
        return wmsMaterialClassifyMapper.selectWmsMaterialClassifyById(id);
    }

    /**
     * 查询物料分类列表
     * 
     * @param wmsMaterialClassify 物料分类
     * @return 物料分类
     */
    @Override
    public List<WmsMaterialClassify> selectWmsMaterialClassifyList(WmsMaterialClassify wmsMaterialClassify)
    {
        return wmsMaterialClassifyMapper.selectWmsMaterialClassifyList(wmsMaterialClassify);
    }

    /**
     * 新增物料分类
     * 
     * @param wmsMaterialClassify 物料分类
     * @return 结果
     */
    @Override
    public int insertWmsMaterialClassify(WmsMaterialClassify wmsMaterialClassify)
    {
        return wmsMaterialClassifyMapper.insertWmsMaterialClassify(wmsMaterialClassify);
    }

    /**
     * 修改物料分类
     * 
     * @param wmsMaterialClassify 物料分类
     * @return 结果
     */
    @Override
    public int updateWmsMaterialClassify(WmsMaterialClassify wmsMaterialClassify)
    {
        return wmsMaterialClassifyMapper.updateWmsMaterialClassify(wmsMaterialClassify);
    }

    /**
     * 批量删除物料分类
     * 
     * @param ids 需要删除的物料分类主键
     * @return 结果
     */
    @Override
    public int deleteWmsMaterialClassifyByIds(String[] ids)
    {
        return wmsMaterialClassifyMapper.deleteWmsMaterialClassifyByIds(ids);
    }

    /**
     * 删除物料分类信息
     * 
     * @param id 物料分类主键
     * @return 结果
     */
    @Override
    public int deleteWmsMaterialClassifyById(String id)
    {
        return wmsMaterialClassifyMapper.deleteWmsMaterialClassifyById(id);
    }

    @Override
    public List<TreeSelect> selectClassifyTreeList(WmsMaterialClassify wmsMaterialClassify) {
        List<WmsMaterialClassify> wmsMaterialClassifies = selectWmsMaterialClassifyList(wmsMaterialClassify);
        return buildClassifyTreeSelect(wmsMaterialClassifies);
    }

    /**
     * 构建前端所需要下拉树结构
     *
     * @param wmsMaterialClassify 部门列表
     * @return 下拉树结构列表
     */
    @Override
    public List<TreeSelect> buildClassifyTreeSelect(List<WmsMaterialClassify> wmsMaterialClassify)
    {
        List<WmsMaterialClassify> classifyTrees = buildClassifyTree(wmsMaterialClassify);
        return classifyTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    /**
     * 构建前端所需要树结构
     *
     * @param wmsMaterialClassifies 部门列表
     * @return 树结构列表
     */
    @Override
    public List<WmsMaterialClassify> buildClassifyTree(List<WmsMaterialClassify> wmsMaterialClassifies)
    {
        List<WmsMaterialClassify> returnList = new ArrayList<WmsMaterialClassify>();
        List<Long> tempList = wmsMaterialClassifies.stream().map(WmsMaterialClassify::getId).collect(Collectors.toList());
        for (WmsMaterialClassify wmsMaterialClassify : wmsMaterialClassifies)
        {
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(wmsMaterialClassify.getPid()))
            {
                recursionFn(wmsMaterialClassifies, wmsMaterialClassify);
                returnList.add(wmsMaterialClassify);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = wmsMaterialClassifies;
        }
        return returnList;
    }

    /**
     * 递归列表
     */
    private void recursionFn(List<WmsMaterialClassify> list, WmsMaterialClassify t)
    {
        // 得到子节点列表
        List<WmsMaterialClassify> childList = getChildList(list, t);
        t.setChildren(childList);
        for (WmsMaterialClassify tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<WmsMaterialClassify> getChildList(List<WmsMaterialClassify> list, WmsMaterialClassify t)
    {
        List<WmsMaterialClassify> tlist = new ArrayList<WmsMaterialClassify>();
        Iterator<WmsMaterialClassify> it = list.iterator();
        while (it.hasNext())
        {
            WmsMaterialClassify n = (WmsMaterialClassify) it.next();
            if (StringUtils.isNotNull(n.getPid()) && n.getPid().longValue() == t.getId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<WmsMaterialClassify> list, WmsMaterialClassify t)
    {
        return getChildList(list, t).size() > 0;
    }
}
