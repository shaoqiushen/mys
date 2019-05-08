package com.shanyuan.bgbirdadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.bgbirdadmin.dto.UmsAdminLoginParams;
import com.shanyuan.bgbirdadmin.dto.UmsAdminLoginResult;
import com.shanyuan.bgbirdadmin.dto.UmsAdminParams;
import com.shanyuan.bgbirdadmin.service.UmsAdminService;
import com.shanyuan.mapper.UmsAdminMapper;
import com.shanyuan.model.UmsAdmin;
import com.shanyuan.model.UmsAdminExample;
import com.shanyuan.utils.MyDateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-26 15:03
 * <p>
 * desc
 **/
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    UmsAdminMapper umsAdminMapper;



    @Override
    public int createAdmin(UmsAdminParams umsAdminParams) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties( umsAdminParams,umsAdmin );
        umsAdmin.setCreateTime( new Date() );
        return umsAdminMapper.insert( umsAdmin );
    }

    @Override
    public int updateAdmin(Integer id, UmsAdminParams umsAdminParams) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties( umsAdminParams,umsAdmin );
        return umsAdminMapper.updateByPrimaryKey( umsAdmin );
    }

    @Override
    public int deleteAdmin(Integer id) {
        return umsAdminMapper.deleteByPrimaryKey( id );
    }

    @Override
    public List<UmsAdmin> listAdmin(Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        UmsAdminExample example = new UmsAdminExample();
        example.setOrderByClause( "id desc" );
        return umsAdminMapper.selectByExample( example );
    }

    @Override
    public UmsAdminLoginResult login(String account, String password) {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andAccountEqualTo( account )
                .andPasswordEqualTo( password )
                .andAccountStatusEqualTo( 1 );
        List <UmsAdmin> umsAdmins=umsAdminMapper.selectByExample( example );
        UmsAdminLoginResult umsAdminLoginResult = new UmsAdminLoginResult();
        if(umsAdmins.size()>0){
            for(UmsAdmin umsAdmin : umsAdmins){
                umsAdminLoginResult.setAccount( umsAdmin.getAccount() );
                umsAdminLoginResult.setLastLoginTime( umsAdmin.getLastLoginTime() == null?new Date(): umsAdmin.getLastLoginTime());
            }
            UmsAdmin umsAdmin = new UmsAdmin();
            umsAdmin.setLastLoginTime( new Date() );
            //将最后一次登录时间同步为当前登录时间
            umsAdminMapper.updateByExampleSelective( umsAdmin,example );
        }else{
            return  null;
        }
        return umsAdminLoginResult;
    }


}
