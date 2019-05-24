package com.shanyuan.bgbirdadmin.service;

import com.shanyuan.bgbirdadmin.dto.PmsProductCategoryParams;
import com.shanyuan.model.PmsProductCategory;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 9:04
 * <p>
 * desc
 **/
public interface PmsProductCategoryService {
    int createProductCategory(PmsProductCategoryParams pmsProductCategoryParams);
    int updateProductCategory(Integer categoryId,PmsProductCategoryParams pmsProductCategoryParams);
    List<PmsProductCategory> listProductCategory(Integer pageNum, Integer pageSize);
    int deleteProductCategory(Integer categoryId);
}
