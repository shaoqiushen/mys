package com.shanyuan.bgbirdadmin.dao;

import com.shanyuan.bgbirdadmin.dto.PmsProductResult;
import org.apache.ibatis.annotations.Param;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-29 15:44
 * <p>
 * desc
 **/
public interface PmsProductDao {
    PmsProductResult getUpdateProductInfoById(@Param( "productId" ) Integer productId);
}
