package com.shanyuan.bgbirdadmin.component;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-28 17:41
 * <p>
 * desc
 **/
public class MyCorsRegistration extends CorsRegistration {

        public MyCorsRegistration(String pathPattern) {
            super(pathPattern);
        }

        @Override
        public CorsConfiguration getCorsConfiguration() {
            return super.getCorsConfiguration();
        }

}
