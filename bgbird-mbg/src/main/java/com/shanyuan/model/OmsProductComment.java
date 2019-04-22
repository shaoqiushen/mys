package com.shanyuan.model;

import java.io.Serializable;
import java.util.Date;

public class OmsProductComment implements Serializable {
    private Integer id;

    /**
     * 商品id
     *
     * @mbggenerated
     */
    private Integer productId;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * 用户头像
     *
     * @mbggenerated
     */
    private String avartalUrl;

    /**
     * 用户昵称
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     * 评价内容
     *
     * @mbggenerated
     */
    private String commentContent;

    /**
     * 评价星级: 1-5颗星
     *
     * @mbggenerated
     */
    private Boolean commentStar;

    /**
     * 是否显示在手机端:0->否,1->是
     *
     * @mbggenerated
     */
    private Boolean isShow;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAvartalUrl() {
        return avartalUrl;
    }

    public void setAvartalUrl(String avartalUrl) {
        this.avartalUrl = avartalUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Boolean getCommentStar() {
        return commentStar;
    }

    public void setCommentStar(Boolean commentStar) {
        this.commentStar = commentStar;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", userId=").append(userId);
        sb.append(", avartalUrl=").append(avartalUrl);
        sb.append(", nickname=").append(nickname);
        sb.append(", commentContent=").append(commentContent);
        sb.append(", commentStar=").append(commentStar);
        sb.append(", isShow=").append(isShow);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}