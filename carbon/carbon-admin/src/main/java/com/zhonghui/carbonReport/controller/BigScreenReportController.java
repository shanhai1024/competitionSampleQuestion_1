package com.zhonghui.carbonReport.controller;

import com.zhonghui.carbonReport.service.IViewScmSaleContractService;
import com.zhonghui.carbonReport.service.IViewScmSaleScheduleDetailsService;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.utils.DateUtils;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Api(tags = {"数据可视化图表展示"})
@RestController
@RequestMapping("/carbonReport")
public class BigScreenReportController extends BaseController {

    @Autowired
    private IViewScmSaleContractService viewScmSaleContractService;

    @Autowired
    private IViewScmSaleScheduleDetailsService viewScmSaleScheduleDetailsService;

    @GetMapping("/saleOverall")
    @ApiOperation("销售总览：本年、本月、本日销售额")
    public BaseResult<Map<String, BigDecimal>> saleOverall() {
        Map<String, BigDecimal> map = viewScmSaleContractService.selectSaleOverall();
        return BaseResult.success(map);
    }

    @GetMapping("/saleCustomer/ranking")
    @ApiOperation("客户销售排名")
    public BaseResult<List<Map<String, BigDecimal>>> saleCustomerRank() {
        List<Map<String, BigDecimal>> list = viewScmSaleContractService.selectSaleCustomerRank();
        return BaseResult.success(list);
    }

    @GetMapping("/saleStat")
    @ApiOperation("销售统计")
    public BaseResult<Map<String, Object>> saleStat() {
        List<String> dateList = new ArrayList<>();
        for (int i = 5; i >= 0; i--) {
            Date month = DateUtils.addMonths(new Date(), -1 * i);
            dateList.add(DateUtils.parseDateToStr(DateUtils.YYYY_MM, month));
        }
        List<BigDecimal> numList = new ArrayList<>();
        List<BigDecimal> numList2 = new ArrayList<>();
        for (String month : dateList) {
            Map<String, BigDecimal> map = viewScmSaleContractService.selectSaleStatByMonth(month);
            numList.add(map.get("contractTotal").divide(new BigDecimal(10000)).setScale(2, RoundingMode.HALF_UP));
            numList2.add(map.get("orderTotal").divide(new BigDecimal(10000)).setScale(2, RoundingMode.HALF_UP));
        }
        Map<String, Object> result = new HashMap<>();
        result.put("dateList", dateList);
        result.put("numList", numList);
        result.put("numList2", numList2);
        return BaseResult.success(result);
    }

    @GetMapping("/salePlan/achieveRate")
    @ApiOperation("销售计划完成率")
    public BaseResult<Map<String, Object>> salePlanAchieveRate() {
        List<String> category = new ArrayList<>();
        for (int i = 11; i >= 0; i--) {
            Date month = DateUtils.addMonths(new Date(), -1 * i);
            category.add(DateUtils.parseDateToStr(DateUtils.YYYY_MM, month));
        }
        List<BigDecimal> barData = new ArrayList<>();
        List<BigDecimal> lineData = new ArrayList<>();
        List<String> rateData = new ArrayList<>();
        for (String month : category) {
            Map<String, BigDecimal> map = viewScmSaleScheduleDetailsService.selectAchieveRateByMonth(month);
            BigDecimal contractTotal = map.get("contractTotal");
            BigDecimal planTotal = map.get("planTotal");
            barData.add(contractTotal.divide(new BigDecimal(10000)).setScale(2, RoundingMode.HALF_UP));
            lineData.add(planTotal.divide(new BigDecimal(10000)).setScale(2, RoundingMode.HALF_UP));
            if (planTotal.compareTo(BigDecimal.ZERO) == 0) {
                if (contractTotal.compareTo(BigDecimal.ZERO) == 0) {
                    rateData.add("0");
                } else {
                    rateData.add("100");
                }
            } else {
                double rate = (contractTotal.divide(planTotal,RoundingMode.HALF_UP)).doubleValue() * 100;
                rateData.add(rate >= 100 ? "100" : String.valueOf((int) rate));
            }
        }
        Map<String, Object> result = new HashMap<>();
        result.put("barData", barData);
        result.put("lineData", lineData);
        result.put("rateData", rateData);
        result.put("category", category);
        return BaseResult.success(result);
    }

}
