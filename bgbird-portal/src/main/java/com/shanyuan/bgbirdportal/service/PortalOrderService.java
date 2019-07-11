package com.shanyuan.bgbirdportal.service;

import com.shanyuan.bgbirdportal.dto.PortalOrderDetailResult;
import com.shanyuan.bgbirdportal.dto.PortalOrderParams;
import com.shanyuan.bgbirdportal.dto.PortalOrderQueryResult;
import com.shanyuan.bgbirdportal.dto.PortalOrderQueryParams;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.OmsOrder;
import com.shanyuan.model.OmsOrderPrepay;
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
    @Transactional
    CommonResult createOrderByCart(PortalOrderParams portalOrderParams);
    List<PortalOrderQueryResult> listOrderInfoByParams(PortalOrderQueryParams portalOrderQueryParams,Integer pageNum,Integer pageSize);
    /*修改订单删除状态*/
    int updateOrderDeleteStatus(Integer id,Integer deleteStatus);
    /*根据订单id查询订单详情*/
    PortalOrderDetailResult findOrderInfoById(Long orderId);
    /*订单信息*/
    OmsOrder getOrder(Long orderId);
    /*更改订单状态为支付*/
    int updateOrderStatus(Long orderId);
    /*修改预支付信息成功状态*/
    int updatePrePayStatus(String outTradeNo);
    /*再次拉取支付信息*/
    OmsOrderPrepay getPayInfo(String orderId);
}
