package com.shanyuan.bgbirdadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.bgbirdadmin.dto.PmsProductCategoryParams;
import com.shanyuan.bgbirdadmin.service.PmsProductCategoryService;
import com.shanyuan.mapper.PmsProductCategoryMapper;
import com.shanyuan.model.PmsProductCategory;
import com.shanyuan.model.PmsProductCategoryExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 9:05
 * <p>
 * desc
 **/
@Service
@Slf4j
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {

    @Autowired
    PmsProductCategoryMapper pmsProductCategoryMapper;

    @Override
    public int createProductCategory(PmsProductCategoryParams pmsProductCategoryParams) {
        PmsProductCategory pmsProductCategory = new PmsProductCategory();
        BeanUtils.copyProperties( pmsProductCategoryParams,pmsProductCategory );
        int count=pmsProductCategoryMapper.insertSelective( pmsProductCategory );
        return count;
    }

    @Override
    public int updateProductCategory(Integer categoryId, PmsProductCategoryParams pmsProductCategoryParams) {
        PmsProductCategory pmsProductCategory = new PmsProductCategory();
        BeanUtils.copyProperties( pmsProductCategoryParams,pmsProductCategory );
        pmsProductCategory.setCategoryId( categoryId );
        int count = pmsProductCategoryMapper.updateByPrimaryKeySelective( pmsProductCategory );
        return count;
    }

    @Override
    public List<PmsProductCategory> listProductCategory(Integer pageNum,Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        example.setOrderByClause( "sort asc" );
        return pmsProductCategoryMapper.selectByExample( example );
    }

    @Override
    public int deleteProductCategory(Integer categoryId) {
        return pmsProductCategoryMapper.deleteByPrimaryKey( categoryId );
    }
}
