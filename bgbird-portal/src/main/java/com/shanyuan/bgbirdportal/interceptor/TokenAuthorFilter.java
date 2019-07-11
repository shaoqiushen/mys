package com.shanyuan.bgbirdportal.interceptor;

import com.alibaba.fastjson.JSON;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.redis.RedisOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-06-03 9:24
 * <p>
 * desc
 **/
@Component
@Slf4j
public class TokenAuthorFilter implements Filter {

    @Autowired
    RedisOperator redisOperator;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        redisOperator = ctx.getBean("redisOperator", RedisOperator.class);

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = ( HttpServletRequest ) request;
        HttpServletResponse rep = ( HttpServletResponse ) response;

        //设置允许跨域的配置
        // 这里填写你允许进行跨域的主机ip（正式上线时可以动态配置具体允许的域名和IP）
        rep.setHeader("Access-Control-Allow-Origin", "*");
        // 允许的访问方法
        rep.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, OPTIONS, DELETE, PATCH");
        // Access-Control-Max-Age 用于 CORS 相关配置的缓存
        rep.setHeader("Access-Control-Max-Age", "3600");
        rep.setHeader("Access-Control-Allow-Headers","token,Origin, X-Requested-With, Content-Type, Accept");


        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String token = req.getHeader("token");//header方式

        boolean isFilter = false;

        CommonResult result = new CommonResult();

            String method = (( HttpServletRequest ) request).getMethod();
            if (method.equals("OPTIONS")) {
                rep.setStatus( HttpServletResponse.SC_OK);
            }else{
                if (null == token || token.isEmpty()) {
                    result.setCode(1403);
                    result.setMsg( "客户端请求参数中无token信息" );
                } else {
                    Object o=redisOperator.get( token );
                    if(StringUtils.isEmpty( o )){
                        result.setCode(1404);
                        result.setMsg("客户端请求参数token信息无效");
                    }else {
                        result.setCode(00000);
                        result.setMsg("用户授权认证通过!");
                        isFilter = true;
                    }
                }
//                isFilter = true;
               if(isFilter){
                    chain.doFilter(request, response);
                    return;

               }else{
                   PrintWriter writer = null;
                   OutputStreamWriter osw = null;
                   try {
                       osw=new OutputStreamWriter( response.getOutputStream(), "UTF-8" );
                       writer=new PrintWriter( osw, true );
                       String jsonStr = JSON.toJSONString(result);
                       writer.write( jsonStr );
                       writer.flush();
                       writer.close();
                       osw.close();
                   }catch (IOException e) {
                       log.error("过滤器返回信息失败:" + e.getMessage(), e);
                   } finally {
                       if (null != writer) {
                           writer.close();
                       }
                       if (null != osw) {
                           osw.close();
                       }
                   }
                   return;
               }
            }
    }
    @Override
    public void destroy() {

    }


}
