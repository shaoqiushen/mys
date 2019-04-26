package com.shanyuan.bgbirdadmin.dto;

import com.shanyuan.validator.FlagValidator;
import com.shanyuan.validator.LengthValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-26 15:03
 * <p>
 * desc
 **/
@Data
@ApiModel
public class UmsAdminParams {
    @ApiModelProperty(value="账号",required=true)
    @NotEmpty(message="账号不允许为空")
    @LengthValidator(value=15,message="账号不允许超过15位")
    private String account;
    @ApiModelProperty(value="密码",required=true)
    @LengthValidator(value=18,message="密码不允许超过18位")
    private String password;
    @ApiModelProperty("备注")
    private String note;
    @ApiModelProperty("启用状态:0->否,1—>是")
    @FlagValidator(value={"0","1"},message="启用状态只能是0或1")
    private Integer accountStatus;
}
