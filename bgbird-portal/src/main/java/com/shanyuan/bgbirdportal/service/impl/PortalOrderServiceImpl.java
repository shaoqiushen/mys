package com.shanyuan.bgbirdportal.service.impl;

import com.shanyuan.bgbirdportal.dao.PortalProductDao;
import com.shanyuan.bgbirdportal.dto.PortalOrderParams;
import com.shanyuan.bgbirdportal.dto.PortalProductInfoResult;
import com.shanyuan.bgbirdportal.service.PortalOrderService;
import com.shanyuan.bgbirdportal.service.PortalUserAddressService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.factory.SnowFlakeFactory;
import com.shanyuan.mapper.OmsOrderDetailMapper;
import com.shanyuan.mapper.OmsOrderMapper;
import com.shanyuan.mapper.PmsSkuStockMapper;
import com.shanyuan.mapper.UmsUserReceiveAddressMapper;
import com.shanyuan.model.OmsOrder;
import com.shanyuan.model.OmsOrderDetail;
import com.shanyuan.model.PmsSkuStock;
import com.shanyuan.model.UmsUserReceiveAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-30 9:39
 * <p>
 * desc
 **/
@Service
public class PortalOrderServiceImpl implements PortalOrderService {

    @Autowired
    PortalProductDao portalProductDao;

    @Autowired
    PmsSkuStockMapper pmsSkuStockMapper;

    @Autowired
    PortalUserAddressService portalUserAddressService;

    @Autowired
    OmsOrderMapper omsOrderMapper;

    @Autowired
    OmsOrderDetailMapper omsOrderDetailMapper;


    @Override
    public CommonResult createOrder(PortalOrderParams portalOrderParams) {
        //查商品信息
        PortalProductInfoResult productInfoResult=portalProductDao.findProductInfoByParams( portalOrderParams );
        if(productInfoResult == null){
            return new CommonResult().failed( "下单失败，商品不存在" );
        }
        //判断商品的库存是否充足
        if(productInfoResult.getStock() < portalOrderParams.getBuyCount()){
            return new CommonResult().failed( "下单失败，库存不足" );
        }
        //商品售价
        int price;

        if(productInfoResult.getPromotionPrice()==0){
            //说明没有促销，使用原价
            price = productInfoResult.getPrice();
        }else{
            price = productInfoResult.getPromotionPrice();
        }

        //判断是否使用了优惠券
        if(portalOrderParams.getCouponId() == null){
            //不使用优惠券
        }else{
            //使用了优惠券
        }
        //优惠券抵扣金额
        int couponAmount = 0;
        //邮费
        int freightAmount = 0;
        //促销优惠金额
        int promotionAmount = 0;


        //锁定库存//负数//超时未支付或异常时需要还原库存
        lockStock(productInfoResult.getSkuId(),portalOrderParams.getBuyCount());

        //计算商品总价
        int total_amount = price*portalOrderParams.getBuyCount() ;
        if(total_amount>=productInfoResult.getFullPrice()){
            //假如大于满减
            promotionAmount = productInfoResult.getReducePrice();
        }

        Long orderId = SnowFlakeFactory.getInstance().getId();
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setUserId( portalOrderParams.getUserId() );
        omsOrder.setOrderId( orderId );
        omsOrder.setTotalAmount( total_amount );
        omsOrder.setCouponId( portalOrderParams.getCouponId() );//优惠券id
        omsOrder.setPayType( portalOrderParams.getPayType() );
        omsOrder.setOrderStatus( 0 );//待付款
        omsOrder.setSourceType( portalOrderParams.getSourceType() );
        omsOrder.setCouponAmount( couponAmount );//优惠券抵扣金额
        omsOrder.setFreightAmount( freightAmount );//邮费
        omsOrder.setNotes( portalOrderParams.getNotes() );
        omsOrder.setCreateTime( new Date(  ) );//订单创建时间
        omsOrder.setPromotionAmount( promotionAmount );//促销优惠金额
        omsOrder.setDeleteStatus( 0 );
        //查询收货人信息
        UmsUserReceiveAddress userAddressById=portalUserAddressService.getUserAddressById( portalOrderParams.getUserId(), portalOrderParams.getAddressId() );
        omsOrder.setReceiverAddress( userAddressById.getAddressArea()+userAddressById.getAddressDetail() );
        omsOrder.setReceiverName( userAddressById.getReceiverName() );
        omsOrder.setReceiverPhone( userAddressById.getReceiverPhone() );
        omsOrder.setConfirmStatus( 0 );//未收货

        //实付=总额+运费-优惠券抵扣金额-促销优惠金额
        int payAmount = total_amount + freightAmount - couponAmount - promotionAmount;
        omsOrder.setPayAmount( payAmount );
        //入订单主表
        omsOrderMapper.insert( omsOrder );

        //订单详情
        OmsOrderDetail omsOrderDetail = new OmsOrderDetail();
        omsOrderDetail.setBuyCount( portalOrderParams.getBuyCount() );
        omsOrderDetail.setOrderId( orderId );
        omsOrderDetail.setPrice( price );
        omsOrderDetail.setProductName( productInfoResult.getProductName() );
        omsOrderDetail.setProductId( portalOrderParams.getProductId() );
        omsOrderDetailMapper.insert( omsOrderDetail );

        return new CommonResult().success( "下单成功" );
    }

    private void lockStock(Integer skuId,Integer buyCount){
        PmsSkuStock pmsSkuStock=pmsSkuStockMapper.selectByPrimaryKey( skuId );
        pmsSkuStock.setLockStock( pmsSkuStock.getLockStock()+ buyCount);
        pmsSkuStockMapper.updateByPrimaryKeySelective( pmsSkuStock );
    }


}
