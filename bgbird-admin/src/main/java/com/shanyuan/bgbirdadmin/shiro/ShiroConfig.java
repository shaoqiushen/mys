package com.shanyuan.bgbirdadmin.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-26 16:11
 * <p>
 * desc
 **/
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager( securityManager );
        shiroFilterFactoryBean.setUnauthorizedUrl( "/admin/unAuth" );//无权限跳转
        shiroFilterFactoryBean.setLoginUrl( "/admin/notLogin" );//未登录时跳转

        //配置拦截器
        Map<String, Filter> filterMap = new LinkedHashMap<>(1);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        //开放登陆接口
        filterChainDefinitionMap.put("/admin/login", "anon");
        //开放swagger
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/v2/**", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/**", "authc");//其他路径均拦截
        shiroFilterFactoryBean.setFilterChainDefinitionMap( filterChainDefinitionMap );
        return shiroFilterFactoryBean;
    }

    /**
     * 自定义身份验证
     * @return
     */
    @Bean
    public MyShiroRealm myShiroRealm(){
        return new MyShiroRealm();
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager(  );
        defaultWebSecurityManager.setRealm( myShiroRealm() );
        defaultWebSecurityManager.setSessionManager( sessionManager() );
        return defaultWebSecurityManager;
    }
    /**
     * 注入自定义获取sessionid
     * @return
     */
    @Bean
    public SessionManager sessionManager(){
        return new MySessionManager();
    }
}
