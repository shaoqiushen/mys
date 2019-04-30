package com.shanyuan.bgbirdportal.service;

import com.shanyuan.bgbirdportal.dto.PortalOrderParams;
import com.shanyuan.domain.CommonResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-30 9:39
 * <p>
 * desc
 **/
public interface PortalOrderService {
    @Transactional
    CommonResult createOrder(PortalOrderParams portalOrderParams);
}
