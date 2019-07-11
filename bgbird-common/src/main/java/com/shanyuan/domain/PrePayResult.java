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
public class PrePayResult {
    private Long orderId;
    private PayWechat data;
    private int status;
    private String msg;
}
