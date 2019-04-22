package com.shanyuan.model;

import java.io.Serializable;

public class OmsOrderDetail implements Serializable {
    private Integer id;

    /**
     * 订单id
     *
     * @mbggenerated
     */
    private Long orderId;

    /**
     * 商品id
     *
     * @mbggenerated
     */
    private Integer productId;

    /**
     * 商品名称
     *
     * @mbggenerated
     */
    private String productName;

    /**
     * 商品销售价格，单位分
     *
     * @mbggenerated
     */
    private Integer price;

    /**
     * 购买数量
     *
     * @mbggenerated
     */
    private Integer buyCount;

    /**
     * 商品促销名称
     *
     * @mbggenerated
     */
    private String promotionName;

    /**
     * 商品促销分解金额，单位分
     *
     * @mbggenerated
     */
    private Integer promotionAmount;

    /**
     * 优惠券分解金额，单位分
     *
     * @mbggenerated
     */
    private Integer couponAmount;

    /**
     * 该商品经过优惠后的分解金额
     *
     * @mbggenerated
     */
    private Integer realAmount;

    /**
     * 获得的积分
     *
     * @mbggenerated
     */
    private Integer giftIntegration;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public Integer getPromotionAmount() {
        return promotionAmount;
    }

    public void setPromotionAmount(Integer promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public Integer getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(Integer couponAmount) {
        this.couponAmount = couponAmount;
    }

    public Integer getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(Integer realAmount) {
        this.realAmount = realAmount;
    }

    public Integer getGiftIntegration() {
        return giftIntegration;
    }

    public void setGiftIntegration(Integer giftIntegration) {
        this.giftIntegration = giftIntegration;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", price=").append(price);
        sb.append(", buyCount=").append(buyCount);
        sb.append(", promotionName=").append(promotionName);
        sb.append(", promotionAmount=").append(promotionAmount);
        sb.append(", couponAmount=").append(couponAmount);
        sb.append(", realAmount=").append(realAmount);
        sb.append(", giftIntegration=").append(giftIntegration);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}