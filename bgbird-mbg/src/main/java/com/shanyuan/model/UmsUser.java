package com.shanyuan.model;

import java.io.Serializable;
import java.util.Date;

public class UmsUser implements Serializable {
    private Integer id;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * 用户昵称
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     * 微信用户openid
     *
     * @mbggenerated
     */
    private String openid;

    /**
     * 微信账号
     *
     * @mbggenerated
     */
    private String wechatId;

    /**
     * 微信头像
     *
     * @mbggenerated
     */
    private String avatarUrl;

    /**
     * 用户联系电话
     *
     * @mbggenerated
     */
    private String tellPhone;

    /**
     * 性别：0->未知；1->男；2->女
     *
     * @mbggenerated
     */
    private Integer gender;

    /**
     * 所在城市
     *
     * @mbggenerated
     */
    private String city;

    /**
     * 生日
     *
     * @mbggenerated
     */
    private String birthday;

    /**
     * 账号启用状态：0->禁用,1->启用
     *
     * @mbggenerated
     */
    private Integer actStatus;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 0->普通用户,1->会员
     *
     * @mbggenerated
     */
    private Integer userStatus;

    private String unionid;

    /**
     * 省份
     *
     * @mbggenerated
     */
    private String province;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getTellPhone() {
        return tellPhone;
    }

    public void setTellPhone(String tellPhone) {
        this.tellPhone = tellPhone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getActStatus() {
        return actStatus;
    }

    public void setActStatus(Integer actStatus) {
        this.actStatus = actStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", nickname=").append(nickname);
        sb.append(", openid=").append(openid);
        sb.append(", wechatId=").append(wechatId);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", tellPhone=").append(tellPhone);
        sb.append(", gender=").append(gender);
        sb.append(", city=").append(city);
        sb.append(", birthday=").append(birthday);
        sb.append(", actStatus=").append(actStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", unionid=").append(unionid);
        sb.append(", province=").append(province);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}