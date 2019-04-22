package com.shanyuan.bgbirdadmin.service;

import com.shanyuan.bgbirdadmin.dto.PmsProductParams;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-22 15:31
 * <p>
 * desc
 **/
public interface PmsProductService {
    /**
     * 创建商品
     */
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    int createProduct(PmsProductParams productParams);
}
