package com.shanyuan.bgbirdadmin.dao;

import com.shanyuan.bgbirdadmin.dto.OmsOrderQueryParams;
import com.shanyuan.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 17:43
 * <p>
 * desc
 **/
public interface OmsOrderDao {
    /*条件查询订单列表*/
    List<OmsOrder> listOrderInfo(@Param( "omsOrderQueryParams" ) OmsOrderQueryParams omsOrderQueryParams);
}
