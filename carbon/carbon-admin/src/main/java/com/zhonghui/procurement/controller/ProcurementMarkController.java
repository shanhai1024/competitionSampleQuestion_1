package com.zhonghui.procurement.controller;

import com.github.pagehelper.PageHelper;
import com.zhonghui.procurement.domain.ProcurementHaveBid;
import com.zhonghui.procurement.domain.vo.ProcurementMarkVo;
import com.zhonghui.procurement.service.ProcurementMarkService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "采购管理系统-参与投标")
@RestController
@RequestMapping("/procurement")
public class ProcurementMarkController {

    @Autowired
    private ProcurementMarkService procurementMarkService;

    @ApiOperation("参与投标列表")
    @GetMapping("/getMarkList")
    public BaseResult<List<ProcurementMarkVo>> getMarkList(int pageIndex, int pageSize, Integer listType) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ProcurementMarkVo> markList = procurementMarkService.getMarkList(listType);
        return BaseResult.success(markList);
    }

    @ApiOperation("标报名")
    @PostMapping("/updMarkListById")
    public BaseResult updMarkListById(@RequestBody ProcurementHaveBid procurementHaveBid) {
        boolean b = procurementMarkService.updMarkListById(procurementHaveBid);
        System.out.println(b);
        if (b){
            return BaseResult.success("报名成功");
        }
        return BaseResult.success("报名失败,该用户未创建企业信息");
    }
}
