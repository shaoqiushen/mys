package com.shanyuan.bgbirdportal.service;

import com.shanyuan.bgbirdportal.dto.PortalProductSkuInfo;
import com.shanyuan.model.OmsCart;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-07 10:56
 * <p>
 * desc
 **/
public interface PromotionService {
    List <PortalProductSkuInfo> calcCartPromotion(List<OmsCart> omsCarts);
}
