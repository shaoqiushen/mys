package com.shanyuan.bgbirdadmin.dto;

import com.shanyuan.model.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-22 15:41
 * <p>
 * desc 创建修改商品的入参
 **/
@Data
@ApiModel
public class PmsProductParams extends PmsProduct {

    @ApiModelProperty("会员价格信息")
    List<PmsProductMemberPrice> memberPriceList;
    @ApiModelProperty("满减价格信息")
    List<PmsProductFullReduction> fullReductionList;
    @ApiModelProperty("商品的sku库存信息")
    @NotEmpty(message="库存信息允许为空")
    List<PmsSkuStock> skuStockList;
    @ApiModelProperty("商品参数及自定义规格属性")
    List<PmsProductAttributeValue> productAttributeValueList;
}
