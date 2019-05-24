package com.shanyuan.bgbirdportal.service;

import com.shanyuan.bgbirdportal.dto.*;
import com.shanyuan.model.PmsProduct;
import com.shanyuan.model.PmsSkuStock;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-25 9:09
 * <p>
 * desc
 **/
public interface HomeService {
    /*获取首页展示内容*/
    HomeContentResult homeContent();
    /*根据分类id查询相应商品*/
    List<PmsProduct> listProductByCategoryId(Integer pageNum, Integer pageSize, Integer categoryId);
    /*根据商品id查询商品详情*/
    PortalProductDetailResult findProductDetail(Integer productId);
    /*根据商品id查询参数信息*/
    List<PortalProductAttirbuteParamsResult>getAttributeParamsByProductId(Integer productId,Integer attrType);
    /*查询商品规格*/
    List<PmsSkuStock> getAttributeSpecByProductId(Integer productId);
    /*根据商品id规格获取商品价格*/
    List<PortalProductPriceStockResult> getProductPriceByAttribute(Integer productId,PortalProductAttributeValueParams portalProductAttributeValueParams);
}
