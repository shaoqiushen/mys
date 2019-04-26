package com.shanyuan.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-24 9:30
 * <p>
 * desc 时间相关组件工具
 **/
@Component
public class MyDateUtil {


    /*
    获取当前时间
    Date ->长时间字符串
    *  返回时间类型 yyyy-MM-dd HH:mm:ss
    * */
    public static String getLongNowTime(){
        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Date date = new Date(  );
        String time=format.format( date );
        return time;
    }

    /*
    获取当前时间
    Date ->短时间字符串
    *  返回时间类型 yyyy-MM-dd
    * */
    public static String getShortNowTime(){
        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );
        Date date = new Date(  );
        String time=format.format( date );
        return time;
    }

    /*
    *  长时间字符串转为Date
    *
    * */
    public static Date parseLongStringDate(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Date date=format.parse( time );
        return date;
    }

    /*
    * 短时间字符串转为Date
    * */
    public static Date parseShortStringDate(String time) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );
        Date date = format.parse( time );
        return date;
    }
}
