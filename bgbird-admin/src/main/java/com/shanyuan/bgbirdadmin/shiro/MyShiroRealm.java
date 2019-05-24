package com.shanyuan.bgbirdadmin.shiro;

import com.shanyuan.mapper.UmsAdminMapper;
import com.shanyuan.model.UmsAdmin;
import com.shanyuan.model.UmsAdminExample;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-26 16:17
 * <p>
 * desc 自定义权限控制
 **/
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    UmsAdminMapper umsAdminMapper;

    /*权限认证*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /*身份认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String account = token.getUsername();//账号

        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andAccountStatusEqualTo( 1 )
                .andAccountEqualTo( account );
        List <UmsAdmin> umsAdmins=umsAdminMapper.selectByExample( example );
        if(umsAdmins.size()==0){
            throw new UnknownAccountException("账号不存在");
        }
        String password = "";
        for(UmsAdmin umsAdmin : umsAdmins){
            //返回实例
            password = umsAdmin.getPassword();
        }
        return new SimpleAuthenticationInfo( token.getPrincipal(), password,getName());
    }
}
