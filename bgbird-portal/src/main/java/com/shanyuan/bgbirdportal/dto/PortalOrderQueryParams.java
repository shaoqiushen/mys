package com.shanyuan.bgbirdportal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-06 15:41
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PortalOrderQueryParams {
    @ApiModelProperty(value="用户id",required=true)
    @NotEmpty(message="用户id不允许为空")
    private String userId;
    @ApiModelProperty(value="订单状态：0->待付款；1->已支付，待发货；2->已发货；3->已完成；4->已关闭；5->无效订单；查询全部则不传")
    private Integer orderStatus;
    @ApiModelProperty("评价状态:0->否,1->是;若查询未评价订单，则务必传入orderStatus=3")
    private Integer commentStatus;

}
