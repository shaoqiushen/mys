package com.shanyuan.bgbirdadmin.controller;

import com.shanyuan.bgbirdadmin.dto.PmsProductExchangeParams;
import com.shanyuan.bgbirdadmin.dto.PmsProductExchangeResult;
import com.shanyuan.bgbirdadmin.service.PmsProductExchangeService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.PmsProductExchange;
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
 * create 2019-05-09 15:56
 * <p>
 * desc
 **/
@Api(value="PmsProductExchangeController",description="积分商城管理")
@RestController
@RequestMapping("/exchange")
public class PmsProductExchangeController {

    @Autowired
    PmsProductExchangeService pmsProductExchangeService;

    @ApiOperation( "积分商城产品创建" )
    @PostMapping("/createProductExchange")
    public CommonResult createProductExchange(@Validated @RequestBody PmsProductExchangeParams pmsProductExchangeParams, BindingResult bindingResult){
        int count=pmsProductExchangeService.createProductExchange( pmsProductExchangeParams );
        return new CommonResult().success( count );
    }

    @ApiOperation( "根据产品id修改对应的兑换商品的删除状态" )
    @PostMapping("/updateProductExchangeDeleteStatus/{itemId}")
    public CommonResult updateProductExchangeDeleteStatus(@PathVariable Integer itemId,@RequestParam Integer deleteStatus){
        int count=pmsProductExchangeService.updateProductExchangeDeleteStatus( itemId, deleteStatus );
        return new CommonResult().success( count );
    }

    @ApiOperation( "根据产品id修改对应的兑换商品信息" )
    @PostMapping("/updateProductExchange/{itemId}")
    public CommonResult updateProductExchange(@PathVariable Integer itemId,
                                              @Validated @RequestBody PmsProductExchangeParams pmsProductExchangeParams, BindingResult bindingResult){
        int count=pmsProductExchangeService.updateProductExchange( itemId, pmsProductExchangeParams );
        return new CommonResult().success( count );
    }

    @ApiOperation( "查询兑换商品列表" )
    @GetMapping("/listProductExchange")
    public CommonResult listProductExchange(){
        PmsProductExchangeResult pmsProductExchangeResult=pmsProductExchangeService.listProductExchange();
        return new CommonResult().success( pmsProductExchangeResult );
    }


}
