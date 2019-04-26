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
    private Date beginTime;

    /**
     * 活动简介
     *
     * @mbggenerated
     */
    private String activeIntroduce;

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

    /**
     * 活动结束时间
     *
     * @mbggenerated
     */
    private Date endTime;

    /**
     * 删除标志:0->否,1->是
     *
     * @mbggenerated
     */
    private Integer deleteStatus;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 活动标题
     *
     * @mbggenerated
     */
    private String activeTitle;

    /**
     * 活动内容
     *
     * @mbggenerated
     */
    private String activeContent;

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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getActiveIntroduce() {
        return activeIntroduce;
    }

    public void setActiveIntroduce(String activeIntroduce) {
        this.activeIntroduce = activeIntroduce;
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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getActiveTitle() {
        return activeTitle;
    }

    public void setActiveTitle(String activeTitle) {
        this.activeTitle = activeTitle;
    }

    public String getActiveContent() {
        return activeContent;
    }

    public void setActiveContent(String activeContent) {
        this.activeContent = activeContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activeName=").append(activeName);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", activeIntroduce=").append(activeIntroduce);
        sb.append(", activePicture=").append(activePicture);
        sb.append(", isEnable=").append(isEnable);
        sb.append(", integration=").append(integration);
        sb.append(", endTime=").append(endTime);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", activeTitle=").append(activeTitle);
        sb.append(", activeContent=").append(activeContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}