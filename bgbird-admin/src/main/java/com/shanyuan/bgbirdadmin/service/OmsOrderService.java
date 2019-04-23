package com.shanyuan.bgbirdadmin.service;

import com.shanyuan.bgbirdadmin.dto.OmsOrderQueryParams;
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
    List<OmsOrder> listOrderInfo(OmsOrderQueryParams omsOrderQueryParams,Integer pageNum,Integer pageSize);
}
