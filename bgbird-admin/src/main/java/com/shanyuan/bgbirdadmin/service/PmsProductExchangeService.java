package com.shanyuan.bgbirdadmin.service;

import com.shanyuan.bgbirdadmin.dto.PmsProductExchangeParams;
import com.shanyuan.bgbirdadmin.dto.PmsProductExchangeResult;


/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-09 16:03
 * <p>
 * desc
 **/
public interface PmsProductExchangeService {
    int createProductExchange(PmsProductExchangeParams pmsProductExchangeParams);
    int updateProductExchangeDeleteStatus(Integer itemId,Integer deleteStatus);
    int updateProductExchange(Integer itemId,PmsProductExchangeParams pmsProductExchangeParams);
    PmsProductExchangeResult listProductExchange();
}
