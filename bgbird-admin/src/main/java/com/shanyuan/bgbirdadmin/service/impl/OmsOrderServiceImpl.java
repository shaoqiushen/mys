package com.shanyuan.bgbirdadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.bgbirdadmin.dao.OmsOrderDao;
import com.shanyuan.bgbirdadmin.dto.OmsOrderQueryParams;
import com.shanyuan.bgbirdadmin.service.OmsOrderService;
import com.shanyuan.model.OmsOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 17:36
 * <p>
 * desc
 **/
@Service
public class OmsOrderServiceImpl implements OmsOrderService {

    @Autowired
    OmsOrderDao omsOrderDao;

    @Override
    public List<OmsOrder> listOrderInfo(OmsOrderQueryParams omsOrderQueryParams, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        return omsOrderDao.listOrderInfo( omsOrderQueryParams );
    }
}
