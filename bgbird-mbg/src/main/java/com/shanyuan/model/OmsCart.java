package com.shanyuan.model;

import java.io.Serializable;
import java.util.Date;

public class OmsCart implements Serializable {
    private Integer id;

    /**
     * 商品id
     *
     * @mbggenerated
     */
    private Integer productId;

    /**
     * 参数表id
     *
     * @mbggenerated
     */
    private Integer productAttrValueId;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 删除状态:0->否，1->是
     *
     * @mbggenerated
     */
    private Boolean deleteStatus;

    /**
     * 购买数量
     *
     * @mbggenerated
     */
    private Integer buyCount;

    /**
     * 规格描述,多个以逗号分隔
     *
     * @mbggenerated
     */
    private String specDesc;

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

    public Integer getProductAttrValueId() {
        return productAttrValueId;
    }

    public void setProductAttrValueId(Integer productAttrValueId) {
        this.productAttrValueId = productAttrValueId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public String getSpecDesc() {
        return specDesc;
    }

    public void setSpecDesc(String specDesc) {
        this.specDesc = specDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", productAttrValueId=").append(productAttrValueId);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", buyCount=").append(buyCount);
        sb.append(", specDesc=").append(specDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}