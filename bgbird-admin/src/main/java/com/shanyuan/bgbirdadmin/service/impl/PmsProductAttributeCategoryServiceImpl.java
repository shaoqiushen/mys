package com.shanyuan.bgbirdadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.bgbirdadmin.service.PmsProductAttributeCategoryService;
import com.shanyuan.mapper.PmsProductAttributeCategoryMapper;
import com.shanyuan.model.PmsProductAttributeCategory;
import com.shanyuan.model.PmsProductAttributeCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 11:44
 * <p>
 * desc
 **/
@Service
public class PmsProductAttributeCategoryServiceImpl implements PmsProductAttributeCategoryService {

    @Autowired
    PmsProductAttributeCategoryMapper pmsProductAttributeCategoryMapper;

    @Override
    public int createProductAttributeCategory(String name) {
        PmsProductAttributeCategory pmsProductAttributeCategory = new PmsProductAttributeCategory();
        pmsProductAttributeCategory.setName( name );
        return pmsProductAttributeCategoryMapper.insertSelective( pmsProductAttributeCategory );
    }

    @Override
    public int updateProductAttributeCategory(Integer id, String name) {
        PmsProductAttributeCategory pmsProductAttributeCategory = new PmsProductAttributeCategory();
        pmsProductAttributeCategory.setName( name );
        pmsProductAttributeCategory.setId( id );
        return pmsProductAttributeCategoryMapper.updateByPrimaryKeySelective( pmsProductAttributeCategory );
    }

    @Override
    public List<PmsProductAttributeCategory> listProductAttributeCategory(Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        PmsProductAttributeCategoryExample example = new PmsProductAttributeCategoryExample();
        example.setOrderByClause( "id asc" );
        return pmsProductAttributeCategoryMapper.selectByExample( example );
    }

    @Override
    public int deleteProductAttributeCategory(Integer id) {
        return pmsProductAttributeCategoryMapper.deleteByPrimaryKey( id );
    }
}
