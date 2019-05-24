package com.shanyuan.bgbirdadmin.service;

import com.shanyuan.bgbirdadmin.dto.OmsOrderDetailInfoResult;
import com.shanyuan.bgbirdadmin.dto.OmsOrderQueryParams;
import com.shanyuan.bgbirdadmin.dto.OmsOrderResult;
import com.shanyuan.model.OmsOrder;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 17:36
 * <p>
 * desc
 **/
public interface OmsOrderService {
    List<OmsOrderResult> listOrderInfo(OmsOrderQueryParams omsOrderQueryParams, Integer pageNum, Integer pageSize);
    int updateOrder(OmsOrder omsOrder);
    List<OmsOrderDetailInfoResult> getOrderDetailInfo(Long userId);
}
