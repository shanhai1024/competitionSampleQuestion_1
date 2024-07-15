package com.zhonghui.procurement.controller;

import com.zhonghui.procurement.domain.ProcurementEnterpriseInformation;
import com.zhonghui.procurement.service.ProcurementEnterpriseInformationService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "采购管理系统-违规投诉")
@RestController
@RequestMapping("/procurement")
public class ProcurementEnterpriseInformationController {

    @Autowired
    private ProcurementEnterpriseInformationService enterpriseInformationService;

    @ApiOperation("修改企业信息")
    @PostMapping("/updateEnterpriseInformation")
    public BaseResult updateEnterpriseInformation(@RequestBody ProcurementEnterpriseInformation enterpriseInformation) {
        // System.out.println(enterpriseInformation);
        enterpriseInformationService.setEnterpriseInformation(enterpriseInformation);
        return BaseResult.success();
    }

    @ApiOperation("查询企业信息")
    @GetMapping("/getEnterpriseInformation")
    public BaseResult<ProcurementEnterpriseInformation> getEnterpriseInformation(Integer userId) {
        return BaseResult.success(enterpriseInformationService.getEnterpriseInformation(userId));
    }
}
