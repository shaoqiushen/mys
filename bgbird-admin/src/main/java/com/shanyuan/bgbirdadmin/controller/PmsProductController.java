package com.shanyuan.bgbirdadmin.controller;

import com.shanyuan.bgbirdadmin.dto.PmsProductParams;
import com.shanyuan.bgbirdadmin.service.PmsProductService;
import com.shanyuan.domain.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-22 15:29
 * <p>
 * desc
 **/
@RestController
@Api(tags="PmsProductController",description="商品管理控制器")
@Slf4j
@RequestMapping("/product")
public class PmsProductController {

    @Autowired
    PmsProductService pmsProductService;

    @ApiOperation( value="创建商品" )
    @PostMapping("/createProduct")
    public CommonResult createProduct(@RequestBody PmsProductParams pmsProductParams){

        int count=pmsProductService.createProduct( pmsProductParams );
        if(count >0){
            return new CommonResult().success( count );
        }
        return new CommonResult().failed();
    }
}
