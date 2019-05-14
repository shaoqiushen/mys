package com.shanyuan.bgbirdadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.bgbirdadmin.dao.OmsOrderDao;
import com.shanyuan.bgbirdadmin.dto.OmsOrderDetailInfoResult;
import com.shanyuan.bgbirdadmin.dto.OmsOrderQueryParams;
import com.shanyuan.bgbirdadmin.dto.OmsOrderResult;
import com.shanyuan.bgbirdadmin.service.OmsOrderService;
import com.shanyuan.mapper.OmsOrderDetailMapper;
import com.shanyuan.mapper.OmsOrderMapper;
import com.shanyuan.model.OmsOrder;
import com.shanyuan.model.OmsOrderDetail;
import com.shanyuan.model.OmsOrderDetailExample;
import com.shanyuan.model.OmsOrderExample;
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

    @Autowired
    OmsOrderMapper omsOrderMapper;

    @Override
    public List<OmsOrderResult> listOrderInfo(OmsOrderQueryParams omsOrderQueryParams, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        return omsOrderDao.listOrderInfo( omsOrderQueryParams );
    }

    @Override
    public int updateOrder(OmsOrder omsOrder) {
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andIdEqualTo( omsOrder.getId() )
                .andOrderIdEqualTo( omsOrder.getOrderId() );
        return omsOrderMapper.updateByExampleSelective( omsOrder,example );
    }

    @Override
    public List<OmsOrderDetailInfoResult> getOrderDetailInfo(Long userId) {
        return omsOrderDao.getOrderDetailInfo( userId );
    }
}
