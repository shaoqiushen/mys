package com.shanyuan.bgbirdportal.dto;

import com.shanyuan.model.OmsOrder;
import lombok.Data;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-08 14:51
 * <p>
 * desc
 **/
@Data
public class PortalOrderDetailResult {
    private Integer id;
    private List<PortalOrderDetailInfo> orderDetailInfoList;
    private List<PortalOrderAddressResult> addressList;
    private List<OmsOrder> orderList;
}
