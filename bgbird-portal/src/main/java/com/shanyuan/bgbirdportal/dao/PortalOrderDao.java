package com.shanyuan.bgbirdportal.dao;

import com.shanyuan.bgbirdportal.dto.PortalOrderDetailResult;
import com.shanyuan.bgbirdportal.dto.PortalOrderQueryResult;
import com.shanyuan.bgbirdportal.dto.PortalOrderQueryParams;
import com.shanyuan.model.OmsOrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-06 15:55
 * <p>
 * desc
 **/
public interface PortalOrderDao {
    List<PortalOrderQueryResult> listOrderInfoByParams(@Param( "portalOrderQueryParams" ) PortalOrderQueryParams portalOrderQueryParams,
                                                       @Param( "startNum" ) int startNum,@Param( "endNum" ) int endNum);
    int countOrder(@Param( "portalOrderQueryParams" ) PortalOrderQueryParams portalOrderQueryParams);
    int insertOrderDetail(@Param( "omsOrderDetails" )List<OmsOrderDetail> omsOrderDetails);
    PortalOrderDetailResult findOrderInfoById(@Param( "orderId" ) Long orderId);
}
