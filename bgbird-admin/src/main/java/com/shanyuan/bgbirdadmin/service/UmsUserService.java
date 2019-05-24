package com.shanyuan.bgbirdadmin.service;

import com.shanyuan.bgbirdadmin.dto.UmsUserParams;
import com.shanyuan.bgbirdadmin.dto.UmsUserResult;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 18:51
 * <p>
 * desc
 **/
public interface UmsUserService {

    List<UmsUserResult> listUserInfo(UmsUserParams umsUserParams, Integer pageNum, Integer pageSize);
}
