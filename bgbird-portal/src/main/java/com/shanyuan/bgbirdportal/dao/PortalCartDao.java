package com.shanyuan.bgbirdportal.dao;

import com.shanyuan.bgbirdportal.dto.PortalCartResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-30 11:09
 * <p>
 * desc
 **/
public interface PortalCartDao {
    List<PortalCartResult> listCartByUserId(@Param( "userId" ) String userId);
}
