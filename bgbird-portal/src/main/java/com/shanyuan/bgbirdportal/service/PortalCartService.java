package com.shanyuan.bgbirdportal.service;

import com.shanyuan.bgbirdportal.dto.PortalCartParams;
import com.shanyuan.bgbirdportal.dto.PortalCartResult;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-30 10:12
 * <p>
 * desc
 **/
public interface PortalCartService {
    /*创建购物车*/
    int createCart(PortalCartParams portalCartParams);
    /*修改购物车删除状态*/
    int updateCartDeleteStatus(Integer id);
    /*修改购物车购买数量*/
    int updateCartBuyCount(Integer id,Integer buyCount);
    /*查询购物车*/
    List<PortalCartResult> listCartByUserId(String userId,Integer pageNum,Integer pageSize);
}
