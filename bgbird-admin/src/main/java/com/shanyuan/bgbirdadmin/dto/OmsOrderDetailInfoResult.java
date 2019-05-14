package com.shanyuan.bgbirdadmin.dto;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-13 10:52
 * <p>
 * desc
 **/
@Data
public class OmsOrderDetailInfoResult {
    private String sp1;
    private String sp2;
    private String sp3;
    private String productName;
    private Integer price;
    private String productPicture;
    private Integer buyCount;
    private String nickname;
    private Integer productId;
}
