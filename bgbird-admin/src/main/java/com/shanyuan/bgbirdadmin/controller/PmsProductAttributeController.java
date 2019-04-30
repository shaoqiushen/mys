package com.shanyuan.bgbirdadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdadmin.dto.PmsProductAttributeParams;
import com.shanyuan.bgbirdadmin.service.PmsProductAttributeService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.PmsProductAttribute;
import com.shanyuan.utils.ResultUtil;
import com.shanyuan.validator.FlagValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 14:31
 * <p>
 * desc
 **/
@RestController
@RequestMapping("/productAttribute")
@Api(value="PmsProductAttributeController",description="产品属性管理")

public class PmsProductAttributeController {

    @Autowired
    PmsProductAttributeService pmsProductAttributeService;

    @PostMapping("/createProductAttribute")
    @ApiOperation( "创建产品属性" )
    public CommonResult createProductAttribute(@Validated @RequestBody PmsProductAttributeParams pmsProductAttributeParams, BindingResult bindingResult){

        int count=pmsProductAttributeService.createProductAttribute( pmsProductAttributeParams );
        return ResultUtil.result( count );
    }

    @PostMapping("/updateProductAttribute/{id}")
    @ApiOperation( "修改产品属性" )
    @ApiImplicitParam(name="id",value="产品属性id",required=true)
    public CommonResult updateProductAttribute(@PathVariable Integer id, @Validated @RequestBody PmsProductAttributeParams pmsProductAttributeParams, BindingResult bindingResult){
        int count=pmsProductAttributeService.updateProductAttribute( id, pmsProductAttributeParams );
        return ResultUtil.result( count );
    }

    @PostMapping("/listProductAttribute/{attrCategoryId}")
    @ApiOperation( "根据产品属性分类id查询属性列表或参数列表" )
    @ApiImplicitParams( {
            @ApiImplicitParam(value="产品属性分类id",name="attrCategoryId",required=true),
            @ApiImplicitParam(value="属性=0,参数=1",name="attrType",required=true)
    } )
    public CommonResult listProductAttribute(@PathVariable Integer attrCategoryId,
                                             @RequestParam @FlagValidator Integer attrType,
                                             @RequestParam(defaultValue="1") Integer pageNum,
                                             @RequestParam(defaultValue="10") Integer pageSize){
        List <PmsProductAttribute> pmsProductAttributes=pmsProductAttributeService.listProductAttribute( attrCategoryId, attrType, pageNum, pageSize );
        PageInfo<PmsProductAttribute> pmsProductAttributePageInfo = new PageInfo <>( pmsProductAttributes );
        return new CommonResult().pageSuccess( pmsProductAttributePageInfo );
    }

    @PostMapping("/deleteProductAttribute")
    @ApiOperation( "删除产品属性，支持批量" )
    public CommonResult deleteProductAttribute(@RequestBody List<Integer> ids){
        int count=pmsProductAttributeService.deleteProductAttribute( ids );
        return ResultUtil.result( count );
    }

    @GetMapping("findProductAttributeById/{id}")
    @ApiOperation( "根据产品属性id查询属性信息" )
    @ApiImplicitParam(name="id",value="产品属性id",required=true)
    public CommonResult findProductAttributeById(@PathVariable Integer id){
        PmsProductAttribute productAttributeById=pmsProductAttributeService.findProductAttributeById( id );
        return new CommonResult().success( productAttributeById );
    }
}
