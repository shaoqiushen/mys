package com.shanyuan.bgbirdportal.controller;

import com.shanyuan.bgbirdportal.dto.PortalOrderParams;
import com.shanyuan.bgbirdportal.service.PortalOrderService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation( "创建订单" )
    @PostMapping("/createOrder")
    public CommonResult  createOrder(@Validated @RequestBody PortalOrderParams portalOrderParams, BindingResult bindingResult){

        return portalOrderService.createOrder( portalOrderParams );

    }
}
