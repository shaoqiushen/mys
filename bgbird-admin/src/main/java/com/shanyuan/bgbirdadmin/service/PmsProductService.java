package com.shanyuan.bgbirdadmin.service;

import com.shanyuan.bgbirdadmin.dto.PmsProductParams;
import com.shanyuan.bgbirdadmin.dto.PmsProductQueryParams;
import com.shanyuan.bgbirdadmin.dto.PmsProductResult;
import com.shanyuan.model.PmsProduct;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    /*商品列表*/
    List<PmsProduct> listProduct(PmsProductQueryParams pmsProductQueryParams,Integer pageNum,Integer pageSize);
    /*修改商品删除状态*/
    int updateProductDeleteStatus(List<Integer> ids,Integer deleteStatus);
    /*根据商品id获取商品的编辑信息*/
    PmsProductResult getUpdateProductInfoById(Integer productId);
    /*根据商品id修改商品信息*/
    @Transactional
    int updateProductById(Integer productId,PmsProductParams pmsProductParams);
    /*批量上下架*/
    int updatePublishStatues(List<Integer> ids,Integer publishStatus);
    /*批量修改兑换状态*/
    int updateExchangeStatus(List<Integer> ids,Integer exchangeStatus);
}
