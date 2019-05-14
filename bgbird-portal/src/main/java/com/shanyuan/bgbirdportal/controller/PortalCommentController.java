package com.shanyuan.bgbirdportal.controller;

import com.shanyuan.bgbirdportal.dto.PortalCommentParams;
import com.shanyuan.bgbirdportal.service.PortalCommentService;
import com.shanyuan.domain.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-09 8:46
 * <p>
 * desc
 **/
@Api(value="PortalCommentController",description="评价管理")
@RestController
@RequestMapping("/comment")
public class PortalCommentController {

    @Autowired
    PortalCommentService portalCommentService;

    @ApiOperation( "添加评价" )
    @PostMapping("/createComment")
    public CommonResult createComment(@Validated @RequestBody PortalCommentParams portalCommentParams, BindingResult bindingResult){
        return portalCommentService.createComment( portalCommentParams );
    }
}
