package com.shanyuan.bgbirdadmin.service.impl;

import com.shanyuan.bgbirdadmin.dto.PmsProductParams;
import com.shanyuan.bgbirdadmin.service.PmsProductService;

import com.shanyuan.mapper.PmsProductMapper;
import com.shanyuan.model.PmsProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-22 15:31
 * <p>
 * desc
 **/
@Service
@Slf4j
public class PmsProductServiceImpl implements PmsProductService {

    @Autowired
    PmsProductMapper pmsProductMapper;


    @Override
    public int createProduct(PmsProductParams productParams) {
        int count = 0;
        //创建商品
        PmsProduct pmsProduct = productParams;
        //基本信息入库
        pmsProductMapper.insertSelective( pmsProduct );

        //
        count=1;
        return count;
    }
}
