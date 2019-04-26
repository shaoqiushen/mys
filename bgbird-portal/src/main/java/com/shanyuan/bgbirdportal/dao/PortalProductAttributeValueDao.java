package com.shanyuan.bgbirdportal.dao;

import com.shanyuan.bgbirdportal.dto.PortalProductAttirbuteParamsResult;
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
    List<PortalProductAttirbuteParamsResult> getAttributeParamsByProductId(@Param( "productId" )Integer productId);
}
