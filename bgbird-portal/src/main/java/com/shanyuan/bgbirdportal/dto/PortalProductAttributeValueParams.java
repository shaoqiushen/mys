package com.shanyuan.bgbirdportal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-29 14:29
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PortalProductAttributeValueParams {
    @ApiModelProperty("销售属性1")
    private String sp1;
    @ApiModelProperty("销售属性2")
    private String sp2;
    @ApiModelProperty("销售属性3")
    private String sp3;
}
