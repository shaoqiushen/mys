package com.shanyuan.bgbirdportal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdportal.dao.PortalOrderDao;
import com.shanyuan.bgbirdportal.dto.PortalOrderDetailResult;
import com.shanyuan.bgbirdportal.dto.PortalOrderParams;
import com.shanyuan.bgbirdportal.dto.PortalOrderQueryParams;
import com.shanyuan.bgbirdportal.dto.PortalOrderQueryResult;
import com.shanyuan.bgbirdportal.service.PortalOrderService;
import com.shanyuan.domain.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-30 8:58
 * <p>
 * desc
 **/
@Api(value="PortalOrderController",description="订单管理")
@RestController
@RequestMapping("/order")
public class PortalOrderController {

    @Autowired
    PortalOrderService portalOrderService;

    @Autowired
    PortalOrderDao portalOrderDao;

//    @ApiOperation( "创建订单" )
//    @PostMapping("/createOrder")
//    public CommonResult  createOrder(@Validated @RequestBody PortalOrderParams portalOrderParams, BindingResult bindingResult){
//        return portalOrderService.createOrder( portalOrderParams );
//    }

    @ApiOperation( "根据购物车信息创建订单" )
    @PostMapping("/createOrderByCart")
    public CommonResult createOrderByCart(@Validated @RequestBody PortalOrderParams portalOrderParams, BindingResult bindingResult){

        return  portalOrderService.createOrderByCart( portalOrderParams );
    }

    @ApiOperation( "修改订单的删除状态" )
    @GetMapping("/updateOrderDeleteStatus/{id}")
    public CommonResult updateOrderDeleteStatus(@PathVariable Integer id,@RequestParam("deleteStatus")Integer deleteStatus){
        int count=portalOrderService.updateOrderDeleteStatus( id, deleteStatus );
        return new CommonResult().success( count );
    }

    @ApiOperation( "查询用户订单信息" )
    @PostMapping("/listOrderInfoByParams")
    public CommonResult listOrderInfoByParams(
            @RequestParam(defaultValue="1")Integer pageNum,
            @RequestParam(defaultValue="10")Integer pageSize,
            @Validated @RequestBody PortalOrderQueryParams portalOrderQueryParams, BindingResult bindingResult){
        List <PortalOrderQueryResult> portalOrderQueryResults=portalOrderService.listOrderInfoByParams( portalOrderQueryParams,pageNum,pageSize );
        PageInfo<PortalOrderQueryResult> portalOrderQueryResultPageInfo = new PageInfo <>( portalOrderQueryResults );
        portalOrderQueryResultPageInfo.setTotal( portalOrderDao.countOrder( portalOrderQueryParams ) );
        return new CommonResult().pageSuccess( portalOrderQueryResultPageInfo );
    }

    @ApiOperation( "根据订单id查询订单详情" )
    @PostMapping("/findOrderInfoById/{orderId}")
    public CommonResult findOrderInfoById(@PathVariable Long orderId){
        PortalOrderDetailResult orderInfoById=portalOrderService.findOrderInfoById( orderId );
        return new CommonResult().success( orderInfoById );
    }
}
