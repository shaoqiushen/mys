package com.shanyuan.bgbirdadmin.dto;

import com.shanyuan.model.PmsProduct;
import com.shanyuan.model.PmsProductAttributeValue;
import com.shanyuan.model.PmsSkuStock;
import lombok.Data;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-22 15:41
 * <p>
 * desc 创建修改商品的入参
 **/
@Data
public class PmsProductParams extends PmsProduct {
    /*sku库存信息*/
    List<PmsSkuStock> skuStockList;
    /*自定义属性参数规格*/
    List<PmsProductAttributeValue> productAttributeValueList;
}
