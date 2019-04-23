package com.shanyuan.bgbirdadmin.service;

import com.shanyuan.bgbirdadmin.dto.PmsProductAttributeParams;
import com.shanyuan.model.PmsProductAttribute;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 14:32
 * <p>
 * desc
 **/
public interface PmsProductAttributeService {
    int createProductAttribute(PmsProductAttributeParams pmsProductAttributeParams);
    int updateProductAttribute(Integer id,PmsProductAttributeParams pmsProductAttributeParams);
    List<PmsProductAttribute> listProductAttribute(Integer attrCategoryId,Integer attrType,Integer pageNum,Integer pageSize);
    int deleteProductAttribute(List<Integer> ids);
    PmsProductAttribute findProductAttributeById(Integer id);
}
