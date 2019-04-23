package com.shanyuan.bgbirdadmin.service;

import com.shanyuan.model.PmsProductAttributeCategory;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 11:44
 * <p>
 * desc
 **/
public interface PmsProductAttributeCategoryService {

    int createProductAttributeCategory(String name);
    int updateProductAttributeCategory(Integer id,String name);
    List<PmsProductAttributeCategory> listProductAttributeCategory(Integer pageNum, Integer pageSize);
    int deleteProductAttributeCategory(Integer id);
}
