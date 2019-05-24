package com.shanyuan.bgbirdadmin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 18:50
 * <p>
 * desc
 **/
@Data
@ApiModel
public class UmsUserParams {
    @ApiModelProperty(value="微信昵称")
    private String nickname;
}
