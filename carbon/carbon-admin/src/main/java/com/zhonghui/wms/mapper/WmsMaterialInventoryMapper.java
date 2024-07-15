package com.zhonghui.wms.mapper;

import java.util.List;
import com.zhonghui.wms.domain.WmsMaterialInventory;
import com.zhonghui.wms.domain.WmsInventoryDetails;
import com.zhonghui.wms.domain.vo.WmsMaterialInventoryVo;
import com.zhonghui.wms.domain.vo.WmsInventoryRelocationInformationVo;

/**
 * 物料库存Mapper接口
 *
 * @author zhonghui
 * @date 2022-05-20
 */
public interface WmsMaterialInventoryMapper
{
    /**
     * 查询物料库存
     *
     * @param id 物料库存主键
     * @return 物料库存
     */
    public WmsMaterialInventory selectWmsMaterialInventoryById(Long id);

    /**
     * 查询物料库存列表
     *
     * @param wmsMaterialInventoryVo 物料库存出参
     * @return 物料库存集合
     */
    public List<WmsMaterialInventoryVo> selectWmsMaterialInventoryList(WmsMaterialInventoryVo wmsMaterialInventoryVo);

    /**
     * 新增物料库存
     *
     * @param wmsMaterialInventoryVo 物料库存
     * @return 结果
     */
    public int insertWmsMaterialInventory(WmsMaterialInventoryVo wmsMaterialInventoryVo);

    /**
     * 修改物料库存
     *
     * @param wmsMaterialInventoryVo 物料库存
     * @return 结果
     */
    public int updateWmsMaterialInventory(WmsMaterialInventoryVo wmsMaterialInventoryVo);

    /**
     * 删除物料库存
     *
     * @param id 物料库存主键
     * @return 结果
     */
    public int deleteWmsMaterialInventoryById(Long id);

    /**
     * 批量删除物料库存
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmsMaterialInventoryByIds(Long[] ids);

    /**
     * 批量删除库存明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmsInventoryDetailsByInventoryIds(Long[] ids);

    /**
     * 批量新增库存明细
     *
     * @param wmsInventoryDetailsList 库存明细列表
     * @return 结果
     */
    public int batchWmsInventoryDetails(List<WmsInventoryDetails> wmsInventoryDetailsList);


    /**
     * 通过物料库存主键删除库存明细信息
     *
     * @param id 物料库存ID
     * @return 结果
     */
    public int deleteWmsInventoryDetailsByInventoryId(Long id);

    /**
     * 移库信息
     *
     * @param id 物料库存主键
     * @return 结果
     */
    public List<WmsInventoryRelocationInformationVo> selectRelocationInfoById(Long id);

}
