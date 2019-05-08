package com.shanyuan.bgbirdportal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdportal.service.ActiveService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.AmsActive;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    ActiveService activeService;

    @ApiOperation( "查询活动信息" )
    @GetMapping("/listActive")
    public CommonResult listActive(){
        List <AmsActive> amsActives=activeService.listActive();
        PageInfo<AmsActive> pageInfo = new PageInfo <>( amsActives );
        return new CommonResult().pageSuccess( pageInfo );
    }

    @ApiOperation( "根据活动id查询活动详情" )
    @GetMapping("/findActiveById/{id}")
    public CommonResult findActiveById(@PathVariable Integer id){
        AmsActive activeById=activeService.findActiveById( id );
        return new CommonResult().success( activeById );
    }
}
