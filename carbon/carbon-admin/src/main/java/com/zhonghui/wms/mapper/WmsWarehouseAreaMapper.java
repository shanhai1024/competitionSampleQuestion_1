package com.zhonghui.wms.mapper;

import java.util.List;
import com.zhonghui.wms.domain.WmsWarehouseArea;
import com.zhonghui.wms.domain.WmsWarehouseSeat;

/**
 * 库区Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-26
 */
public interface WmsWarehouseAreaMapper 
{
    /**
     * 查询库区
     * 
     * @param id 库区主键
     * @return 库区
     */
    public WmsWarehouseArea selectWmsWarehouseAreaById(Long id);

    /**
     * 查询库区列表
     * 
     * @param wmsWarehouseArea 库区
     * @return 库区集合
     */
    public List<WmsWarehouseArea> selectWmsWarehouseAreaList(WmsWarehouseArea wmsWarehouseArea);

    /**
     * 新增库区
     * 
     * @param wmsWarehouseArea 库区
     * @return 结果
     */
    public int insertWmsWarehouseArea(WmsWarehouseArea wmsWarehouseArea);

    /**
     * 修改库区
     * 
     * @param wmsWarehouseArea 库区
     * @return 结果
     */
    public int updateWmsWarehouseArea(WmsWarehouseArea wmsWarehouseArea);

    /**
     * 删除库区
     * 
     * @param id 库区主键
     * @return 结果
     */
    public int deleteWmsWarehouseAreaById(Long id);

    /**
     * 批量删除库区
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmsWarehouseAreaByIds(Long[] ids);

    /**
     * 批量删除库位
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmsWarehouseSeatByWarehouseAreaIds(Long[] ids);
    
    /**
     * 批量新增库位
     * 
     * @param wmsWarehouseSeatList 库位列表
     * @return 结果
     */
    public int batchWmsWarehouseSeat(List<WmsWarehouseSeat> wmsWarehouseSeatList);
    

    /**
     * 通过库区主键删除库位信息
     * 
     * @param id 库区ID
     * @return 结果
     */
    public int deleteWmsWarehouseSeatByWarehouseAreaId(Long id);
}
