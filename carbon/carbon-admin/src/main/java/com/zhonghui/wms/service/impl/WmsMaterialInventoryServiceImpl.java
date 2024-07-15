package com.zhonghui.wms.service.impl;

import java.util.List;

import com.zhonghui.response.BaseResult;
import com.zhonghui.wms.domain.vo.WmsMaterialInventoryVo;
import com.zhonghui.wms.domain.vo.WmsInventoryRelocationInformationVo;
import com.zhonghui.wms.mapper.WmsWarehouseAreaMapper;
import com.zhonghui.wms.mapper.WmsWarehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.zhonghui.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.zhonghui.wms.domain.WmsInventoryDetails;
import com.zhonghui.wms.mapper.WmsMaterialInventoryMapper;
import com.zhonghui.wms.domain.WmsMaterialInventory;
import com.zhonghui.wms.service.IWmsMaterialInventoryService;

/**
 * 物料库存Service业务层处理
 *
 * @author zhonghui
 * @date 2022-05-20
 */
@Service
public class WmsMaterialInventoryServiceImpl implements IWmsMaterialInventoryService
{
    @Autowired
    private WmsMaterialInventoryMapper wmsMaterialInventoryMapper;

    @Autowired
    private WmsWarehouseMapper wmsWarehouseMapper;

    @Autowired
    private WmsWarehouseAreaMapper wmsWarehouseAreaMapper;

    /**
     * 查询物料库存
     *
     * @param id 物料库存主键
     * @return 物料库存
     */
    @Override
    public WmsMaterialInventory selectWmsMaterialInventoryById(Long id)
    {
        WmsMaterialInventory wmsMaterialInventory = wmsMaterialInventoryMapper.selectWmsMaterialInventoryById(id);
        double totalInventory = 0;
        double totalLockInventory = 0;
        for (WmsInventoryDetails details : wmsMaterialInventory.getWmsInventoryDetailsList()) {
            if (wmsMaterialInventory.getWarehouseId() != null && details.getWarehouseAreaId() != null){
                if (wmsWarehouseMapper.selectWmsWarehouseById(wmsMaterialInventory.getWarehouseId()).getWmsWarehouseAreaList() != null){
                    details.setWmsWarehouseAreaList(wmsWarehouseMapper.selectWmsWarehouseById(wmsMaterialInventory.getWarehouseId()).getWmsWarehouseAreaList());
                }
                if (wmsWarehouseAreaMapper.selectWmsWarehouseAreaById(details.getWarehouseAreaId()).getWmsWarehouseSeatList() != null){
                    details.setWmsWarehouseSeatList(wmsWarehouseAreaMapper.selectWmsWarehouseAreaById(details.getWarehouseAreaId()).getWmsWarehouseSeatList());
                }
            }
            if (wmsMaterialInventory.getLockInventory() == null){
                wmsMaterialInventory.setLockInventory(Double.parseDouble("0"));
            }
            if (details.getLockInventory() == null){
                details.setLockInventory(Double.parseDouble("0"));
            }
            totalInventory += details.getExistingInventory() == null ? 0:details.getExistingInventory();
            totalLockInventory += details.getLockInventory() == null ? 0:details.getLockInventory();
        }
        wmsMaterialInventory.setTotalInventory(Double.parseDouble(String.valueOf(totalInventory)));
        wmsMaterialInventory.setLockInventory(Double.parseDouble(String.valueOf(totalLockInventory)));
        return wmsMaterialInventory;
    }

    /**
     * 查询物料库存列表
     *
     * @param wmsMaterialInventoryVo 物料库存出参
     * @return 物料库存
     */
    @Override
    public List<WmsMaterialInventoryVo> selectWmsMaterialInventoryList(WmsMaterialInventoryVo wmsMaterialInventoryVo)
    {
        List<WmsMaterialInventoryVo> list = wmsMaterialInventoryMapper.selectWmsMaterialInventoryList(wmsMaterialInventoryVo);
        if (list.size() > 0){
            for (WmsMaterialInventoryVo inventoryVo:list){
                if (inventoryVo.getTotalInventory() == null || inventoryVo.getLockInventory() == null){
                    inventoryVo.setTotalInventory(Double.parseDouble("0"));
                    inventoryVo.setLockInventory(Double.parseDouble("0"));
                }
            }
        }
        return list;
    }

    /**
     * 新增物料库存
     *
     * @param wmsMaterialInventoryVo 物料库存
     * @return 结果
     */
    @Transactional
    @Override
    public int insertWmsMaterialInventory(WmsMaterialInventoryVo wmsMaterialInventoryVo)
    {
        List<WmsInventoryDetails> list = wmsMaterialInventoryVo.getWmsInventoryDetailsList();
        if (list != null && !list.isEmpty()){
            double total = 0;
            double lock = 0;
            for(WmsInventoryDetails detail:wmsMaterialInventoryVo.getWmsInventoryDetailsList())
            {
                double existingInventory = detail.getExistingInventory() == null ? 0:detail.getExistingInventory();
                double lockInventory = detail.getLockInventory() == null ? 0:detail.getLockInventory();
                total += existingInventory;
                lock += lockInventory;
            }
            wmsMaterialInventoryVo.setTotalInventory(total);
            wmsMaterialInventoryVo.setLockInventory(lock);
        }
        int rows = wmsMaterialInventoryMapper.insertWmsMaterialInventory(wmsMaterialInventoryVo);
        insertWmsInventoryDetails(wmsMaterialInventoryVo);
        return rows;
    }

    /**
     * 修改物料库存
     *
     * @param wmsMaterialInventoryVo 物料库存
     * @return 结果
     */
    @Transactional
    @Override
    public int updateWmsMaterialInventory(WmsMaterialInventoryVo wmsMaterialInventoryVo)
    {
        // 修改总库存和锁定库存
        List<WmsInventoryDetails> list = wmsMaterialInventoryVo.getWmsInventoryDetailsList();
        if (list != null && !list.isEmpty()){
            double total = 0;
            double lock = 0;
            for(WmsInventoryDetails detail:wmsMaterialInventoryVo.getWmsInventoryDetailsList())
            {
                double existingInventory = detail.getExistingInventory() == null ? 0:detail.getExistingInventory();
                double lockInventory = detail.getLockInventory() == null ? 0:detail.getLockInventory();
                total += existingInventory;
                lock += lockInventory;
            }
            wmsMaterialInventoryVo.setTotalInventory(total);
            wmsMaterialInventoryVo.setLockInventory(lock);
        }
        wmsMaterialInventoryMapper.deleteWmsInventoryDetailsByInventoryId(wmsMaterialInventoryVo.getId());
        insertWmsInventoryDetails(wmsMaterialInventoryVo);
        return wmsMaterialInventoryMapper.updateWmsMaterialInventory(wmsMaterialInventoryVo);
    }

    /**
     * 批量删除物料库存
     *
     * @param ids 需要删除的物料库存主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteWmsMaterialInventoryByIds(Long[] ids)
    {
        wmsMaterialInventoryMapper.deleteWmsInventoryDetailsByInventoryIds(ids);
        return wmsMaterialInventoryMapper.deleteWmsMaterialInventoryByIds(ids);
    }

    /**
     * 删除物料库存信息
     *
     * @param id 物料库存主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteWmsMaterialInventoryById(Long id)
    {
        wmsMaterialInventoryMapper.deleteWmsInventoryDetailsByInventoryId(id);
        return wmsMaterialInventoryMapper.deleteWmsMaterialInventoryById(id);
    }

    /**
     * 获取移库信息
     * @param id 物料库存主键
     * @return
     */
    @Override
    public List<WmsInventoryRelocationInformationVo> selectRelocationInfoById(Long id) {
        return wmsMaterialInventoryMapper.selectRelocationInfoById(id);
    }

    /**
     * 新增库存明细信息
     *
     * @param wmsMaterialInventoryVo 物料库存对象
     */
    public void insertWmsInventoryDetails(WmsMaterialInventoryVo wmsMaterialInventoryVo)
    {
        List<WmsInventoryDetails> wmsInventoryDetailsList = wmsMaterialInventoryVo.getWmsInventoryDetailsList();
        Long id = wmsMaterialInventoryVo.getId();
        if (StringUtils.isNotNull(wmsInventoryDetailsList))
        {
            List<WmsInventoryDetails> list = new ArrayList<WmsInventoryDetails>();
            for (WmsInventoryDetails wmsInventoryDetails : wmsInventoryDetailsList)
            {
                wmsInventoryDetails.setMaterialInventoryId(id);
                list.add(wmsInventoryDetails);
            }
            if (list.size() > 0)
            {
                wmsMaterialInventoryMapper.batchWmsInventoryDetails(list);
            }
        }
    }

    /**
     * 更新物料总库存
     * @param id 物料库存主键
     */
    @Transactional
    @Override
    public void updateMaterialTotalInventory(Long id) {
        // 通过库存ID查询物料库存详情
        WmsMaterialInventory inventory = wmsMaterialInventoryMapper.selectWmsMaterialInventoryById(id);
        WmsMaterialInventoryVo inventoryVo = new WmsMaterialInventoryVo();
        inventoryVo.setId(inventory.getId());
        // 获取物料库存明细
        List<WmsInventoryDetails> whMaterialDetailsList = inventory.getWmsInventoryDetailsList();
        double total = 0;
        double lock = 0;
        if(whMaterialDetailsList != null && !whMaterialDetailsList.isEmpty()) {
            for(WmsInventoryDetails detail:whMaterialDetailsList)
            {
                double existingInventory = detail.getExistingInventory() == null ? 0:detail.getExistingInventory();
                double lockInventory = detail.getLockInventory() == null ? 0:detail.getLockInventory();
                total += existingInventory;
                lock += lockInventory;
            }
        }
        inventoryVo.setTotalInventory(total);
        inventoryVo.setLockInventory(lock);
        wmsMaterialInventoryMapper.updateWmsMaterialInventory(inventoryVo);
    }
}
