package com.zhonghui.procurement.controller;

import com.github.pagehelper.PageHelper;
import com.zhonghui.procurement.domain.vo.ProcurementHaveBidVo;
import com.zhonghui.procurement.service.ProcurementHaveBidService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "采购管理系统-我的投标列表")
@RestController
@RequestMapping("/procurement")
public class ProcurementHaveBidController {

    @Autowired
    private ProcurementHaveBidService procurementHaveBidService;

    @ApiOperation("参与投标-我的投标列表")
    @GetMapping("/getHaveBidList")
    public BaseResult<List<ProcurementHaveBidVo>> getHaveBidList(int pageIndex, int pageSize, int userId) {
        PageHelper.startPage(pageIndex, pageSize);
        return BaseResult.success(procurementHaveBidService.getHaveBidList(userId));
    }
    @ApiOperation("参与投标-详情")
    @GetMapping("/getHaveBidById")
    public BaseResult<ProcurementHaveBidVo> getHaveBidById(int id) {
        return BaseResult.success(procurementHaveBidService.getHaveBidById(id));
    }
    @ApiOperation("参与投标-提交资料")
    @PostMapping("/setHaveBidList")
    public BaseResult setHaveBidList(@RequestParam("id")Integer id,@RequestParam("fileList")String fileList) {
        procurementHaveBidService.setHaveBidList(id,fileList);
        return BaseResult.success();
    }
}
