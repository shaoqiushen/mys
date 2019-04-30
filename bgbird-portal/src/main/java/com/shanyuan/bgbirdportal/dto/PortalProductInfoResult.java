package com.shanyuan.bgbirdportal.dto;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-30 14:52
 * <p>
 * desc
 **/
@Data
public class PortalProductInfoResult {
    private String productName;
    private String picture;
    private int price;
    private int promotionPrice;
//    private String sp1;
//    private String sp2;
//    private String sp3;
    private Integer stock;
    private Integer skuId;
    private int reducePrice;
    private int fullPrice;
}
