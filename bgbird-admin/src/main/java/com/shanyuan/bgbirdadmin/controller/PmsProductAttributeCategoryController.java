package com.shanyuan.bgbirdadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdadmin.service.PmsProductAttributeCategoryService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.PmsProductAttributeCategory;
import com.shanyuan.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 11:42
 * <p>
 * desc
 **/
@RestController
@RequestMapping("/productAttribute/category")
@Api(value="PmsProductAttributeCategoryController",description="产品属性分类管理")
public class PmsProductAttributeCategoryController {

    @Autowired
    PmsProductAttributeCategoryService pmsProductAttributeCategoryService;

    @ApiOperation( "创建产品属性分类" )
    @PostMapping("/createProductAttributeCategory")
    @ApiImplicitParam(name="name",value="产品属性分类名称",required=true)
    public CommonResult createProductAttributeCategory(@RequestParam String name){
        int count=pmsProductAttributeCategoryService.createProductAttributeCategory( name );
        return ResultUtil.result( count );
    }

    @ApiOperation( "修改产品属性分类" )
    @PostMapping("updateProductAttributeCategory/{id}")

    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="产品属性分类id",required=true),
            @ApiImplicitParam(name="name",value="产品属性分类名称",required=true)
    })
    public CommonResult updateProductAttributeCategory(@PathVariable Integer id,
                                                       @RequestParam  String name){
        int count=pmsProductAttributeCategoryService.updateProductAttributeCategory( id, name );
        return ResultUtil.result( count );
    }

    @ApiOperation( "分页查询所有产品属性分类列表" )
    @GetMapping("/listProductAttributeCategory")
    public CommonResult listProductAttributeCategory(@RequestParam(defaultValue="1") Integer pageNum,
                                                     @RequestParam(defaultValue="10") Integer pageSize){
        List <PmsProductAttributeCategory> pmsProductAttributeCategories=pmsProductAttributeCategoryService.listProductAttributeCategory( pageNum, pageSize );
        PageInfo<PmsProductAttributeCategory> pmsProductAttributeCategoryPageInfo = new PageInfo <>( pmsProductAttributeCategories );
        return new CommonResult().pageSuccess( pmsProductAttributeCategoryPageInfo );
    }

    @ApiOperation( "删除单个产品属性分类" )
    @GetMapping("/deleteProductAttributeCategory/{id}")
    @ApiImplicitParam(name="id",value="产品属性分类id",required=true)
    public CommonResult deleteProductAttributeCategory(@PathVariable Integer id){
        int count=pmsProductAttributeCategoryService.deleteProductAttributeCategory( id );
        return ResultUtil.result( count );
    }
}
