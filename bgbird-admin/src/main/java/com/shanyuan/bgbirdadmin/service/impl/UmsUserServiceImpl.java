package com.shanyuan.bgbirdadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.bgbirdadmin.dao.UmsUserDao;
import com.shanyuan.bgbirdadmin.dto.UmsUserParams;
import com.shanyuan.bgbirdadmin.dto.UmsUserResult;
import com.shanyuan.bgbirdadmin.service.UmsUserService;
import com.shanyuan.mapper.UmsUserMapper;
import com.shanyuan.model.UmsUser;
import com.shanyuan.model.UmsUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Autowired
    UmsUserMapper umsUserMapper;

    @Override
    public List<UmsUserResult> listUserInfo(UmsUserParams umsUserParams, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        return umsUserDao.listUserInfo( umsUserParams );
    }

    @Override
    public UmsUser getUserInfo(String openid) {
        UmsUserExample userExample = new UmsUserExample();
        userExample.createCriteria().andOpenidEqualTo( openid );
        List <UmsUser> umsUsers=umsUserMapper.selectByExample( userExample );
        if(!StringUtils.isEmpty( umsUsers )){
            return umsUsers.get( 0 );
        }
        return null;
    }
}
