package com.shanyuan.bgbirdportal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-09 8:56
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PortalCommentParams {
    @ApiModelProperty(value="用户id",required=true)
    @NotEmpty(message="用户id不允许为空")
    private String userId;
    @ApiModelProperty("用户昵称")
    private String nickname;
    @ApiModelProperty("用户头像")
    private String avartalUrl;
    @ApiModelProperty("订单Id")
    private Long orderId;
    @ApiModelProperty("订单评价状态,0否,1是")
    private Integer commentStatus;
    @ApiModelProperty("商品评价集合")
    private List<CommentDto> commentList;

}
