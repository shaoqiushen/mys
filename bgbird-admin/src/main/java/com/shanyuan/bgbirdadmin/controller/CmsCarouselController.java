package com.shanyuan.bgbirdadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdadmin.dto.CmsCarouselParams;
import com.shanyuan.bgbirdadmin.service.CmsCarouselService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.CmsCarousel;
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
 * create 2019-05-17 10:24
 * <p>
 * desc
 **/
@Api("轮播图管理")
@RestController
@RequestMapping("/carousel")
public class CmsCarouselController {

    @Autowired
    CmsCarouselService cmsCarouselService;


    @ApiOperation( "创建轮播图" )
    @PostMapping("/createCarousel")
    public CommonResult createCarousel(@Validated @RequestBody CmsCarouselParams cmsCarouselParams, BindingResult bindingResult){
        int count=cmsCarouselService.createCarousel( cmsCarouselParams );
        return ResultUtil.result( count );
    }

    @ApiOperation( "设置轮播图删除状态" )
    @PostMapping("/updateCarouselDeleteStatus/{id}")
    public CommonResult updateCarouselDeleteStatus(@PathVariable Integer id,@RequestParam Integer deleteStatus){
        int count=cmsCarouselService.updateCarouselDeleteStatus( id, deleteStatus );
        return ResultUtil.result( count );
    }

    @ApiOperation( "查询轮播图列表" )
    @GetMapping("/listCarousel")
    public CommonResult listCarousel(){
        List <CmsCarousel> cmsCarousels=cmsCarouselService.listCarousel();
        PageInfo<CmsCarousel> pageInfo = new PageInfo <>( cmsCarousels );
        return new CommonResult().pageSuccess( pageInfo );
    }

    @ApiOperation( "修改轮播图" )
    @PostMapping("/updateCarousel/{id}")
    public CommonResult updateCarousel(@Validated @RequestBody CmsCarouselParams cmsCarouselParams,@PathVariable Integer id){
        int count=cmsCarouselService.updateCarousel( cmsCarouselParams, id );
        return ResultUtil.result( count );
    }

}
