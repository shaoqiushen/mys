package com.shanyuan.bgbirdportal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-13 9:37
 * <p>
 * desc
 **/
@Data
@ApiModel
public class CommentDto {
    @ApiModelProperty(value="商品id",required=true)
    private Integer productId;
    @ApiModelProperty(value="评价内容",required=true)
    @NotEmpty(message="请输入评价内容")
    private String commentContent;
    @ApiModelProperty(value="商品名称",required=true)
    private String productName;
    @ApiModelProperty("评价图片，多个以逗号分隔")
    private String commentPicture;
    @ApiModelProperty(value="评价星级",required=true)
    @Min( value=1,message="最小1颗星" )
    @Max( value=5,message="最大5颗星" )
    private Integer commentStar;

}
