package com.shanyuan.bgbirdportal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-30 10:30
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PortalCartParams {
    @ApiModelProperty(value="商品id",required=true)
    private Integer productId;
    @ApiModelProperty(value="用户id",required=true)
    @NotEmpty(message="用户id不允许为空")
    private String userId;
    @ApiModelProperty(value="购物满数量",required=true)
    @Min( value=1,message="购买数量必须大于0" )
    private Integer buyCount;
    @ApiModelProperty("销售属性1")
    private String sp1;
    @ApiModelProperty("销售属性2")
    private String sp2;
    @ApiModelProperty("销售属性3")
    private String sp3;
}
