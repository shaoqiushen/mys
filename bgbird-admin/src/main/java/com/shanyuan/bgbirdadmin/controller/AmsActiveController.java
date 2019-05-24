package com.shanyuan.bgbirdadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdadmin.dto.AmsActiveParams;
import com.shanyuan.bgbirdadmin.dto.AmsActiveResult;
import com.shanyuan.bgbirdadmin.service.AmsActiveService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.AmsActive;
import com.shanyuan.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-24 8:55
 * <p>
 * desc
 **/
@RequestMapping("/active")
@RestController
@Api(value="AmsActiveController",description="活动管理")
public class AmsActiveController {

    @Autowired
    AmsActiveService amsActiveService;

    @PostMapping("/createActive")
    @ApiOperation("创建活动")
    public CommonResult createActive(@Validated @RequestBody AmsActiveParams amsActiveParams, BindingResult bindingResult){
        int count=amsActiveService.createActive( amsActiveParams );
        return ResultUtil.result( count );
    }

    @PostMapping("/updateActive/{id}")
    @ApiOperation( "修改活动" )
    @ApiImplicitParam(name="id",value="活动id",required=true)
    public CommonResult updateActive(@PathVariable Integer id, @Validated @RequestBody AmsActiveParams amsActiveParams, BindingResult bindingResult){
        int count=amsActiveService.updateActive( id, amsActiveParams );
        return ResultUtil.result( count );
    }

    @DeleteMapping("/deleActive/{id}")
    @ApiOperation( "删除活动" )
    @ApiImplicitParam(name="id",value="活动id",required=true)
    public CommonResult deleteActive(@PathVariable Integer id){
        int count=amsActiveService.deleteActive( id );
        return ResultUtil.result( count );
    }

    @PostMapping("/listActiveInfo")
    @ApiOperation( "分页查询活动列表" )
    public CommonResult listActiveInfo(@RequestParam(defaultValue="1")Integer pageNum,
                                       @RequestParam(defaultValue="10")Integer pageSize,
                                       @RequestParam(defaultValue="") String startTime1,
                                       @RequestParam(defaultValue="") String startTime2){
        List <AmsActiveResult> amsActiveResults=amsActiveService.listAmsActiveInfo(pageNum,pageSize,startTime1,startTime2);
        PageInfo<AmsActiveResult> pageInfo = new PageInfo <>( amsActiveResults );
        return new CommonResult().pageSuccess( pageInfo );
    }

    @GetMapping("/getActiveInfoById/{id}")
    @ApiOperation( "查询活动详情" )
    public CommonResult getActiveInfoById(@PathVariable Integer id){
        AmsActive activeInfoById=amsActiveService.getActiveInfoById( id );
        return new CommonResult().success( activeInfoById );
    }



}
