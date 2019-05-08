package com.shanyuan.bgbirdportal.service;

import com.shanyuan.bgbirdportal.dto.PortalOrderDetailResult;
import com.shanyuan.bgbirdportal.dto.PortalOrderParams;
import com.shanyuan.bgbirdportal.dto.PortalOrderQueryResult;
import com.shanyuan.bgbirdportal.dto.PortalOrderQueryParams;
import com.shanyuan.domain.CommonResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-30 9:39
 * <p>
 * desc
 **/
public interface PortalOrderService {
//    @Transactional
//    CommonResult createOrder(PortalOrderParams portalOrderParams);
    @Transactional
    CommonResult createOrderByCart(PortalOrderParams portalOrderParams);
    List<PortalOrderQueryResult> listOrderInfoByParams(PortalOrderQueryParams portalOrderQueryParams,Integer pageNum,Integer pageSize);
    /*修改订单删除状态*/
    int updateOrderDeleteStatus(Integer id,Integer deleteStatus);
    /*根据订单id查询订单详情*/
    PortalOrderDetailResult findOrderInfoById(Long orderId);

}
