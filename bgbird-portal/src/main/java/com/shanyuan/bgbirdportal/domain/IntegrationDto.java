package com.shanyuan.bgbirdportal.domain;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-07-10 10:42
 * <p>
 * desc 积分回参实体
 **/
@Data
public class IntegrationDto {
    private String errcode;
    private String result_balance;
    private String openid;
    private String errmsg;
    private String result_bonus;
}
