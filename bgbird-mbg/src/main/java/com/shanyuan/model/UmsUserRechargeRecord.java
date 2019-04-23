package com.shanyuan.model;

import java.io.Serializable;
import java.util.Date;

public class UmsUserRechargeRecord implements Serializable {
    private Integer id;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * 金额,单位分
     *
     * @mbggenerated
     */
    private Integer money;

    /**
     * 金额变动类型:0->消费,1->充值
     *
     * @mbggenerated
     */
    private Integer changeType;

    /**
     * 充值状态:0->失败，1->成功
     *
     * @mbggenerated
     */
    private Integer rechargeStatus;

    /**
     * 充值编码
     *
     * @mbggenerated
     */
    private String rechargeNo;

    /**
     * 微信交易流水号
     *
     * @mbggenerated
     */
    private String transactionid;

    /**
     * 金额变动原因
     *
     * @mbggenerated
     */
    private String changeReason;

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

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getChangeType() {
        return changeType;
    }

    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }

    public Integer getRechargeStatus() {
        return rechargeStatus;
    }

    public void setRechargeStatus(Integer rechargeStatus) {
        this.rechargeStatus = rechargeStatus;
    }

    public String getRechargeNo() {
        return rechargeNo;
    }

    public void setRechargeNo(String rechargeNo) {
        this.rechargeNo = rechargeNo;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
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
        sb.append(", money=").append(money);
        sb.append(", changeType=").append(changeType);
        sb.append(", rechargeStatus=").append(rechargeStatus);
        sb.append(", rechargeNo=").append(rechargeNo);
        sb.append(", transactionid=").append(transactionid);
        sb.append(", changeReason=").append(changeReason);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}