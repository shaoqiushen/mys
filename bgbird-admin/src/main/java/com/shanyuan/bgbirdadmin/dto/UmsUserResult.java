package com.shanyuan.bgbirdadmin.dto;

import lombok.Data;

import java.util.Date;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-24 8:48
 * <p>
 * desc
 **/
@Data
public class UmsUserResult {
    private String avatarUrl;
    private String nickname;
    private String birthday;
    private String tellPhone;
    //账号启用状态0否,1是
    private Integer actStatus;
    //0-普通用户 1会员
    private Integer userStatus;
    private String userId;
    //账户余额，单位分
    private int moneyOver;
    //注册时间
    private Date registTime;
    //会员等级
    private String levelName;

    /**
     * 会员卡id
     *
     * @mbggenerated
     */
    private String cardId;


    /**
     * 积分
     *
     * @mbggenerated
     */
    private int integration;

}
