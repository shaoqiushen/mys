package com.shanyuan.bgbirdadmin.dao;

import com.shanyuan.model.PmsProductFullReduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-26 11:11
 * <p>
 * desc
 **/
public interface PmsProductFullReductionDao {
    int insertList(@Param( "list" )List<PmsProductFullReduction> fullReductionList);
}
