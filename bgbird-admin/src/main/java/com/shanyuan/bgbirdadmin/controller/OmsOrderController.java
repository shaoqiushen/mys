package com.shanyuan.bgbirdadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdadmin.dto.OmsOrderDetailInfoResult;
import com.shanyuan.bgbirdadmin.dto.OmsOrderQueryParams;
import com.shanyuan.bgbirdadmin.dto.OmsOrderResult;
import com.shanyuan.bgbirdadmin.service.OmsOrderService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.OmsOrder;
import com.shanyuan.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 17:16
 * <p>
 * desc
 **/
@RequestMapping("/order")
@RestController
@Api(value="OmsOrderController",description="订单管理")
public class OmsOrderController {

    @Autowired
    OmsOrderService omsOrderService;

    @ApiOperation( "订单列表" )
    @PostMapping("/listOrderInfo")
    public CommonResult listOrderInfo(@RequestBody OmsOrderQueryParams omsOrderQueryParams,
                                      @RequestParam(defaultValue="1") Integer pageNum,
                                      @RequestParam(defaultValue="10") Integer pageSize){
        List <OmsOrderResult> omsOrders=omsOrderService.listOrderInfo( omsOrderQueryParams, pageNum, pageSize );
        PageInfo<OmsOrderResult> pageInfo= new PageInfo <>( omsOrders );
        return new CommonResult().pageSuccess( pageInfo );
    }

    @ApiOperation( "修改订单" )
    @PostMapping("/updateOrderInfo")
    public CommonResult updateOrderInfo(@RequestBody OmsOrder omsOrder){
        int count=omsOrderService.updateOrder( omsOrder );
        return ResultUtil.result( count );
    }

    @ApiOperation( "根据订单id查询订单详情" )
    @GetMapping("/getOrderDetailInfo")
    public CommonResult getOrderDetailInfo(@RequestParam Long orderId){
        List<OmsOrderDetailInfoResult> orderDetailInfos=omsOrderService.getOrderDetailInfo( orderId );
        return new CommonResult().success( orderDetailInfos );
    }
}
