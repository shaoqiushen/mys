package com.shanyuan.bgbirdadmin.service.impl;

import com.shanyuan.bgbirdadmin.dao.UmsUserRechargeRecordDao;
import com.shanyuan.bgbirdadmin.dto.UmsRechargeRecordParams;
import com.shanyuan.bgbirdadmin.service.UmsUserRechargeService;
import com.shanyuan.mapper.UmsUserRechargeRecordMapper;
import com.shanyuan.model.UmsUserRechargeRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-24 17:06
 * <p>
 * desc
 **/
@Service
@Slf4j
public class UmsUserRechargeServiceImpl implements UmsUserRechargeService {

    @Autowired
    UmsUserRechargeRecordMapper umsUserRechargeRecordMapper;

    @Autowired
    UmsUserRechargeRecordDao umsUserRechargeRecordDao;


    @Override
    public List<UmsUserRechargeRecord> listUserRechargeRecord(UmsRechargeRecordParams umsRechargeRecordParams) {

        return umsUserRechargeRecordDao.listUserRechargeRecord( umsRechargeRecordParams );
    }
}
