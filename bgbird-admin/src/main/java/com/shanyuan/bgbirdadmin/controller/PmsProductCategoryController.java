package com.shanyuan.bgbirdadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdadmin.dto.PmsProductCategoryParams;
import com.shanyuan.bgbirdadmin.service.PmsProductCategoryService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.PmsProductCategory;
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
 * create 2019-04-23 8:48
 * <p>
 * desc
 **/
@RestController
@Slf4j
@RequestMapping("/productCategory")
@Api(value="PmsProductCategoryController",description="产品分类管理")
public class PmsProductCategoryController {

    @Autowired
    PmsProductCategoryService pmsProductCategoryService;

    @ApiOperation( "添加产品分类" )
    @PostMapping("/createProductCategory")
    public CommonResult createProductCategory(@Validated @RequestBody PmsProductCategoryParams pmsProductCategoryParams, BindingResult bindingResult){
        int count = pmsProductCategoryService.createProductCategory( pmsProductCategoryParams );
        return ResultUtil.result( count );
    }

    @PostMapping("/updateProductCategory/{categoryId}")
    @ApiOperation( "修改产品分类" )
    public CommonResult updateProductCategory(
            @PathVariable Integer categoryId,
            @Validated @RequestBody PmsProductCategoryParams pmsProductCategoryParams, BindingResult bindingResult){
        int count = pmsProductCategoryService.updateProductCategory( categoryId,pmsProductCategoryParams );
        return ResultUtil.result( count );
    }

    @GetMapping("/listProductCategory")
    @ApiOperation( "分页查询产品分类列表" )
    public CommonResult listProductCategory(
            @RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
            @RequestParam(value="pageSize",defaultValue="10")Integer pageSize){
        List <PmsProductCategory> pmsProductCategories=pmsProductCategoryService.listProductCategory( pageNum, pageSize );
        PageInfo<PmsProductCategory> pageInfo = new PageInfo <>( pmsProductCategories );
        return new CommonResult().pageSuccess( pageInfo );
    }

    @PostMapping("/deleteProductCategory/{categoryId}")
    @ApiOperation( "删除产品分类" )
    public CommonResult deleteProductCategory(@PathVariable Integer categoryId){
        int count = pmsProductCategoryService.deleteProductCategory( categoryId );
        return ResultUtil.result( count );
    }
}
