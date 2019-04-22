package com.shanyuan.model;

import java.io.Serializable;
import java.util.Date;

public class AmsActiveUserApply implements Serializable {
    private Integer id;

    /**
     * 活动id
     *
     * @mbggenerated
     */
    private Integer activeId;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * 报名时间
     *
     * @mbggenerated
     */
    private Date applyTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActiveId() {
        return activeId;
    }

    public void setActiveId(Integer activeId) {
        this.activeId = activeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activeId=").append(activeId);
        sb.append(", userId=").append(userId);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}