package com.shanyuan.model;

import java.io.Serializable;

public class PmsProductCategory implements Serializable {
    private Integer categoryId;

    /**
     * 分类名称
     *
     * @mbggenerated
     */
    private String categoryName;

    /**
     * 排序，值越小越靠前
     *
     * @mbggenerated
     */
    private Integer sort;

    /**
     * 描述
     *
     * @mbggenerated
     */
    private String description;

    /**
     * 是否显示:0->否，1->是
     *
     * @mbggenerated
     */
    private Integer showStatus;

    private static final long serialVersionUID = 1L;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", sort=").append(sort);
        sb.append(", description=").append(description);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}