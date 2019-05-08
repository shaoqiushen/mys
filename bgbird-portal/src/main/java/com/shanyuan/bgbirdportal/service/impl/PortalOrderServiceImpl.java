package com.shanyuan.bgbirdportal.service.impl;

import com.shanyuan.bgbirdportal.dao.PortalOrderDao;
import com.shanyuan.bgbirdportal.dao.PortalProductDao;
import com.shanyuan.bgbirdportal.dao.PortalProductSkuDao;
import com.shanyuan.bgbirdportal.dto.*;
import com.shanyuan.bgbirdportal.service.PortalOrderService;
import com.shanyuan.bgbirdportal.service.PortalUserAddressService;
import com.shanyuan.bgbirdportal.service.PromotionService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.exception.BussinessException;
import com.shanyuan.factory.SnowFlakeFactory;
import com.shanyuan.mapper.*;
import com.shanyuan.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


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

    @Autowired
    PortalOrderDao portalOrderDao;

    @Autowired
    OmsCartMapper omsCartMapper;

    @Autowired
    PromotionService promotionService;

    @Autowired
    UmsUserReceiveAddressMapper umsUserReceiveAddressMapper;

    @Autowired
    PortalProductSkuDao portalProductSkuDao;




//    @Override
//    public CommonResult createOrder(PortalOrderParams portalOrderParams) {
//        //查商品信息
//        PortalProductInfoResult productInfoResult=portalProductDao.findProductInfoByParams( portalOrderParams );
//        if(productInfoResult == null){
//            return new CommonResult().failed( "下单失败，商品不存在" );
//        }
//        //判断商品的库存是否充足
//        if(productInfoResult.getStock() < portalOrderParams.getBuyCount()){
//            return new CommonResult().failed( "下单失败，库存不足" );
//        }
//        //商品售价
//        int price;
//
//        if(productInfoResult.getPromotionPrice()==0){
//            //说明没有促销，使用原价
//            price = productInfoResult.getPrice();
//        }else{
//            price = productInfoResult.getPromotionPrice();
//        }
//
//        //判断是否使用了优惠券
//        if(portalOrderParams.getCouponId() == null){
//            //不使用优惠券
//        }else{
//            //使用了优惠券
//        }
//        //优惠券抵扣金额
//        int couponAmount = 0;
//        //邮费
//        int freightAmount = 0;
//        //促销优惠金额
//        int promotionAmount = 0;
//
//
//        //锁定库存//负数//超时未支付或异常时需要还原库存
//        lockStock(productInfoResult.getSkuId(),portalOrderParams.getBuyCount());
//
//        //计算商品总价
//        int total_amount = price*portalOrderParams.getBuyCount() ;
//        if(total_amount>=productInfoResult.getFullPrice()){
//            //假如大于满减
//            promotionAmount = productInfoResult.getReducePrice();
//        }
//
//        Long orderId = SnowFlakeFactory.getInstance().getId();
//        OmsOrder omsOrder = new OmsOrder();
//        omsOrder.setUserId( portalOrderParams.getUserId() );
//        omsOrder.setOrderId( orderId );
//        omsOrder.setTotalAmount( total_amount );
//        omsOrder.setCouponId( portalOrderParams.getCouponId() );//优惠券id
//        omsOrder.setPayType( portalOrderParams.getPayType() );
//        omsOrder.setOrderStatus( 0 );//待付款
//        omsOrder.setSourceType( portalOrderParams.getSourceType() );
//        omsOrder.setCouponAmount( couponAmount );//优惠券抵扣金额
//        omsOrder.setFreightAmount( freightAmount );//邮费
//        omsOrder.setNotes( portalOrderParams.getNotes() );
//        omsOrder.setCreateTime( new Date(  ) );//订单创建时间
//        omsOrder.setPromotionAmount( promotionAmount );//促销优惠金额
//        omsOrder.setDeleteStatus( 0 );
//        //查询收货人信息
//        UmsUserReceiveAddress userAddressById=portalUserAddressService.getUserAddressById( portalOrderParams.getUserId(), portalOrderParams.getAddressId() );
//        omsOrder.setReceiverAddress( userAddressById.getAddressArea()+userAddressById.getAddressDetail() );
//        omsOrder.setReceiverName( userAddressById.getReceiverName() );
//        omsOrder.setReceiverPhone( userAddressById.getReceiverPhone() );
//        omsOrder.setConfirmStatus( 0 );//未收货
//
//        //实付=总额+运费-优惠券抵扣金额-促销优惠金额
//        int payAmount = total_amount + freightAmount - couponAmount - promotionAmount;
//        omsOrder.setPayAmount( payAmount );
//        //入订单主表
//        omsOrderMapper.insert( omsOrder );
//
//        //订单详情
//        OmsOrderDetail omsOrderDetail = new OmsOrderDetail();
//        omsOrderDetail.setBuyCount( portalOrderParams.getBuyCount() );
//        omsOrderDetail.setOrderId( orderId );
//        omsOrderDetail.setPrice( price );
//        omsOrderDetail.setProductName( productInfoResult.getProductName() );
//        omsOrderDetail.setProductId( portalOrderParams.getProductId() );
//        omsOrderDetailMapper.insert( omsOrderDetail );
//
//        return new CommonResult().success( "下单成功" );
//    }

    @Override
    public CommonResult createOrderByCart(PortalOrderParams portalOrderParams) {
        //根据用户id拉取其相应的购物车信息
        OmsCartExample example = new OmsCartExample();
        example.createCriteria().andDeleteStatusEqualTo( 0 )
                .andUserIdEqualTo( portalOrderParams.getUserId() );
        //用户的购物车信息集合
        List <OmsCart> omsCarts=omsCartMapper.selectByExample( example );
        if(omsCarts.size()==0){
            throw new BussinessException( "购物车不存在" );
        }
        List<Integer> cartIdList = new ArrayList <>(  );
        List<PmsSkuStock> stockLockList = new ArrayList <>(  );
        //获取商品优惠信息
        List <PortalProductSkuInfo> promotionProducts=promotionService.calcCartPromotion( omsCarts );
        OmsOrder omsOrder = new OmsOrder();
        List<OmsOrder> orderList = new ArrayList <>(  );
        List<OmsOrderDetail> orderDetailList = new ArrayList <>(  );
        Long orderId = SnowFlakeFactory.getInstance().getId();
        int totalAmount = 0;
        if(promotionProducts.size()>0){
            for(PortalProductSkuInfo product : promotionProducts){
                for(OmsCart omsCart : omsCarts){
                    cartIdList.add( omsCart.getId() );
                    if(product.getProductId().compareTo( omsCart.getProductId() )==0 && product.getSkuId().compareTo( omsCart.getSkuId() )==0){
                        //同一商品
                        //判断库存是否充足
                        //真实库存=剩余库存-锁定库存
                        int realStock = product.getStock() - product.getLockStock();
                        if(realStock < omsCart.getBuyCount()){
                            return new CommonResult().failed( "库存不足，无法下单" );
                        }
                        OmsOrderDetail detail = new OmsOrderDetail();
                        detail.setProductId( product.getProductId() );
                        detail.setProductName( product.getProductName() );
                        int price = 0;
                        if(product.getPromotionPrice() == null){
                            price = product.getPrice();
                        }else {
                            price = product.getPromotionPrice();
                        }
                        detail.setPrice( price );
                        detail.setOrderId( orderId );
                        detail.setProductPicture( product.getPicture() );
                        detail.setBuyCount( omsCart.getBuyCount() );
                        detail.setSp1( product.getSp1() );
                        detail.setSp2( product.getSp2() );
                        detail.setSp3( product.getSp3() );
                        totalAmount+=price*omsCart.getBuyCount();
                        orderDetailList.add( detail );

                        PmsSkuStock skuStock = new PmsSkuStock();
                        skuStock.setLockStock( product.getLockStock() + omsCart.getBuyCount() );
                        skuStock.setId( product.getSkuId() );
                        stockLockList.add( skuStock );
                    }
                }
            }
            omsOrder.setDeleteStatus( 0 );
            omsOrder.setConfirmStatus( 0 );
            omsOrder.setCommentStatus( 0 );//待评价
            omsOrder.setEatType( portalOrderParams.getEatType() );//0堂吃 1配送
            omsOrder.setUserId( portalOrderParams.getUserId() );
            omsOrder.setNotes( portalOrderParams.getNotes() );//备注
            omsOrder.setCreateTime( new Date(  ) );
            omsOrder.setSourceType( portalOrderParams.getSourceType() );//订单来源:0->app订单,1->PC订单
            omsOrder.setOrderStatus( 0 );//待支付
            omsOrder.setPayType( portalOrderParams.getPayType() );
            omsOrder.setOrderType( portalOrderParams.getOrderType() );
            omsOrder.setOrderId( orderId );
            omsOrder.setTotalAmount( totalAmount );
            omsOrder.setPayAmount( totalAmount );
            //假如是堂吃则不用配送
            if(portalOrderParams.getEatType() == 1){
                //选择配送
                //根据收货地址id查询收货信息
                UmsUserReceiveAddressExample addressExample = new UmsUserReceiveAddressExample();
                addressExample.createCriteria().andUserIdEqualTo( portalOrderParams.getUserId() )
                        .andIdEqualTo( portalOrderParams.getAddressId() );
                List <UmsUserReceiveAddress> umsUserReceiveAddresses=umsUserReceiveAddressMapper.selectByExample( addressExample );
                if(umsUserReceiveAddresses.size()==0){
                    return new CommonResult().failed( "用户收货地址不存在，无法下单" );
                }
                omsOrder.setReceiverPhone( umsUserReceiveAddresses.get( 0 ).getReceiverPhone() );
                omsOrder.setReceiverName( umsUserReceiveAddresses.get( 0 ).getReceiverName() );
                omsOrder.setReceiverAddress(  umsUserReceiveAddresses.get( 0 ).getAddressArea() + umsUserReceiveAddresses.get( 0 ).getAddressDetail() );
            }

        }else {
            return new CommonResult().failed( "商品不存在，无法下单" );
        }

        // 锁定库存
        portalProductSkuDao.updateLockStock( stockLockList );

        //订单主表入库
        omsOrderMapper.insert( omsOrder );
        if(orderDetailList.size()==0){
            return new CommonResult().failed( "下单失败" );
        }
        //订单详细入库
        portalOrderDao.insertOrderDetail( orderDetailList );

        //清空购物车
        OmsCartExample cartExample = new OmsCartExample();
        cartExample.createCriteria()
                .andUserIdEqualTo( portalOrderParams.getUserId() )
                .andIdIn( cartIdList );
        omsCartMapper.deleteByExample( cartExample );
        Map<String,Long> orderIdMap = new HashMap <>(  );
        orderIdMap.put( "orderId",orderId );
        return new CommonResult().success( "下单成功",orderIdMap);
    }

    @Override
    public List<PortalOrderQueryResult> listOrderInfoByParams(PortalOrderQueryParams portalOrderQueryParams,Integer pageNum,Integer pageSize) {
        int startNum = (pageNum-1)*pageSize;
        int endNum = pageNum*pageSize;
        return portalOrderDao.listOrderInfoByParams( portalOrderQueryParams,startNum,endNum );
    }

    @Override
    public int updateOrderDeleteStatus(Integer id, Integer deleteStatus) {
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andIdEqualTo( id )
                .andDeleteStatusEqualTo( deleteStatus );
        return omsOrderMapper.deleteByExample( example );
    }

    @Override
    public PortalOrderDetailResult findOrderInfoById(Long orderId) {
        return portalOrderDao.findOrderInfoById( orderId );
    }


}
