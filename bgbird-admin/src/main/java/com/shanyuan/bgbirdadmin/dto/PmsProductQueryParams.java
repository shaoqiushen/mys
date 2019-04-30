package com.shanyuan.bgbirdadmin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-29 15:15
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PmsProductQueryParams {
    @ApiModelProperty("上架状态")
    private Integer publishStatus;
    @ApiModelProperty("商品名称模糊关键字")
    private String keyword;
    @ApiModelProperty("商品分类编号")
    private Integer productCategoryId;

}
