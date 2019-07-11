package com.shanyuan.bgbirdadmin.dto;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-24 10:37
 * <p>
 * desc
 **/
@Data
public class AmsActiveResult {
    private String activeName;
    private String beginTime;
    private String endTime;
    private String activeIntroduce;
    private String activePicture;
    private Integer id;
    private int peopleCount;
    private int integration;
    private String createTime;
    private int isEnable;
}
