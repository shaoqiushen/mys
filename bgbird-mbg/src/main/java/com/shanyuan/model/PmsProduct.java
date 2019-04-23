package com.shanyuan.model;

import java.io.Serializable;
import java.util.Date;

public class PmsProduct implements Serializable {
    private Integer productId;

    /**
     * 商品分类id
     *
     * @mbggenerated
     */
    private Integer productCategoryId;

    /**
     * 商品名称
     *
     * @mbggenerated
     */
    private String productName;

    /**
     * 商品介绍
     *
     * @mbggenerated
     */
    private String productIntroduce;

    /**
     * 商品正文图
     *
     * @mbggenerated
     */
    private String picture;

    /**
     * 商品详情图
     *
     * @mbggenerated
     */
    private String pictuteDetail;

    /**
     * 删除状态：0->未删除；1->已删除
     *
     * @mbggenerated
     */
    private Boolean deleteStatus;

    /**
     * 上架状态：0->下架；1->上架
     *
     * @mbggenerated
     */
    private Integer publishStatus;

    /**
     * 热销状态: 0->否;1->是
     *
     * @mbggenerated
     */
    private Integer hotStatus;

    /**
     * 兑换状态:0->否;1->是
     *
     * @mbggenerated
     */
    private Integer exchangeStatus;

    /**
     * 销量
     *
     * @mbggenerated
     */
    private Integer saleAmount;

    /**
     * 原价，单位分
     *
     * @mbggenerated
     */
    private Integer price;

    /**
     * 现价，单位分
     *
     * @mbggenerated
     */
    private Integer currentPrice;

    /**
     * 赠送的积分
     *
     * @mbggenerated
     */
    private Integer giftPoint;

    /**
     * 库存
     *
     * @mbggenerated
     */
    private Integer stock;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductIntroduce() {
        return productIntroduce;
    }

    public void setProductIntroduce(String productIntroduce) {
        this.productIntroduce = productIntroduce;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPictuteDetail() {
        return pictuteDetail;
    }

    public void setPictuteDetail(String pictuteDetail) {
        this.pictuteDetail = pictuteDetail;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getHotStatus() {
        return hotStatus;
    }

    public void setHotStatus(Integer hotStatus) {
        this.hotStatus = hotStatus;
    }

    public Integer getExchangeStatus() {
        return exchangeStatus;
    }

    public void setExchangeStatus(Integer exchangeStatus) {
        this.exchangeStatus = exchangeStatus;
    }

    public Integer getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(Integer saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Integer currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Integer getGiftPoint() {
        return giftPoint;
    }

    public void setGiftPoint(Integer giftPoint) {
        this.giftPoint = giftPoint;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", productCategoryId=").append(productCategoryId);
        sb.append(", productName=").append(productName);
        sb.append(", productIntroduce=").append(productIntroduce);
        sb.append(", picture=").append(picture);
        sb.append(", pictuteDetail=").append(pictuteDetail);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", publishStatus=").append(publishStatus);
        sb.append(", hotStatus=").append(hotStatus);
        sb.append(", exchangeStatus=").append(exchangeStatus);
        sb.append(", saleAmount=").append(saleAmount);
        sb.append(", price=").append(price);
        sb.append(", currentPrice=").append(currentPrice);
        sb.append(", giftPoint=").append(giftPoint);
        sb.append(", stock=").append(stock);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}