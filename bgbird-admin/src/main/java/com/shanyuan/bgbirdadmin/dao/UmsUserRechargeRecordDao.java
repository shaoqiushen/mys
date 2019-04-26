package com.shanyuan.bgbirdadmin.dao;

import com.shanyuan.bgbirdadmin.dto.UmsRechargeRecordParams;
import com.shanyuan.model.UmsUserRechargeRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-26 17:35
 * <p>
 * desc
 **/
public interface UmsUserRechargeRecordDao {
    List<UmsUserRechargeRecord> listUserRechargeRecord(@Param( "umsRechargeRecordParams" ) UmsRechargeRecordParams umsRechargeRecordParams);
}
