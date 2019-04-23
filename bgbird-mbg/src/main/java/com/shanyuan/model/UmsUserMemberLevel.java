package com.shanyuan.model;

import java.io.Serializable;

public class UmsUserMemberLevel implements Serializable {
    private Integer id;

    /**
     * 等级名称
     *
     * @mbggenerated
     */
    private String levelName;

    /**
     * 等级所需积分
     *
     * @mbggenerated
     */
    private Integer growthPoint;

    /**
     * 是否为默认等级:0->否,1->是
     *
     * @mbggenerated
     */
    private Integer defaultStatus;

    /**
     * 是否有生日特权:0->否,1->是
     *
     * @mbggenerated
     */
    private Integer priviledgeBirthday;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getGrowthPoint() {
        return growthPoint;
    }

    public void setGrowthPoint(Integer growthPoint) {
        this.growthPoint = growthPoint;
    }

    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public Integer getPriviledgeBirthday() {
        return priviledgeBirthday;
    }

    public void setPriviledgeBirthday(Integer priviledgeBirthday) {
        this.priviledgeBirthday = priviledgeBirthday;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", levelName=").append(levelName);
        sb.append(", growthPoint=").append(growthPoint);
        sb.append(", defaultStatus=").append(defaultStatus);
        sb.append(", priviledgeBirthday=").append(priviledgeBirthday);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}