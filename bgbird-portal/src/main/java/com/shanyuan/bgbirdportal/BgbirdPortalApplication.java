package com.shanyuan.bgbirdportal;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
@MapperScan({"com.shanyuan.mapper","com.shanyuan.bgbirdportal.dao"})
public class BgbirdPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run( BgbirdPortalApplication.class, args );
    }

}
