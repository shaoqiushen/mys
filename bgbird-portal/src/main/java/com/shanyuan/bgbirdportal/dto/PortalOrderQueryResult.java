package com.shanyuan.bgbirdportal.dto;

import com.shanyuan.model.OmsOrderDetail;
import lombok.Data;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-06 15:48
 * <p>
 * desc
 **/
@Data
public class PortalOrderQueryResult {
    private Integer id;
    private Long orderId;
    private String createTime;
    private Integer totalAmount;
    private Integer payAmount;
    private List<OmsOrderDetail> orderDetailList;
}
