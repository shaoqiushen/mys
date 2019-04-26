package com.shanyuan.bgbirdportal.dao;

import com.shanyuan.bgbirdportal.dto.PortalProductDetailResult;
import com.shanyuan.model.PmsProduct;
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
    List<PmsProduct> listProductByCategoryId(@Param( "categoryId" ) Integer categoryId);
    PmsProduct findProductInfoById(@Param( "productId" ) Integer productId);

}
