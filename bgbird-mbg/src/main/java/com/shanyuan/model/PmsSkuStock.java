package com.shanyuan.model;

import java.io.Serializable;

public class PmsSkuStock implements Serializable {
    private Integer id;

    /**
     * 产品id
     *
     * @mbggenerated
     */
    private Integer productId;

    /**
     * 现价，单位分
     *
     * @mbggenerated
     */
    private Integer currentPrice;

    /**
     * 产品价格，单位分
     *
     * @mbggenerated
     */
    private Integer price;

    /**
     * 库存
     *
     * @mbggenerated
     */
    private Integer stock;

    /**
     * 产品属性1
     *
     * @mbggenerated
     */
    private String sp1;

    /**
     * 产品属性2
     *
     * @mbggenerated
     */
    private String sp2;

    /**
     * 产品属性3
     *
     * @mbggenerated
     */
    private String sp3;

    /**
     * 产品属性图
     *
     * @mbggenerated
     */
    private String picture;

    /**
     * 销量
     *
     * @mbggenerated
     */
    private Integer saleCount;

    /**
     * sku编码
     *
     * @mbggenerated
     */
    private String skuCode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Integer currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getSp1() {
        return sp1;
    }

    public void setSp1(String sp1) {
        this.sp1 = sp1;
    }

    public String getSp2() {
        return sp2;
    }

    public void setSp2(String sp2) {
        this.sp2 = sp2;
    }

    public String getSp3() {
        return sp3;
    }

    public void setSp3(String sp3) {
        this.sp3 = sp3;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", currentPrice=").append(currentPrice);
        sb.append(", price=").append(price);
        sb.append(", stock=").append(stock);
        sb.append(", sp1=").append(sp1);
        sb.append(", sp2=").append(sp2);
        sb.append(", sp3=").append(sp3);
        sb.append(", picture=").append(picture);
        sb.append(", saleCount=").append(saleCount);
        sb.append(", skuCode=").append(skuCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}