package com.shanyuan.bgbirdadmin.controller;

import com.shanyuan.bgbirdadmin.service.UmsUserMemberService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 18:43
 * <p>
 * desc
 **/
@Api("会员管理")
@RestController
@RequestMapping("/user/member")
public class UmsUserMemberController {

    @Autowired
    UmsUserMemberService umsUserMemberServicel;


    @PostMapping("/obtainCard")
    @ApiOperation( "领取会员卡信息记录入库" )
    public CommonResult obtainCard(@RequestParam String openid,@RequestParam String cardCode){
        int count=umsUserMemberServicel.createMember( openid, cardCode );
        return ResultUtil.result( count );
    }
}
