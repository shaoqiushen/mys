package com.shanyuan.bgbirdadmin.dto;

import com.shanyuan.validator.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-09 16:00
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PmsProductExchangeParams {
    @ApiModelProperty(value="商品/卡券id",required=true)
    private Integer itemId;
    @ApiModelProperty(value="兑换方式:0->纯积分兑换,1->钱+积分",required=true)
    @FlagValidator(value={"0","1"},message="兑换方式只允许输入0或1")
    private Integer exchangeType;
    @ApiModelProperty("所需积分")
    private Integer points;
    @ApiModelProperty("所需金钱,单位分")
    private Integer cash;
    @ApiModelProperty("上架状态：0->下架；1->上架")
    private Integer publishStatus;
    @ApiModelProperty(value="产品名称",required=true)
    @NotEmpty(message="产品名称不允许为空")
    private String itemName;
    @ApiModelProperty(value="爆款推荐:0->否,1->是",required=true)
    @FlagValidator(value={"0","1"},message="爆款状态只允许输入0或1")
    private Integer boomType;
    @ApiModelProperty("产品图片")
    private String itemPicture;
    @ApiModelProperty("产品介绍")
    private String itemIntroduce;
    @ApiModelProperty("产品参数")
    private String itemParams;
}
