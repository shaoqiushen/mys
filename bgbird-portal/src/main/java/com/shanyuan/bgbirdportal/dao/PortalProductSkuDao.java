package com.shanyuan.bgbirdportal.dao;

import com.shanyuan.model.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-08 11:15
 * <p>
 * desc
 **/
public interface PortalProductSkuDao {
    /*锁定库存*/
    int updateLockStock(@Param( "list" ) List<PmsSkuStock> lockStockList);
}
