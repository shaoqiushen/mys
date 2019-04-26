package com.shanyuan.bgbirdadmin.service;

import com.shanyuan.bgbirdadmin.dto.UmsAdminLoginParams;
import com.shanyuan.bgbirdadmin.dto.UmsAdminLoginResult;
import com.shanyuan.bgbirdadmin.dto.UmsAdminParams;
import com.shanyuan.model.UmsAdmin;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-26 15:02
 * <p>
 * desc
 **/
public interface UmsAdminService {

    int createAdmin(UmsAdminParams umsAdminParams);
    int updateAdmin(Integer id,UmsAdminParams umsAdminParams);
    int deleteAdmin(Integer id);
    List<UmsAdmin> listAdmin(Integer pageNum,Integer pageSize);

    UmsAdminLoginResult login(String account,String password);
}
