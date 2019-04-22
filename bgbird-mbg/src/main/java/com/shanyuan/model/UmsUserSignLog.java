package com.shanyuan.model;

import java.io.Serializable;
import java.util.Date;

public class UmsUserSignLog implements Serializable {
    private Integer id;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * 签到时间
     *
     * @mbggenerated
     */
    private Date signTime;

    /**
     * 获得的积分
     *
     * @mbggenerated
     */
    private Integer integration;

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

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", signTime=").append(signTime);
        sb.append(", integration=").append(integration);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}