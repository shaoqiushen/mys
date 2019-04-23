package com.shanyuan.bgbirdadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.bgbirdadmin.dto.PmsProductAttributeParams;
import com.shanyuan.bgbirdadmin.service.PmsProductAttributeService;
import com.shanyuan.mapper.PmsProductAttributeMapper;
import com.shanyuan.model.PmsProductAttribute;
import com.shanyuan.model.PmsProductAttributeExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 14:33
 * <p>
 * desc
 **/
@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {

    @Autowired
    PmsProductAttributeMapper pmsProductAttributeMapper;

    @Override
    public int createProductAttribute(PmsProductAttributeParams pmsProductAttributeParams) {
        PmsProductAttribute pmsProductAttribute = new PmsProductAttribute();
        BeanUtils.copyProperties( pmsProductAttributeParams,pmsProductAttribute );
        return pmsProductAttributeMapper.insertSelective( pmsProductAttribute );
    }

    @Override
    public int updateProductAttribute(Integer id, PmsProductAttributeParams pmsProductAttributeParams) {
        PmsProductAttribute pmsProductAttribute = new PmsProductAttribute();
        BeanUtils.copyProperties( pmsProductAttributeParams,pmsProductAttribute );
        pmsProductAttribute.setId( id );
        return pmsProductAttributeMapper.updateByPrimaryKeySelective( pmsProductAttribute );
    }

    @Override
    public List<PmsProductAttribute> listProductAttribute(Integer attrCategoryId, Integer attrType, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum, pageSize);
        PmsProductAttributeExample example = new PmsProductAttributeExample();
        example.createCriteria().andAttrCategoryIdEqualTo( attrCategoryId )
                .andAttrTypeEqualTo( attrType );
        example.setOrderByClause( "sort asc" );
        return pmsProductAttributeMapper.selectByExample( example );
    }

    @Override
    public int deleteProductAttribute(List <Integer> ids) {
        PmsProductAttributeExample example = new PmsProductAttributeExample();
        example.createCriteria().andIdIn( ids );
        return pmsProductAttributeMapper.deleteByExample( example );
    }

    @Override
    public PmsProductAttribute findProductAttributeById(Integer id) {
        return pmsProductAttributeMapper.selectByPrimaryKey( id );
    }
}
