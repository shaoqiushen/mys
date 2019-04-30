package com.shanyuan.bgbirdportal.dto;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-30 11:03
 * <p>
 * desc
 **/
@Data
public class PortalCartResult {
    private Integer cartId;
    private Integer productId;
    private Integer price;
    private String productName;
    private Integer buyCount;
    private String picture;
    private String sp1;
    private String sp2;
    private String sp3;
}
