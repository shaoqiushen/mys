package com.shanyuan.bgbirdportal.service.impl;

import com.shanyuan.bgbirdportal.dao.PortalCommentDao;
import com.shanyuan.bgbirdportal.dto.CommentDto;
import com.shanyuan.bgbirdportal.dto.PortalCommentParams;
import com.shanyuan.bgbirdportal.service.PortalCommentService;
import com.shanyuan.bgbirdportal.service.PortalUmsUserService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.mapper.*;
import com.shanyuan.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-09 8:53
 * <p>
 * desc
 **/
@Service
public class PortalCommentServiceImpl implements PortalCommentService {


    @Autowired
    OmsProductCommentMapper omsProductCommentMapper;

    @Autowired
    PmsProductMapper pmsProductMapper;

    @Autowired
    UmsUserMapper umsUserMapper;

    @Autowired
    PortalUmsUserService portalUmsUserService;

    @Autowired
    OmsOrderMapper omsOrderMapper;

    @Autowired
    PortalCommentDao portalCommentDao;

    @Autowired
    OmsOrderDetailMapper omsOrderDetailMapper;

    @Override
    public CommonResult createComment(PortalCommentParams portalCommentParams) {

        //判断用户是否存在
        UmsUser userInfo=portalUmsUserService.getUserInfo( portalCommentParams.getUserId() );
        if(userInfo == null){
            return new CommonResult().failed( "用户不存在" );
        }

        //判断订单是否存在
        OmsOrderExample orderExample = new OmsOrderExample();
        orderExample.createCriteria().andOrderIdEqualTo( portalCommentParams.getOrderId() );
        List <OmsOrder> omsOrders=omsOrderMapper.selectByExample( orderExample );
        if(omsOrders.size() == 0){
            return new CommonResult().failed( "订单不存在" );
        }
        //判断商品是否存在
//        PmsProduct pmsProduct=pmsProductMapper.selectByPrimaryKey( portalCommentParams.getProductId() );
//        if(pmsProduct == null){
//            return new CommonResult().failed( "商品不存在" );
//        }
//        OmsProductComment comment = new OmsProductComment();
//        BeanUtils.copyProperties( portalCommentParams,comment );
//        comment.setCreateTime( new Date(  ) );
//        comment.setShowStatus( 1 );
//        int count=omsProductCommentMapper.insert( comment );
        List<OmsProductComment> productCommentList = new ArrayList <>(  );
        OmsProductComment comment = null;
        List<Integer> productIdList = new ArrayList <>(  );
        for(CommentDto commentDto : portalCommentParams.getCommentList()){
            comment = new OmsProductComment();
            BeanUtils.copyProperties( commentDto, comment);
            comment.setCreateTime( new Date(  ) );
            comment.setShowStatus( 1 );//默认展示
            comment.setOrderId( portalCommentParams.getOrderId() );
            comment.setNickname( portalCommentParams.getNickname() );
            comment.setAvartalUrl( portalCommentParams.getAvartalUrl() );
            comment.setUserId( portalCommentParams.getUserId() );
            productIdList.add( commentDto.getProductId() );
            productCommentList.add( comment );
        }
        //为订单中的每个商品添加评价
        int count=portalCommentDao.createComment( productCommentList );


        //修改订单的评价状态为已评价
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setCommentStatus( portalCommentParams.getCommentStatus() );
        count=omsOrderMapper.updateByExampleSelective( omsOrder, orderExample );

        //修改订单详情评价状态
        OmsOrderDetailExample orderDetailExample = new OmsOrderDetailExample();
        orderDetailExample.createCriteria().andOrderIdEqualTo( portalCommentParams.getOrderId() )
                .andProductIdIn( productIdList );
        OmsOrderDetail omsOrderDetail = new OmsOrderDetail();
        omsOrderDetail.setCommentStatus( 1 );
        count = omsOrderDetailMapper.updateByExampleSelective( omsOrderDetail, orderDetailExample);
        return new CommonResult().success( count );
    }
}
