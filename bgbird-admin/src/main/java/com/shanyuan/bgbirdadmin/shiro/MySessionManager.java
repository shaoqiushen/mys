package com.shanyuan.bgbirdadmin.shiro;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * author  shenshaoqiu
 * <p>
 *
 * <p>
 * desc
 **/
public class MySessionManager extends DefaultWebSessionManager {
    public MySessionManager(){
        super();
    }

    /**
     * 重写getSessionId方法
     * @param request
     * @param response
     * @return
     */
    @Override
    public Serializable getSessionId(ServletRequest request, ServletResponse response) {
        //页面请求头传过来的token
        String token = WebUtils.toHttp(request).getHeader("token");
        if(!StringUtils.isEmpty( token )){
            request.setAttribute( ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,"token");
            request.setAttribute( ShiroHttpServletRequest.REFERENCED_SESSION_ID,token );
            request.setAttribute( ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID,Boolean.TRUE );
            return token;
        }
        //否则使用默认的方式
        return super.getSessionId( request, response );
    }
}
