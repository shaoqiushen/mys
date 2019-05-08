package com.shanyuan.bgbirdportal.dao;

import com.shanyuan.bgbirdportal.dto.PortalOrderParams;
import com.shanyuan.bgbirdportal.dto.PortalProductInfoResult;
import com.shanyuan.bgbirdportal.dto.PortalProductSkuInfo;
import com.shanyuan.bgbirdportal.dto.PromotionProduct;
import com.shanyuan.model.OmsCart;
import com.shanyuan.model.PmsProduct;
import com.shanyuan.model.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-25 10:27
 * <p>
 * desc
 **/
public interface PortalProductDao {
    /*根据分类id查询商品列表*/
    List<PmsProduct> listProductByCategoryId(@Param( "categoryId" ) Integer categoryId);
    /*根据商品id,规格信息查询商品信息*/
    PortalProductInfoResult findProductInfoByParams(@Param("portalOrderParams") PortalOrderParams portalOrderParams);
    /*根据商品id集合查询促销信息*/
    List<PortalProductSkuInfo> getPromotionProductList(@Param( "list" ) List <OmsCart> omsCarts);

}
