package com.shanyuan.model;

import java.io.Serializable;
import java.util.Date;

public class AmsActive implements Serializable {
    private Integer id;

    /**
     * 活动名称
     *
     * @mbggenerated
     */
    private String activeName;

    /**
     * 活动开启时间
     *
     * @mbggenerated
     */
    private Date activeTime;

    /**
     * 活动标题
     *
     * @mbggenerated
     */
    private String activeTitle;

    /**
     * 活动介绍图片
     *
     * @mbggenerated
     */
    private String activePicture;

    /**
     * 是否启用:0->否,1->是
     *
     * @mbggenerated
     */
    private Integer isEnable;

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

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public String getActiveTitle() {
        return activeTitle;
    }

    public void setActiveTitle(String activeTitle) {
        this.activeTitle = activeTitle;
    }

    public String getActivePicture() {
        return activePicture;
    }

    public void setActivePicture(String activePicture) {
        this.activePicture = activePicture;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
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
        sb.append(", activeName=").append(activeName);
        sb.append(", activeTime=").append(activeTime);
        sb.append(", activeTitle=").append(activeTitle);
        sb.append(", activePicture=").append(activePicture);
        sb.append(", isEnable=").append(isEnable);
        sb.append(", integration=").append(integration);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}