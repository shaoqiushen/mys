package com.shanyuan.bgbirdportal.dto;

import lombok.Data;

import java.util.Date;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-08 16:24
 * <p>
 * desc
 **/
@Data
public class PortalOrderResult {

    /**
     * 优惠券id
     *
     * @mbggenerated
     */
    private Long couponId;

    /**
     * 订单编号
     *
     * @mbggenerated
     */
    private Long orderId;

    /**
     * 订单总金额
     *
     * @mbggenerated
     */
    private Integer totalAmount;

    /**
     * 实际支付金额
     *
     * @mbggenerated
     */
    private Integer payAmount;

    /**
     * 运费金额
     *
     * @mbggenerated
     */
    private Integer freightAmount;

    /**
     * 促销优惠金额（促销价、满减、阶梯价）
     *
     * @mbggenerated
     */
    private Integer promotionAmount;

    /**
     * 优惠券抵扣金额
     *
     * @mbggenerated
     */
    private Integer couponAmount;

    /**
     * 支付方式:0->未支付,1->微信支付,2->支付宝支付
     *
     * @mbggenerated
     */
    private Integer payType;


    /**
     * 订单状态：0->待付款；1->已支付，待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     *
     * @mbggenerated
     */
    private Integer orderStatus;


    /**
     * 获得的积分
     *
     * @mbggenerated
     */
    private Integer integration;


    /**
     * 订单备注
     *
     * @mbggenerated
     */
    private String notes;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 确认收货:0->否，1->是
     *
     * @mbggenerated
     */
    private Integer confirmStatus;

    /**
     * 送餐方式:0->堂吃，1->配送
     *
     * @mbggenerated
     */
    private Integer eatType;

    /*取餐号*/
    private String takeMealNo;
    /*评价状态0否，1是*/
    private Integer commentStatus;
}
