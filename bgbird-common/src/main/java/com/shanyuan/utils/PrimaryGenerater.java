package com.shanyuan.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-09 11:17
 * <p>
 * desc
 **/
public class PrimaryGenerater {
    private static final String SERIAL_NUMBER = "XXXX"; // 流水号格式
    private static PrimaryGenerater primaryGenerater = null;

    private PrimaryGenerater() {
    }

    /**
     * 取得PrimaryGenerater的单例实现
     *
     * @return
     */
    public static PrimaryGenerater getInstance() {
        if (primaryGenerater == null) {
            synchronized (PrimaryGenerater.class) {
                if (primaryGenerater == null) {
                    primaryGenerater = new PrimaryGenerater();
                }
            }
        }
        return primaryGenerater;
    }

    /**
     * 生成下一个编号
     */
    public synchronized String generaterNextNumber(String sno) {
        String id = null;
        Date date = new Date();

        int count = SERIAL_NUMBER.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("0");
        }
        DecimalFormat df = new DecimalFormat("0000");
        id = df.format(1 + Integer.parseInt(sno.substring(1, 5)));

        return id;
    }

    /*生成一个uuid*/
    public String getUid(){
        String uid=UUID.randomUUID().toString();
        return uid.replace( "-","" );
    }

}
