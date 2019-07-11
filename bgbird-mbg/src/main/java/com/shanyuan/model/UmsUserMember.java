package com.shanyuan.model;

import java.io.Serializable;
import java.util.Date;

public class UmsUserMember implements Serializable {
    private Integer id;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * 会员卡id
     *
     * @mbggenerated
     */
    private String cardCode;

    /**
     * 用户等级id
     *
     * @mbggenerated
     */
    private Integer memberLevelId;

    /**
     * 积分
     *
     * @mbggenerated
     */
    private Integer integration;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public Integer getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(Integer memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
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
        sb.append(", userId=").append(userId);
        sb.append(", cardCode=").append(cardCode);
        sb.append(", memberLevelId=").append(memberLevelId);
        sb.append(", integration=").append(integration);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}