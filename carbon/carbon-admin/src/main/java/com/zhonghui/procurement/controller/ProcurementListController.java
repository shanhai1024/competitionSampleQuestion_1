package com.zhonghui.procurement.controller;

import com.github.pagehelper.PageHelper;
import com.zhonghui.procurement.domain.ProcurementList;
import com.zhonghui.procurement.service.ProcurementListService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "采购管理系统-(平台动态,信息公告,政策法规)")
@RestController
@RequestMapping("/procurement")
public class ProcurementListController {

    @Autowired
    private ProcurementListService procurementListService;

    @ApiOperation("(平台动态,信息公告,政策法规)-列表")
    @GetMapping("/getListByPage")
    public BaseResult<List<ProcurementList>> getProcurementList(Integer pageIndex, Integer pageSize, int listType,Integer announcementType) {
        System.out.println(announcementType);
        if (pageIndex!=null){
            PageHelper.startPage(pageIndex, pageSize);
        }
        List<ProcurementList> procurementList = procurementListService.getProcurementList(listType,announcementType);
        return BaseResult.success(procurementList);
    }

    @ApiOperation("(平台动态,信息公告,政策法规)-详情")
    @GetMapping("/getProcurementListItem")
    public BaseResult<ProcurementList> getProcurementListItem(int id) {
        System.out.println(id);
        ProcurementList procurementList = procurementListService.getProcurementListItem(id);
        return BaseResult.success(procurementList);
    }


}
