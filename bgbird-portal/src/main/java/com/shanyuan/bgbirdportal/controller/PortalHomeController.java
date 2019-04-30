package com.shanyuan.bgbirdportal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdportal.dto.*;
import com.shanyuan.bgbirdportal.service.HomeService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.PmsProduct;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-25 9:04
 * <p>
 * desc
 **/
@RequestMapping("/home")
@Api(value="PortalHomeController",description="首页内容管理")
@RestController
public class PortalHomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/homeContent")
    @ApiOperation( "获取首页展示内容" )
    public CommonResult homeContent(){
        HomeContentResult homeContentResult=homeService.homeContent();
        return new CommonResult().success( homeContentResult );
    }

    @ApiOperation("根据分类id获取相应的商品列表")
    @GetMapping("/listProductByCategoryId/{categoryId}")
    public CommonResult listProductByCategoryId(@PathVariable Integer categoryId,
                                                @RequestParam(defaultValue="1")Integer pageNum,
                                                @RequestParam(defaultValue="10")Integer pageSize){
        List <PmsProduct> pmsProducts=homeService.listProductByCategoryId( pageNum, pageSize, categoryId );
        PageInfo<PmsProduct> pmsProductPageInfo = new PageInfo <>( pmsProducts );
        return new CommonResult().pageSuccess( pmsProductPageInfo );
    }

    @GetMapping( "/findProductDetail/{productId}" )
    @ApiOperation( "根据商品id查询商品详情" )
    public CommonResult findProductDetail(@PathVariable Integer productId){
        PortalProductDetailResult productDetail=homeService.findProductDetail( productId );
        return new CommonResult().success( productDetail );
    }

    @GetMapping("/getAttributeParamsByProductId/{productId}")
    @ApiOperation( "根据商品id查询规格信息" )
    public CommonResult getAttributeParamsByProductId(@PathVariable Integer productId){
        List <PortalProductAttirbuteParamsResult> productSpecByProductId=homeService.getAttributeParamsByProductId( productId,0 );
        return new CommonResult().success( productSpecByProductId );
    }

    @ApiOperation( "根据商品id,规格信息查询商品的价格" )
    @PostMapping("/getProductPriceByAttribute/{productId}")
    public CommonResult getProductPriceByAttribute(@PathVariable Integer productId,@RequestBody PortalProductAttributeValueParams portalProductAttributeValueParams){
        List <PortalProductPriceStockResult> productPriceByAttribute=homeService.getProductPriceByAttribute( productId, portalProductAttributeValueParams );
        return new CommonResult().success( productPriceByAttribute );
    }

}
