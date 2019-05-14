package com.shanyuan.bgbirdportal.dto;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-08 14:56
 * <p>
 * desc
 **/
@Data
public class PortalOrderDetailInfo {
    private String picture;
    private String productName;
    private Integer productId;
    private String sp1;
    private String sp2;
    private String sp3;
    private Integer buyCount;
    private Integer price;
    private String productPicture;
    private Integer commentStatus;
}
