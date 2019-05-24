package com.shanyuan.bgbirdportal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdportal.dto.PortalPointsResult;
import com.shanyuan.bgbirdportal.service.PortalUserPointsService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.UmsUserMember;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-09 17:52
 * <p>
 * desc
 **/
@Api(value="PortalUserPointsController",description="用户积分管理")
@RestController
@RequestMapping("/points")
public class PortalUserPointsController {

    @Autowired
    PortalUserPointsService portalUserPointsService;

    @ApiOperation( "获取用户积分信息" )
    @GetMapping("/getUserPoints")
    public CommonResult getUserPoints(@RequestParam String userId){
        UmsUserMember userPointsInfo=portalUserPointsService.getUserPointsInfo( userId );
        return new CommonResult().success( userPointsInfo );
    }

    @ApiOperation( "根据用户id分页查询积分变动记录" )
    @GetMapping("/getUserPointsRecord")

    public CommonResult getUserPointsRecord(@RequestParam String userId){
        List <PortalPointsResult> userPointsRecord=portalUserPointsService.getUserPointsRecord( userId );
        PageInfo<PortalPointsResult> pointsRecordPageInfo = new PageInfo <>( userPointsRecord );
        return new CommonResult().pageSuccess( pointsRecordPageInfo );
    }
}
