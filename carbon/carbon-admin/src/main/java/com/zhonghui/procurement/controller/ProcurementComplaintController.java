package com.zhonghui.procurement.controller;

import com.github.pagehelper.PageHelper;
import com.zhonghui.procurement.domain.ProcurementComplaint;
import com.zhonghui.procurement.service.ProcurementComplaintService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "采购管理系统-违规投诉")
@RestController
@RequestMapping("/procurement")
public class ProcurementComplaintController {

    @Autowired
    private ProcurementComplaintService procurementComplaintService;

    @ApiOperation("违规投诉列表")
    @GetMapping("getComplaintList")
    public BaseResult<List<ProcurementComplaint>> getComplaintList(Integer type, Integer pageIndex, Integer pageSize) {
        System.out.println(type);
        PageHelper.startPage(pageIndex, pageSize);
        List<ProcurementComplaint> complaintList = procurementComplaintService.getComplaintList(type);
        return BaseResult.success(complaintList);
    }

    /**
     * 新增投诉
     *
     * @param procurementComplaint
     * @return
     */
    @ApiOperation("新增投诉")
    @PostMapping("/setComplaint")
    public BaseResult<Integer> setProcurement(@RequestBody ProcurementComplaint procurementComplaint) {
        int i = procurementComplaintService.setProcurement(procurementComplaint);
        if (i >= 1) {
            return BaseResult.success("添加成功");
        } else {
            return BaseResult.error("添加失败");
        }
    }

    @ApiOperation("违规投诉详情")
    @GetMapping("/getComplaintListItem")
    public BaseResult<ProcurementComplaint> getComplaintListItem(Integer id) {
        ProcurementComplaint procurementComplaint = procurementComplaintService.getComplaintListItem(id);
        return BaseResult.success(procurementComplaint);
    }
}
