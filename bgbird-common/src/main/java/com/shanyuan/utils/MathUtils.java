package com.shanyuan.utils;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-06-05 15:01
 * <p>
 * desc
 **/
@Component
public class MathUtils {

    public double getTwoBitValue(double value){
        BigDecimal bigDecimal = new BigDecimal( value );
        BigDecimal v=bigDecimal.setScale( 2, BigDecimal.ROUND_HALF_UP );
        return v.doubleValue();
    }
}
