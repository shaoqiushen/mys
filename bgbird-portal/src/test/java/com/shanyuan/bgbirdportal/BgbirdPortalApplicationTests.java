package com.shanyuan.bgbirdportal;

import com.shanyuan.bgbirdportal.dto.PortalOrderParams;
import com.shanyuan.bgbirdportal.service.PortalOrderService;
import com.shanyuan.bgbirdportal.service.PortalUserPointsService;
import com.shanyuan.factory.SnowFlakeFactory;
import com.shanyuan.utils.PrimaryGenerater;
import org.hibernate.validator.internal.util.StringHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BgbirdPortalApplicationTests {

    @Autowired
    PortalOrderService portalOrderService;

    @Autowired
    PortalUserPointsService portalUserPointsService;

    @Test
    public void contextLoads() {
//        System.out.println( PrimaryGenerater.getInstance().generaterNextNumber( "0002" ) );
//        PortalOrderParams portalOrderParams = new PortalOrderParams();
//        portalOrderService.createOrderByCart( portalOrderParams );
        portalUserPointsService.updateIntegration( "013579265744",1500 );
    }

}
