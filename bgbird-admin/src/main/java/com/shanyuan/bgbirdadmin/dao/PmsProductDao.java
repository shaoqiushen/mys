package com.shanyuan.bgbirdadmin.dao;

import com.shanyuan.bgbirdadmin.dto.PmsProductQueryParams;
import com.shanyuan.bgbirdadmin.dto.PmsProductResult;
import com.shanyuan.model.PmsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
