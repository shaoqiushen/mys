package com.shanyuan.bgbirdadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.bgbirdadmin.dao.UmsUserDao;
import com.shanyuan.bgbirdadmin.dto.UmsUserParams;
import com.shanyuan.bgbirdadmin.dto.UmsUserResult;
import com.shanyuan.bgbirdadmin.service.UmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 18:51
 * <p>
 * desc
 **/
@Service
public class UmsUserServiceImpl implements UmsUserService {

    @Autowired
    UmsUserDao umsUserDao;

    @Override
    public List<UmsUserResult> listUserInfo(UmsUserParams umsUserParams, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        return umsUserDao.listUserInfo( umsUserParams );
    }
}
