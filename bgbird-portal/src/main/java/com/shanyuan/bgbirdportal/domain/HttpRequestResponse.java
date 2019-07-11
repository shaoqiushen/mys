package com.shanyuan.bgbirdportal.domain;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-07-10 10:41
 * <p>
 * desc
 **/
@Data
public class HttpRequestResponse<T> {
    private int status;
    private String code;
    private String msg;
    private T data;
}
