package com.shanyuan.bgbirdadmin.dao;

import com.shanyuan.model.PmsProductAttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 16:19
 * <p>
 * desc
 **/
public interface PmsProductAttributeValueDao {
    int insertList(@Param( "list" )List<PmsProductAttributeValue> list);
}
