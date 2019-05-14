package com.shanyuan.bgbirdportal.controller;

import com.shanyuan.bgbirdportal.dto.PortalAuthorizationParams;
import com.shanyuan.bgbirdportal.service.PortalUmsUserService;
import com.shanyuan.domain.CommonResult;
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
 * create 2019-04-15 16:43
 * <p>
 * desc
 **/
@RestController
@RequestMapping("/user")
@Api(value="PortalUmsUserController",description="用户授权注册管理")
public class PortalUmsUserController {

    @Autowired
    PortalUmsUserService portalUmsUserService;

    @ApiOperation( "用户授权登录" )
    @PostMapping("/authorization")
    public CommonResult authorization(@Validated @RequestBody PortalAuthorizationParams portalAuthorizationParams, BindingResult bindingResult){
        CommonResult authorization=portalUmsUserService.authorization( portalAuthorizationParams );
        if(authorization.getCode() != 200){
            return new CommonResult().failed( "授权登录失败" );
        }
        return  authorization;
    }
}
