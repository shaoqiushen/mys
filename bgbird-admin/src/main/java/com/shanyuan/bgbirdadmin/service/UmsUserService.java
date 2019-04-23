package com.shanyuan.bgbirdadmin.service;

import com.shanyuan.bgbirdadmin.dto.UmsUserParams;
import com.shanyuan.model.UmsUser;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 18:51
 * <p>
 * desc
 **/
public interface UmsUserService {

    List<UmsUser> listUserInfo(UmsUserParams umsUserParams,Integer pageNum,Integer pageSize);
}
