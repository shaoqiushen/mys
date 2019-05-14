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
 * create 2019-05-09 9:25
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PortalActiveCommentParams {
    @ApiModelProperty(value="用户id",required=true)
    @NotEmpty(message="用户id不允许为空")
    private String userId;
    @ApiModelProperty("用户昵称")
    private String nickname;
    @ApiModelProperty("用户头像")
    private String avartalUrl;
    @ApiModelProperty(value="活动id",required=true)
    private Integer activeId;
    @ApiModelProperty(value="评价内容",required=true)
    @NotEmpty(message="请输入评价内容")
    private String commentContent;
    @ApiModelProperty("评价图片，多个以逗号分隔")
    private String commentPicture;
    @ApiModelProperty(value="评价星级",required=true)
    @Min( value=1,message="最小1颗星" )
    @Max( value=5,message="最大5颗星" )
    private Integer commentStar;
}
