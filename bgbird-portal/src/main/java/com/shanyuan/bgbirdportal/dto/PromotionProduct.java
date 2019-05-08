package com.shanyuan.bgbirdportal.dto;

import com.shanyuan.model.PmsProduct;
import com.shanyuan.model.PmsProductFullReduction;
import com.shanyuan.model.PmsSkuStock;
import lombok.Data;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-07 11:11
 * <p>
 * desc      商品的促销信息
 **/
@Data
public class PromotionProduct extends PmsProduct {
    //商品库存信息
    private List<PmsSkuStock> skuStockList;
    //商品满减信息
    private List<PmsProductFullReduction> productFullReductionList;
}
