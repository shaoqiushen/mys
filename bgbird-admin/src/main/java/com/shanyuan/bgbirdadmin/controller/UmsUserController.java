package com.shanyuan.bgbirdadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdadmin.dto.UmsUserParams;
import com.shanyuan.bgbirdadmin.service.UmsUserService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.UmsUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 18:41
 * <p>
 * desc 普通用户
 **/
@Api(value="UmsUserController",description="用户管理")
@RequestMapping("/user")
@RestController
public class UmsUserController {

    @Autowired
    UmsUserService umsUserService;

    @PostMapping("/listUserInfo")
    @ApiOperation( "条件分页查询所有用户信息" )
    public CommonResult listUserInfo(@RequestBody UmsUserParams umsUserParams,
                                     @RequestParam(defaultValue="1")Integer pageNum,
                                     @RequestParam(defaultValue="10")Integer pageSize){
        List <UmsUser> umsUsers=umsUserService.listUserInfo( umsUserParams, pageNum, pageSize );
        PageInfo<UmsUser> pageInfo = new PageInfo <>( umsUsers );
        return new CommonResult().pageSuccess( pageInfo );
    }
}
