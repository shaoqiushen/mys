package com.shanyuan.bgbirdportal.dto;

import com.shanyuan.model.UmsUserPointsRecord;
import lombok.Data;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-14 10:51
 * <p>
 * desc
 **/
@Data
public class PortalPointsResult {
    private String month;
    private List<UmsUserPointsRecord> dataList;
}
