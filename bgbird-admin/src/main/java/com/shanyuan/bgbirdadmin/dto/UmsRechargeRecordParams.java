package com.shanyuan.bgbirdadmin.dto;

import com.shanyuan.validator.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-26 17:23
 * <p>
 * desc
 **/
@Data
@ApiModel
public class UmsRechargeRecordParams {

    @ApiModelProperty("金额变动类型:0->消费,1->充值")
    @FlagValidator(value={"0","1"},message="金额变动类型只允许输入0或1")
    private Integer changeType;
    @ApiModelProperty("用户昵称")
    private String nickname;
    @ApiModelProperty("开始时间")
    private String beginTime;
    @ApiModelProperty("结束时间")
    private String endTime;
}
