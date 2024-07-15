package com.zhonghui.wms.mapper;

import java.util.List;
import com.zhonghui.wms.domain.WmsWarehouse;
import com.zhonghui.wms.domain.WmsWarehouseArea;

/**
 * 仓库Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-20
 */
public interface WmsWarehouseMapper 
{
    /**
     * 查询仓库
     * 
     * @param id 仓库主键
     * @return 仓库
     */
    public WmsWarehouse selectWmsWarehouseById(Long id);

    /**
     * 查询仓库列表
     * 
     * @param wmsWarehouse 仓库
     * @return 仓库集合
     */
    public List<WmsWarehouse> selectWmsWarehouseList(WmsWarehouse wmsWarehouse);

    /**
     * 新增仓库
     * 
     * @param wmsWarehouse 仓库
     * @return 结果
     */
    public int insertWmsWarehouse(WmsWarehouse wmsWarehouse);

    /**
     * 修改仓库
     * 
     * @param wmsWarehouse 仓库
     * @return 结果
     */
    public int updateWmsWarehouse(WmsWarehouse wmsWarehouse);

    /**
     * 删除仓库
     * 
     * @param id 仓库主键
     * @return 结果
     */
    public int deleteWmsWarehouseById(Long id);

    /**
     * 批量删除仓库
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmsWarehouseByIds(Long[] ids);

    /**
     * 批量删除库区
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmsWarehouseAreaByWarehouseIds(Long[] ids);
    
    /**
     * 批量新增库区
     * 
     * @param wmsWarehouseAreaList 库区列表
     * @return 结果
     */
    public int batchWmsWarehouseArea(List<WmsWarehouseArea> wmsWarehouseAreaList);
    

    /**
     * 通过仓库主键删除库区信息
     * 
     * @param id 仓库ID
     * @return 结果
     */
    public int deleteWmsWarehouseAreaByWarehouseId(Long id);
}
