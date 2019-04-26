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
 * create 2019-04-24 9:05
 * <p>
 * desc
 **/
@Data
@ApiModel
public class AmsActiveParams {
    @ApiModelProperty(value="活动名称",required=true)
    @NotEmpty(message="活动名称不允许为空")
    private String activeName;
    @ApiModelProperty(value="活动开启时间",required=true,example="2019-04-24 12:12:12")
    @NotEmpty(message="开始时间不允许为空")
    private String beginTime;
    @ApiModelProperty(value="活动简介")
    private String activeIntroduce;
    @ApiModelProperty(value="活动宣传图片")
    private String activePicture;
    @ApiModelProperty(value="活动是否启用:0->否,1->是",required=true,example="1")
    @FlagValidator(value={"0","1"},message="启动标志只能是0或1")
    private Integer isEnable;
    @ApiModelProperty("参与活动获得的积分")
    @Min( value=0,message="积分不允许为负数" )
    private Integer integration;
    @ApiModelProperty(value="活动结束时间",required=true,example="2019-04-28 12:12:12")
    @NotEmpty(message="活动结束时间不允许为空")
    private String endTime;
    @ApiModelProperty(value="活动标题")
    private String activeTitle;
    @ApiModelProperty(value="活动内容->富文本内容",required=true)
    private String activeContent;
}
