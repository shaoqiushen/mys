package com.shanyuan.bgbirdadmin.dao;

import com.shanyuan.bgbirdadmin.dto.AmsActiveResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-24 10:27
 * <p>
 * desc
 **/
public interface AmsActiveDao {
    int deleteActive(@Param( "id" ) Integer id);
    List<AmsActiveResult> listActiveInfo();
}
