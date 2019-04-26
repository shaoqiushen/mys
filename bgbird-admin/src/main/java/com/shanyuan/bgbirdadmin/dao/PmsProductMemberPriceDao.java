package com.shanyuan.bgbirdadmin.dao;

import com.shanyuan.model.PmsProductMemberPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-26 11:07
 * <p>
 * desc
 **/
public interface PmsProductMemberPriceDao {
    int insertList(@Param( "list" ) List<PmsProductMemberPrice> memberPriceList);
}
