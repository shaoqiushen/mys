package com.shanyuan.bgbirdportal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdportal.dto.PortalActiveCommentParams;
import com.shanyuan.bgbirdportal.service.PortalActiveService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.AmsActive;
import com.shanyuan.model.AmsActiveComment;
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
 * create 2019-05-07 18:17
 * <p>
 * desc
 **/
@Api(value="PortalActiveController",description="活动管理")
@RestController
@RequestMapping("/active")
public class PortalActiveController {

    @Autowired
    PortalActiveService portalActiveService;

    @ApiOperation( "查询活动信息" )
    @GetMapping("/listActive")
    public CommonResult listActive(){
        List <AmsActive> amsActives=portalActiveService.listActive();
        PageInfo<AmsActive> pageInfo = new PageInfo <>( amsActives );
        return new CommonResult().pageSuccess( pageInfo );
    }

    @ApiOperation( "根据活动id查询活动详情" )
    @GetMapping("/findActiveById/{id}")
    public CommonResult findActiveById(@PathVariable Integer id){
        AmsActive activeById=portalActiveService.findActiveById( id );
        return new CommonResult().success( activeById );
    }

    @ApiOperation( "添加活动评价" )
    @PostMapping("/createActiveComment")
    public CommonResult createActiveComment(@Validated @RequestBody PortalActiveCommentParams portalActiveCommentParams, BindingResult bindingResult){
        return portalActiveService.createActiveComment( portalActiveCommentParams );
    }

    @ApiOperation( "根据活动id查询活动评价" )
    @GetMapping("/getActiveCommentById/{activeId}")
    public CommonResult getActiveCommentById(@PathVariable Integer activeId){
        List <AmsActiveComment> activeCommentById=portalActiveService.getActiveCommentById( activeId );
        PageInfo<AmsActiveComment> pageInfo = new PageInfo <>( activeCommentById );
        return new CommonResult().pageSuccess( pageInfo );
    }
}
