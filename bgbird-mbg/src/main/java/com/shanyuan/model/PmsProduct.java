package com.shanyuan.model;

import java.io.Serializable;
import java.util.Date;

public class PmsProduct implements Serializable {
    private Integer id;

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
    private Integer deleteStatus;

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
     * 促销价，单位分
     *
     * @mbggenerated
     */
    private Integer promotionPrice;

    /**
     * 赠送的积分
     *
     * @mbggenerated
     */
    private Integer giftPoint;

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

    /**
     * 商品促销开始时间
     *
     * @mbggenerated
     */
    private Date promotionStartTime;

    /**
     * 商品促销结束时间
     *
     * @mbggenerated
     */
    private Date promotionEndTime;

    /**
     * 促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
     *
     * @mbggenerated
     */
    private Integer promotionType;

    /**
     * 活动限购数量
     *
     * @mbggenerated
     */
    private Integer promotionPerLimit;

    /**
     * 分类名称
     *
     * @mbggenerated
     */
    private String productCategoryName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
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

    public Integer getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(Integer promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getGiftPoint() {
        return giftPoint;
    }

    public void setGiftPoint(Integer giftPoint) {
        this.giftPoint = giftPoint;
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

    public Date getPromotionStartTime() {
        return promotionStartTime;
    }

    public void setPromotionStartTime(Date promotionStartTime) {
        this.promotionStartTime = promotionStartTime;
    }

    public Date getPromotionEndTime() {
        return promotionEndTime;
    }

    public void setPromotionEndTime(Date promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public Integer getPromotionPerLimit() {
        return promotionPerLimit;
    }

    public void setPromotionPerLimit(Integer promotionPerLimit) {
        this.promotionPerLimit = promotionPerLimit;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
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
        sb.append(", promotionPrice=").append(promotionPrice);
        sb.append(", giftPoint=").append(giftPoint);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", promotionStartTime=").append(promotionStartTime);
        sb.append(", promotionEndTime=").append(promotionEndTime);
        sb.append(", promotionType=").append(promotionType);
        sb.append(", promotionPerLimit=").append(promotionPerLimit);
        sb.append(", productCategoryName=").append(productCategoryName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}