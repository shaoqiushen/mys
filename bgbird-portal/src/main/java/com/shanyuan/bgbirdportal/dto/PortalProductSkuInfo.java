package com.shanyuan.bgbirdportal.dto;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-08 9:09
 * <p>
 * desc
 **/
@Data
public class PortalProductSkuInfo {
    private Integer productId;
    private String productName;
    private Integer promotionType;
    private Integer giftPoint;
    private Integer skuId;
    private Integer price;
    private Long skuCode;
    private Integer promotionPrice;
    private Integer stock;
    private Integer lockStock;
    private String picture;
    private String sp1;
    private String sp2;
    private String sp3;
}
