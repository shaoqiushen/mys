package com.shanyuan.bgbirdadmin.dto;

import com.shanyuan.validator.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 14:34
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PmsProductAttributeParams {
    @ApiModelProperty("关联的产品属性分类id")
    @NotNull(message="产品属性分类id不能为空")
    private Integer attrCategoryId;
    @ApiModelProperty(value="属性名称",required=true)
    @NotEmpty(message="产品属性分类名称不能为空")
    private String name;
    @ApiModelProperty("可选值列表，以逗号隔开")
    private String inputList;
    @ApiModelProperty(value="排序",required=true)
    @Min( value=1 ,message="排序最小值为1")
    private Integer sort;
    @ApiModelProperty(value="属性的类型；0->规格；1->参数",required=true)
    @FlagValidator(value={"0","1"},message="属性类型只能为0或1")
    private Integer attrType;

}
