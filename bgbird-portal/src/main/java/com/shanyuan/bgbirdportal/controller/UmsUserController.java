package com.shanyuan.bgbirdportal.controller;

import io.swagger.annotations.Api;
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
@Api(tags="测试控制器")
public class UmsUserController {

//    @Autowired
//    UmsUserService umsUserService;
//
//    @PostMapping("/aaa")
//    @ApiOperation( value="测试接口" )
//    public CommonResult aaa(){
//
//        List<UmsUser> userInfo=umsUserService.findUserInfo();
////        return new CommonResult().success( userInfo );
//        PageInfo<UmsUser> pageInfo = new PageInfo <>( userInfo );
//        return new CommonResult().pageSuccess( pageInfo );
//    }
}
