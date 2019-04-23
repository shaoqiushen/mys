package com.shanyuan.bgbirdadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.bgbirdadmin.dto.UmsUserParams;
import com.shanyuan.bgbirdadmin.service.UmsUserService;
import com.shanyuan.mapper.UmsUserMapper;
import com.shanyuan.model.UmsUser;
import com.shanyuan.model.UmsUserExample;
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
    UmsUserMapper umsUserMapper;

    @Override
    public List<UmsUser> listUserInfo(UmsUserParams umsUserParams, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );

        return null;
    }
}
