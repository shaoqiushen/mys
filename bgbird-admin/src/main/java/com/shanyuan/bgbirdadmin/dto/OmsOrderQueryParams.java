package com.shanyuan.bgbirdadmin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 17:22
 * <p>
 * desc
 **/
@Data
@ApiModel
public class OmsOrderQueryParams {
    @ApiModelProperty(value="订单编号")
    private BigInteger orderId;
    @ApiModelProperty(value="用户昵称")
    private String nickName;
    @ApiModelProperty(value="订单提交时间")
    private String createTime;
    @ApiModelProperty(value="订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
    private Integer orderStatus;
}
