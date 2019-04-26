package com.shanyuan.bgbirdadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.bgbirdadmin.dto.UmsRechargeRecordParams;
import com.shanyuan.bgbirdadmin.service.UmsUserRechargeService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.UmsUserRechargeRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-24 16:28
 * <p>
 * desc
 **/
@Api(value="UmsUserRechargeController",description="用户资金管理")
@RestController
@RequestMapping("/user/recharge")
public class UmsUserRechargeController {

    @Autowired
    UmsUserRechargeService umsUserRechargeService;

    @ApiOperation( "分页条件查询用户的充值/消费明细列表" )
    @PostMapping("/listUserRechargeRecord")
    public CommonResult listUserRechargeRecord(@Validated @RequestBody UmsRechargeRecordParams umsRechargeRecordParams, BindingResult bindingResult){
        List <UmsUserRechargeRecord> umsUserRechargeRecords=umsUserRechargeService.listUserRechargeRecord(umsRechargeRecordParams);
        PageInfo<UmsUserRechargeRecord> pageInfo = new PageInfo <>( umsUserRechargeRecords );
        return new CommonResult().pageSuccess( pageInfo );
    }
}
