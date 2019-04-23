package com.shanyuan.model;

import java.io.Serializable;

public class PmsProductAttribute implements Serializable {
    private Integer id;

    /**
     * 属性分类表id
     *
     * @mbggenerated
     */
    private Integer attrCategoryId;

    /**
     * 属性名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 可选值列表，以逗号分隔
     *
     * @mbggenerated
     */
    private String inputList;

    /**
     * 排序，值越小越靠前
     *
     * @mbggenerated
     */
    private Integer sort;

    /**
     * 属性的类型；0->规格；1->参数
     *
     * @mbggenerated
     */
    private Integer attrType;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttrCategoryId() {
        return attrCategoryId;
    }

    public void setAttrCategoryId(Integer attrCategoryId) {
        this.attrCategoryId = attrCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInputList() {
        return inputList;
    }

    public void setInputList(String inputList) {
        this.inputList = inputList;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getAttrType() {
        return attrType;
    }

    public void setAttrType(Integer attrType) {
        this.attrType = attrType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", attrCategoryId=").append(attrCategoryId);
        sb.append(", name=").append(name);
        sb.append(", inputList=").append(inputList);
        sb.append(", sort=").append(sort);
        sb.append(", attrType=").append(attrType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}