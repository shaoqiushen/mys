package com.shanyuan.domain;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-28 15:40
 * <p>
 * desc
 **/
@Data
public class PayWechat {
    private String timeStamp;
    private String Package;
    private String paySign;
    private String appId;
    private String signType;
    private String nonceStr;
}
