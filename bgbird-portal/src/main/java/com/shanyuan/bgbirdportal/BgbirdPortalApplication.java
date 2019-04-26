package com.shanyuan.bgbirdportal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@MapperScan({"com.shanyuan.mapper","com.shanyuan.bgbirdportal.dao"})
@EnableTransactionManagement
public class BgbirdPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run( BgbirdPortalApplication.class, args );
    }

}
