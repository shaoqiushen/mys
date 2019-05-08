package com.shanyuan.bgbirdportal;

import com.shanyuan.factory.SnowFlakeFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BgbirdPortalApplicationTests {


    @Test
    public void contextLoads() {
        System.out.println( SnowFlakeFactory.getInstance().getId() );
    }

}
