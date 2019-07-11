package com.shanyuan.bgbirdportal;

import com.shanyuan.bgbirdportal.interceptor.TokenAuthorFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@MapperScan({"com.shanyuan.mapper","com.shanyuan.bgbirdportal.dao"})
@EnableTransactionManagement
@ComponentScan({"com.shanyuan"})
public class BgbirdPortalApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run( BgbirdPortalApplication.class, args );
    }

    /*将springboot项目打包成war*/
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(BgbirdPortalApplication.class);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean=new FilterRegistrationBean();
        TokenAuthorFilter filter=new TokenAuthorFilter();
        bean.setFilter( filter );
//        bean.addUrlPatterns( "/active/*" );
        bean.addUrlPatterns( "/cart/*" );
        bean.addUrlPatterns( "/comment/*" );
//        bean.addUrlPatterns( "/home/*" );
        bean.addUrlPatterns( "/order/*" );
        bean.addUrlPatterns( "/user/address/*" );
        bean.addUrlPatterns( "/points/*" );
        return bean;
    }

}
