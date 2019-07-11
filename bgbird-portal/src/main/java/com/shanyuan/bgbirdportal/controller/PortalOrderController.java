package com.shanyuan.bgbirdportal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdportal.dao.PortalOrderDao;
import com.shanyuan.bgbirdportal.dto.PortalOrderDetailResult;
import com.shanyuan.bgbirdportal.dto.PortalOrderParams;
import com.shanyuan.bgbirdportal.dto.PortalOrderQueryParams;
import com.shanyuan.bgbirdportal.dto.PortalOrderQueryResult;
import com.shanyuan.bgbirdportal.service.PortalOrderService;
import com.shanyuan.bgbirdportal.service.PortalUserPointsService;
import com.shanyuan.domain.CommonResult;

import com.shanyuan.model.OmsOrder;
import com.shanyuan.model.OmsOrderPrepay;
import com.shanyuan.model.UmsUserMember;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
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
@Slf4j
public class PortalOrderController {

    @Autowired
    PortalOrderService portalOrderService;

    @Autowired
    PortalOrderDao portalOrderDao;

    @Autowired
    PortalUserPointsService portalUserPointsService;


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
        int total=portalOrderDao.countOrder( portalOrderQueryParams );
        portalOrderQueryResultPageInfo.setTotal( total );
        int totalPage = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        double v=Double.parseDouble( df.format( (double ) total / pageSize ) );

        if((v)%2==0 || (v)%2 == 1){
            //说明是分页不产生多余数据
            totalPage = (int)v;
        }else{
            totalPage  = (int) v + 1;
        }
        portalOrderQueryResultPageInfo.setPages( totalPage );
        portalOrderQueryResultPageInfo.setPageNum( pageNum );
        return new CommonResult().pageSuccess( portalOrderQueryResultPageInfo );
    }

    @ApiOperation( "根据订单id查询订单详情" )
    @PostMapping("/findOrderInfoById/{orderId}")
    public CommonResult findOrderInfoById(@PathVariable Long orderId){
        PortalOrderDetailResult orderInfoById=portalOrderService.findOrderInfoById( orderId );
        return new CommonResult().success( orderInfoById );
    }

    /**
     * 微信支付异步通知回调
     */
    @PostMapping("/notify")
    public void notifyWxPayInfo(@RequestParam String out_trade_no,@RequestParam String result_code) {
        log.info( "微信支付回调notifyWxPayInfo start" );
        //根据订单号去修改订单的支付状态
        if(result_code.equals( "SUCCESS" )){
            //修改订单支付状态
            portalOrderService.updateOrderStatus( Long.parseLong( out_trade_no ) );
            //修改预支付成功状态
            portalOrderService.updatePrePayStatus( out_trade_no );
            //增加积分
            //查询用户cardcode,消费金额
            OmsOrder order=portalOrderService.getOrder( Long.parseLong( out_trade_no ) );
            UmsUserMember userPointsInfo=portalUserPointsService.getUserPointsInfo( order.getUserId() );
            if(userPointsInfo != null){
                //假如有会员卡
                portalUserPointsService.updateIntegration( userPointsInfo.getCardCode(),(int)(order.getPayAmount()/100) );
            }else {
                log.info( order.getUserId()+"no have member card" );
            }
        }
    }

    @ApiOperation( "再次拉取支付信息" )
    @PostMapping("/getPayInfo")
    public CommonResult getPayInfo(@RequestParam String orderId){
        OmsOrderPrepay payInfo=portalOrderService.getPayInfo( orderId );
        return new CommonResult().success( payInfo );
    }
}
