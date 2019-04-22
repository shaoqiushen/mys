package com.shanyuan.model;

import java.io.Serializable;

public class PmsProductAttributeValue implements Serializable {
    private Integer id;

    /**
     * 商品id
     *
     * @mbggenerated
     */
    private Integer productId;

    /**
     * 商品属性参数表id
     *
     * @mbggenerated
     */
    private Integer productAttributeId;

    /**
     * 属性参数值
     *
     * @mbggenerated
     */
    private String value;

    /**
     * 价格
     *
     * @mbggenerated
     */
    private Integer price;

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

    public Integer getProductAttributeId() {
        return productAttributeId;
    }

    public void setProductAttributeId(Integer productAttributeId) {
        this.productAttributeId = productAttributeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", productAttributeId=").append(productAttributeId);
        sb.append(", value=").append(value);
        sb.append(", price=").append(price);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}