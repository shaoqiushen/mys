package com.shanyuan.bgbirdadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdadmin.dto.PmsProductParams;
import com.shanyuan.bgbirdadmin.dto.PmsProductQueryParams;
import com.shanyuan.bgbirdadmin.dto.PmsProductResult;
import com.shanyuan.bgbirdadmin.service.PmsProductService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.PmsProduct;
import com.shanyuan.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-22 15:29
 * <p>
 * desc
 **/
@RestController
@Api(tags="PmsProductController",description="商品管理")
@Slf4j
@RequestMapping("/product")

public class PmsProductController {

    @Autowired
    PmsProductService pmsProductService;

    @ApiOperation( value="创建商品" )
    @PostMapping("/createProduct")
    public CommonResult createProduct(@Validated @RequestBody PmsProductParams pmsProductParams, BindingResult bindingResult){

        int count=pmsProductService.createProduct( pmsProductParams );
        return ResultUtil.result( count );
    }

    @ApiOperation( "分页查询商品列表" )
    @PostMapping("/listProduct")
    public CommonResult listProduct(@RequestBody PmsProductQueryParams pmsProductQueryParams,
                                    @RequestParam(defaultValue="1")Integer pageNum,
                                    @RequestParam(defaultValue="10")Integer pageSize){
        List <PmsProduct> pmsProducts=pmsProductService.listProduct( pmsProductQueryParams, pageNum, pageSize );
        PageInfo<PmsProduct> pmsProductPageInfo = new PageInfo <>( pmsProducts );
        return new CommonResult().pageSuccess( pmsProductPageInfo );
    }

    @ApiOperation( "修改商品删除标志状态,支持批量" )
    @PostMapping("/updateDeleteStatus")
    public CommonResult updateProductDeleteStatus(@RequestParam("ids")List<Integer> ids,@RequestParam("deleteStatus") Integer deleteStatus){
        int count=pmsProductService.updateProductDeleteStatus( ids, deleteStatus );
        return ResultUtil.result( count );
    }

    @ApiOperation( "根据商品id获取商品编辑信息" )
    @GetMapping("/getUpdateProductInfoById/{id}")
    public CommonResult getUpdateProductInfoById(@PathVariable Integer id){
        PmsProductResult updateProductInfoById=pmsProductService.getUpdateProductInfoById( id );
        return new CommonResult().success( updateProductInfoById );
    }

    @ApiOperation( "根据商品id修改商品信息" )
    @PostMapping("/updateProductById/{id}")
    public CommonResult updateProductById(@PathVariable Integer id,@RequestBody PmsProductParams pmsProductParams,BindingResult bindingResult){
        int count=pmsProductService.updateProductById( id, pmsProductParams );
        return ResultUtil.result( count );
    }

    @ApiOperation( "批量上下架" )
    @PostMapping("/updatePublishStatues")
    public CommonResult updatePublishStatues(@RequestParam("ids")List<Integer>ids,@RequestParam Integer publishStatus){
        int count=pmsProductService.updatePublishStatues( ids, publishStatus );
        return ResultUtil.result( count );
    }
}
