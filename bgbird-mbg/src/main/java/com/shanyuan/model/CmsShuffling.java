package com.shanyuan.model;

import java.io.Serializable;
import java.util.Date;

public class CmsShuffling implements Serializable {
    private Integer shuffingId;

    /**
     * 轮播图
     *
     * @mbggenerated
     */
    private String picture;

    /**
     * 商品id
     *
     * @mbggenerated
     */
    private Integer productId;

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
     * 轮播顺序
     *
     * @mbggenerated
     */
    private Integer sort;

    /**
     * 外链地址
     *
     * @mbggenerated
     */
    private String url;

    /**
     * 0->App首页，1->PC首页
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * 上线状态:0->下线,1->上线
     *
     * @mbggenerated
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getShuffingId() {
        return shuffingId;
    }

    public void setShuffingId(Integer shuffingId) {
        this.shuffingId = shuffingId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", shuffingId=").append(shuffingId);
        sb.append(", picture=").append(picture);
        sb.append(", productId=").append(productId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", sort=").append(sort);
        sb.append(", url=").append(url);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}