package com.shanyuan.bgbirdportal.service;

import com.shanyuan.bgbirdportal.dto.PortalAuthorizationParams;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.model.UmsUser;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-15 15:46
 * <p>
 * desc
 **/
public interface PortalUmsUserService {
    /*根据用户id查询用户信息*/
    UmsUser getUserInfo(String userId);
    /*用户授权*/
    CommonResult authorization(PortalAuthorizationParams portalAuthorizationParams);
}
