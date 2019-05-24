package com.shanyuan.bgbirdadmin.dto;

import com.shanyuan.validator.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-17 10:27
 * <p>
 * desc
 **/
@Data
@ApiModel
public class CmsCarouselParams {
    @ApiModelProperty(value="轮播图片",required=true)
    @NotEmpty
    private String picture;
    @ApiModelProperty("商品id")
    private Integer productId;
    @ApiModelProperty(value="轮播顺序,值越小越靠前",required=true)
    @Min( value=1,message="请输入大于0的数值" )
    private Integer sort;
    @ApiModelProperty("外链地址")
    private String url;
    @ApiModelProperty(value="0->App首页，1->PC首页",required=true)
    @FlagValidator(value={"0","1"},message="请输入0或者1")
    private Integer type;
    @ApiModelProperty(value="上线状态:0->下线,1->上线",required=true)
    @FlagValidator(value={"0","1"},message="请输入0或者1")
    private Integer status;
    @ApiModelProperty(value="是否商品:0->商品;1->外链",required=true)
    @FlagValidator(value={"0","1"},message="请输入0或者1")
    private Integer isGoods;
}
