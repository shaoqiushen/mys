package com.shanyuan.bgbirdadmin.dao;

import com.shanyuan.model.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 16:35
 * <p>
 * desc
 **/
public interface PmsSkuStockDao {
    /*批量插入*/
    int insertList(@Param( "list" )List<PmsSkuStock> list);
    /*批量更新*/
    int updateList(@Param( "list" )List<PmsSkuStock> list);
    /*批量删除*/
    int deleteList(@Param( "ids" )List<Integer> ids);
}
