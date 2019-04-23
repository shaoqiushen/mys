package com.shanyuan.bgbirdadmin.dto;

import com.shanyuan.validator.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 9:00
 * <p>
 * desc 添加更新产品分类入参
 **/
@Data
@ApiModel
public class PmsProductCategoryParams {
    @ApiModelProperty(value = "商品分类名称",required = true)
    @NotEmpty(message = "商品分类名称不能为空")
    private String categoryName;
    @ApiModelProperty("排序,值越小越靠前")
    @Min(value = 1,message = "排序最小值为1")
    private Integer sort;
    @ApiModelProperty("是否显示,0否1是")
    @FlagValidator(value={"0","1"},message="显示状态只能为0或者1")
    private Integer showStatus;
    private String description;
}
