package com.shanyuan.model;

import java.io.Serializable;

public class AmsActiveDetail implements Serializable {
    private Integer id;

    /**
     * 活动id
     *
     * @mbggenerated
     */
    private Integer activeId;

    /**
     * 活动详情图片
     *
     * @mbggenerated
     */
    private String activeDetailPicture;

    /**
     * 活动日期
     *
     * @mbggenerated
     */
    private String activeDate;

    /**
     * 活动时间区间
     *
     * @mbggenerated
     */
    private String activeTimeInterval;

    /**
     * 活动地点
     *
     * @mbggenerated
     */
    private String activeAddress;

    /**
     * 推荐人群,多个以 / 分隔
     *
     * @mbggenerated
     */
    private String recommendPeople;

    /**
     * 福利奖品
     *
     * @mbggenerated
     */
    private String welfare;

    /**
     * 报名须知,多个以 | 分隔
     *
     * @mbggenerated
     */
    private String applyNeedKnow;

    /**
     * 活动介绍
     *
     * @mbggenerated
     */
    private String activeIntroduce;

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

    public String getActiveDetailPicture() {
        return activeDetailPicture;
    }

    public void setActiveDetailPicture(String activeDetailPicture) {
        this.activeDetailPicture = activeDetailPicture;
    }

    public String getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    public String getActiveTimeInterval() {
        return activeTimeInterval;
    }

    public void setActiveTimeInterval(String activeTimeInterval) {
        this.activeTimeInterval = activeTimeInterval;
    }

    public String getActiveAddress() {
        return activeAddress;
    }

    public void setActiveAddress(String activeAddress) {
        this.activeAddress = activeAddress;
    }

    public String getRecommendPeople() {
        return recommendPeople;
    }

    public void setRecommendPeople(String recommendPeople) {
        this.recommendPeople = recommendPeople;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getApplyNeedKnow() {
        return applyNeedKnow;
    }

    public void setApplyNeedKnow(String applyNeedKnow) {
        this.applyNeedKnow = applyNeedKnow;
    }

    public String getActiveIntroduce() {
        return activeIntroduce;
    }

    public void setActiveIntroduce(String activeIntroduce) {
        this.activeIntroduce = activeIntroduce;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activeId=").append(activeId);
        sb.append(", activeDetailPicture=").append(activeDetailPicture);
        sb.append(", activeDate=").append(activeDate);
        sb.append(", activeTimeInterval=").append(activeTimeInterval);
        sb.append(", activeAddress=").append(activeAddress);
        sb.append(", recommendPeople=").append(recommendPeople);
        sb.append(", welfare=").append(welfare);
        sb.append(", applyNeedKnow=").append(applyNeedKnow);
        sb.append(", activeIntroduce=").append(activeIntroduce);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}