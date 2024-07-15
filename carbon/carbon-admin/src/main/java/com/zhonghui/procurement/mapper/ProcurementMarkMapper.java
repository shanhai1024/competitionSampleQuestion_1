package com.zhonghui.procurement.mapper;

import com.zhonghui.procurement.domain.ProcurementMark;
import com.zhonghui.procurement.domain.vo.ProcurementMarkVo;

import java.util.List;

public interface ProcurementMarkMapper {

    /**
     * 查询标列表
     */
    public List<ProcurementMarkVo> getMarkList(Integer type);

    /**
     * 更具id修改标状态（标报名）
     */
    public int updMarkListById(Integer id,Integer type);

    /**
     * 更具id查询
     */
    public ProcurementMark selectMarkListById(Integer id);
}
