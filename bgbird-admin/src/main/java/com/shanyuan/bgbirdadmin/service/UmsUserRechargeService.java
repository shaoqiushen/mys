package com.shanyuan.bgbirdadmin.service;

import com.shanyuan.bgbirdadmin.dto.UmsRechargeRecordParams;
import com.shanyuan.model.UmsUserRechargeRecord;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-24 17:06
 * <p>
 * desc
 **/
public interface UmsUserRechargeService {

    List<UmsUserRechargeRecord> listUserRechargeRecord(UmsRechargeRecordParams umsRechargeRecordParams);
}
