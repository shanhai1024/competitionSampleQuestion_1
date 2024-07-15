package com.zhonghui.procurement.mapper;


import com.zhonghui.procurement.domain.ProcurementHaveBid;
import com.zhonghui.procurement.domain.vo.ProcurementHaveBidVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author admin
* @description 针对表【procurement_have_bid(采购—我的投标表)】的数据库操作Mapper
* @createDate 2023-07-27 16:44:25
* @Entity com.zhonghui.domain.ProcurementHaveBid
*/
public interface ProcurementHaveBidMapper {

    int insert(ProcurementHaveBid record);

    List<ProcurementHaveBidVo> getHaveBidList(int userId);

    int setHaveBidList(@Param("id") int id, @Param("fileList") String fileList);

    ProcurementHaveBidVo getHaveBidById(int id);
}
