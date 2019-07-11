package com.shanyuan.bgbirdportal.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shanyuan.bgbirdportal.dao.PortalOrderDao;
import com.shanyuan.bgbirdportal.dao.PortalProductDao;
import com.shanyuan.bgbirdportal.dao.PortalProductSkuDao;
import com.shanyuan.bgbirdportal.dto.*;
import com.shanyuan.bgbirdportal.service.PortalOrderService;
import com.shanyuan.bgbirdportal.service.PortalUmsUserService;
import com.shanyuan.bgbirdportal.service.PortalUserAddressService;
import com.shanyuan.bgbirdportal.service.PromotionService;
import com.shanyuan.domain.CommonResult;
import com.shanyuan.domain.PayInfo;
import com.shanyuan.domain.PrePayResult;
import com.shanyuan.exception.BussinessException;
import com.shanyuan.factory.SnowFlakeFactory;
import com.shanyuan.mapper.*;
import com.shanyuan.model.*;
import com.shanyuan.utils.HttpUtils;
import com.shanyuan.utils.MyDateUtil;
import com.shanyuan.utils.PrimaryGenerater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


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

    @Autowired
    OmsTakeMealNoMapper takeMealNoMapper;

    @Autowired
    PortalUmsUserService portalUmsUserService;

    @Autowired
    OmsOrderPrepayMapper omsOrderPrepayMapper;


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
                        detail.setCommentStatus( 0 );
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
            omsOrder.setTakeMealNo( createTakeMealNo() );//生成取餐流水号//每天重置
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
                omsOrder.setReceiverAddress(  umsUserReceiveAddresses.get( 0 ).getAddressArea().replace( ",","" ) +
                        umsUserReceiveAddresses.get( 0 ).getAddressDetail().replace( ",","" ) );
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

        //根据userid 查询用户的openid
        UmsUser userInfo=portalUmsUserService.getUserInfo( portalOrderParams.getUserId() );

        //调用支付
        PayInfo payInfo = new PayInfo();
        payInfo.setOut_trade_no( orderId +"");
        payInfo.setOpenid( userInfo.getOpenid() );
        payInfo.setTrade_type( "JSAPI" );
        payInfo.setNotify_url( "http://www.shanyuankj.cn/bgbird-portal/order/notify" );
        payInfo.setBody( portalOrderParams.getBody() );
        payInfo.setSpbill_create_ip( portalOrderParams.getSpbillCreateIp() );
        payInfo.setTotal_fee( 1+"" );
        PrePayResult prePayResult=this.payToWechat( payInfo );
        if(prePayResult.getStatus() != 1){
            return new CommonResult().failed( "下单失败"+prePayResult.getMsg() );
        }else{
            //预支付信息入库

            //成功
            OmsOrderPrepay omsOrderPrepay = new OmsOrderPrepay();
            omsOrderPrepay.setApp( "77903002" );
            omsOrderPrepay.setBody( payInfo.getBody() );
            omsOrderPrepay.setOpenid( payInfo.getOpenid() );
            omsOrderPrepay.setOutTradeNo( payInfo.getOut_trade_no() );
            omsOrderPrepay.setResultCode( 0 );
            omsOrderPrepay.setSignType( prePayResult.getData().getSignType() );
            omsOrderPrepay.setPaySign( prePayResult.getData().getPaySign() );
            omsOrderPrepay.setTimeStamp( prePayResult.getData().getTimeStamp() );
            omsOrderPrepay.setTotalFee( payInfo.getTotal_fee() );
            omsOrderPrepay.setPrepayId( prePayResult.getData().getPackage() );
            omsOrderPrepay.setNoncestr( prePayResult.getData().getNonceStr() );
            omsOrderPrepay.setUserId( portalOrderParams.getUserId() );
            omsOrderPrepayMapper.insert( omsOrderPrepay );
        }
        prePayResult.setOrderId( orderId );
        return new CommonResult().success( "下单成功",prePayResult);
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

    @Override
    public OmsOrder getOrder(Long orderId) {
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andOrderIdEqualTo( orderId );
        List <OmsOrder> omsOrders=omsOrderMapper.selectByExample( example );
        if(omsOrders.size() > 0){
            return omsOrders.get( 0 );
        }
        return null;
    }

    @Override
    public int updateOrderStatus(Long orderId) {
        OmsOrder omsOrder = new OmsOrder();
        //订单状态：0->待付款；1->已支付，待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
        omsOrder.setOrderStatus( 1 );
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andOrderIdEqualTo( orderId );
        return omsOrderMapper.updateByExampleSelective( omsOrder,example );
    }

    @Override
    public int updatePrePayStatus(String outTradeNo) {
        OmsOrderPrepay omsOrderPrepay = new OmsOrderPrepay();
        omsOrderPrepay.setResultCode( 1 );
        OmsOrderPrepayExample example = new OmsOrderPrepayExample();
        example.createCriteria().andOutTradeNoEqualTo( outTradeNo );
        return omsOrderPrepayMapper.updateByExampleSelective( omsOrderPrepay,example );
    }

    @Override
    public OmsOrderPrepay getPayInfo(String orderId) {
        OmsOrderPrepayExample example = new OmsOrderPrepayExample();
        example.createCriteria().andOutTradeNoEqualTo( orderId );
        return omsOrderPrepayMapper.selectByExample( example ).get( 0 );
    }


    /*生成取餐流水号/每天重置/目前支持每天最多生成9999个*/
    private synchronized String createTakeMealNo(){
        OmsTakeMealNoExample example = new OmsTakeMealNoExample();
        example.setOrderByClause( "id desc" );
        example.createCriteria().andCreateTimeEqualTo( MyDateUtil.getShortNowTime() );
        //获取上次的号
        List <OmsTakeMealNo> omsTakeMealNos=takeMealNoMapper.selectByExample( example );
        String takeMealNo = "T0000";
        if(omsTakeMealNos.size() == 0){
        }else{
            takeMealNo=omsTakeMealNos.get( 0 ).getTakeMealNo();
        }
        takeMealNo = "T"+PrimaryGenerater.getInstance().generaterNextNumber( takeMealNo );
        OmsTakeMealNo omsTakeMealNo = new OmsTakeMealNo();
        omsTakeMealNo.setCreateTime( MyDateUtil.getShortNowTime() );
        omsTakeMealNo.setTakeMealNo( takeMealNo );
        takeMealNoMapper.insert( omsTakeMealNo );
        return takeMealNo;
    }


    /**
     * descrition: 发起支付
     * create_user: shenshaoqiu
     * create_date: 2019/1/18
     * create_time: 9:17
     * param:
     * return:
     **/
    private PrePayResult payToWechat(PayInfo payInfo) {
        PrePayResult prePayCostVO = new PrePayResult();

        String url="https://www.shanyuankj.cn/wechat/pay/unifiedorderbyisp";

        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append( "app="+"77903002"+"&" );
        stringBuffer.append( "body=" + payInfo.getBody() + "&" );
        stringBuffer.append( "out_trade_no=" + payInfo.getOut_trade_no() + "&" );
        stringBuffer.append( "total_fee=" + payInfo.getTotal_fee() + "&" );
        stringBuffer.append( "notify_url=" + payInfo.getNotify_url() + "&" );
        stringBuffer.append( "trade_type="+payInfo.getTrade_type()+"&" );
        stringBuffer.append( "sub_mch="+"77904201"+"&" );
        stringBuffer.append( "mch="+"77903201"+"&" );
        stringBuffer.append( "sub_app="+ "77904101"+"&");
        stringBuffer.append( "spbill_create_ip="+payInfo.getSpbill_create_ip() +"&");
        stringBuffer.append( "sub_openid=" + payInfo.getOpenid() );

        String response=HttpUtils.getResponse( url, stringBuffer.toString() );
        //调用支付接口
        prePayCostVO = JSONObject.parseObject( response,PrePayResult.class );


        return prePayCostVO;
    }

}
