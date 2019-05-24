package com.shanyuan.bgbirdadmin.dao;

import com.shanyuan.bgbirdadmin.dto.UmsUserParams;
import com.shanyuan.bgbirdadmin.dto.UmsUserResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-24 8:46
 * <p>
 * desc
 **/
public interface UmsUserDao {
    List<UmsUserResult> listUserInfo(@Param( "umsUserParams" ) UmsUserParams umsUserParams);
}
