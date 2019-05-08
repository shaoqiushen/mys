package com.shanyuan.bgbirdportal.dao;

import com.shanyuan.bgbirdportal.dto.PortalProductAttirbuteParamsResult;
import com.shanyuan.bgbirdportal.dto.PortalProductAttributeResult;
import com.shanyuan.model.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-25 14:17
 * <p>
 * desc
 **/

public interface PortalProductAttributeValueDao {
    List<PortalProductAttirbuteParamsResult> getAttributeParamsByProductId(@Param( "productId" )Integer productId,@Param( "attrType" )Integer attrType);
    List<PortalProductAttributeResult> findProductSpecByProductId(@Param( "productId" )Integer productId);
    /*查询商品规格*/
    List<PmsSkuStock> getAttributeSpecByProductId(@Param( "productId" )Integer productId);
}
