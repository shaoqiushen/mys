package com.shanyuan.bgbirdportal.dto;

import com.shanyuan.validator.FlagValidator;
import com.shanyuan.validator.LengthValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-25 15:44
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PortalUserAddressParams {
    @ApiModelProperty(value="用户id",required=true)
    @NotEmpty(message="用户id不允许为空")
    private String userId;
    @ApiModelProperty(value="联系人名称",required=true)
    @NotEmpty(message="联系人名称不允许为空")
    private String receiverName;
    @ApiModelProperty(value="联系电话",required=true)
    @NotEmpty(message="联系电话不允许为空")
    @LengthValidator(value=11,message="联系电话不允许超过11位")
    private String receiverPhone;
    @ApiModelProperty(value="所在区域",required=true)
    @NotEmpty(message="所在区域不允许为空")
    private String addressArea;
    @ApiModelProperty(value="详细地址",required=true)
    private String addressDetail;
    @ApiModelProperty(value="默认地址:0->否，1->是；默认为0")
    @FlagValidator(value={"0","1"},message="默认状态只能允许0或1")
    private Integer defaultStatus=0;
}
