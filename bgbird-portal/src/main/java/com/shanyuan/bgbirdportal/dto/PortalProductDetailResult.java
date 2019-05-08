package com.shanyuan.bgbirdportal.dto;

import com.shanyuan.model.OmsProductComment;
import com.shanyuan.model.PmsProduct;
import com.shanyuan.model.PmsSkuStock;
import lombok.Data;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-25 11:19
 * <p>
 * desc
 **/
@Data
public class PortalProductDetailResult {
    //商品详情
    private List<PmsProduct> productList;
    //商品属性参数
    private List<PortalProductAttirbuteParamsResult> attributeList;
    //商品规格参数
//    List<PortalProductAttributeResult>
    //sku信息
    private List<PmsSkuStock> skuStockList;
    //评论列表
    private List<OmsProductComment> commentList;
}
