package com.shanyuan.bgbirdportal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdportal.dto.PortalCartParams;
import com.shanyuan.bgbirdportal.dto.PortalCartResult;
import com.shanyuan.bgbirdportal.service.PortalCartService;
import com.shanyuan.domain.CommonResult;
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
 * create 2019-04-30 10:11
 * <p>
 * desc
 **/
@Api(value="PortalCartController",description="购物车管理")
@RestController
@RequestMapping("/cart")
public class PortalCartController {

    @Autowired
    PortalCartService portalCartService;

    @ApiOperation( "创建购物车" )
    @PostMapping("/createCart")
    public CommonResult createCart(@Validated @RequestBody PortalCartParams portalCartParams, BindingResult bindingResult){
        int count=portalCartService.createCart( portalCartParams );
        return ResultUtil.result( count );
    }

    @ApiOperation( "修改购物车为删除状态" )
    @GetMapping("/updateCartDeleteStatus/{id}")
    public CommonResult updateCartDeleteStatus(@PathVariable Integer id){
        int count=portalCartService.updateCartDeleteStatus( id );
        return ResultUtil.result( count );
    }

    @ApiOperation( "修改购买数量" )
    @PostMapping("/updateCartBuyCount/{id}")
    public CommonResult updateCartBuyCount(@PathVariable Integer id, @Validated @RequestParam Integer buyCount){
        if(buyCount < 1){
            return ResultUtil.result( 0 );
        }
        int count = portalCartService.updateCartBuyCount( id,buyCount );
        return ResultUtil.result( count );
    }

    @ApiOperation( "根据用户id查询用户购物车" )
    @PostMapping("/listCartByUserId")
    public CommonResult listCartByUserId(@RequestParam String userId,
                                         @RequestParam(defaultValue="1")Integer pageNum,
                                         @RequestParam(defaultValue="10")Integer pageSize){
        List <PortalCartResult> portalCartResults=portalCartService.listCartByUserId( userId, pageNum, pageSize );
        PageInfo<PortalCartResult> portalCartResultPageInfo = new PageInfo <>( portalCartResults );
        return new CommonResult().pageSuccess( portalCartResultPageInfo );
    }
}
