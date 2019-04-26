package com.shanyuan.bgbirdportal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdportal.dto.PortalUserAddressParams;
import com.shanyuan.bgbirdportal.service.PortalUserAddressService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.UmsUserReceiveAddress;
import com.shanyuan.utils.ResultUtil;
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
 * create 2019-04-25 15:38
 * <p>
 * desc
 **/
@RequestMapping("/user/address")
@Api(value="PortalUserAddressController",description="用户收货地址管理")
@RestController
public class PortalUserAddressController {

    @Autowired
    PortalUserAddressService portalUserAddressService;

    @ApiOperation( "创建用户收货地址" )
    @PostMapping("/createUserAddress")
    public CommonResult createUserAddress(@Validated  @RequestBody PortalUserAddressParams portalUserAddressParams, BindingResult bindingResult){
        int count=portalUserAddressService.createUserAddress( portalUserAddressParams );
        return ResultUtil.result( count );
    }

    @ApiOperation( "删除用户收货地址" )
    @GetMapping("/deleteUserAddress/{id}")
    public CommonResult deleteUserAddress(@PathVariable Integer id){
        int count=portalUserAddressService.deleteUserAddress( id );
        return ResultUtil.result( count );
    }

    @ApiOperation( "修改用户收货地址" )
    @PostMapping("/updateUserAddress/{id}")
    public CommonResult updateUserAddress(@PathVariable Integer id, @Validated @RequestBody PortalUserAddressParams portalUserAddressParams,
                                          BindingResult bindingResult){
        int count=portalUserAddressService.updateUserAddress( id, portalUserAddressParams );
        return ResultUtil.result( count );
    }

    @ApiOperation( "根据用户id分页查询相应的收货地址" )
    @PostMapping("/listUserAddressByUserId")
    public CommonResult listUserAddressByUserId(@RequestParam("userId") String userId,
                                                @RequestParam(defaultValue="1")Integer pageNum,
                                                @RequestParam(defaultValue="10")Integer pageSize){
        List <UmsUserReceiveAddress> umsUserReceiveAddresses=portalUserAddressService.listUserAddressByUserId( userId,pageNum,pageSize );
        PageInfo<UmsUserReceiveAddress> pageInfo = new PageInfo <>( umsUserReceiveAddresses );
        return new CommonResult().pageSuccess( pageInfo );
    }

}
