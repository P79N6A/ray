package com.rongyi.easy.code;

import java.io.Serializable;

/**
 * Created by shaozhou on 2016/7/4.
 * 邀请码明细列表查询参数
 */
public class InviteSearchParam implements Serializable {
    private String hannelId;//促销推广码id
    private String userPhone;//注册账号
    private String userNickName;//用户昵称
    private String inviteAccount;//邀请人账号
    private Integer status;//是否领到促销码(全部 -1 是1 否0)
    private String registerBeginTime;//注册开始时间
    private String registerEndTime;//注册结束时间
    private int currentPage;//当前页（从1开始）
    private int pageSize;//每页显示数量（默认10）
    private int startIndex = 0;
    private String exchangeBeginTime;//兑换开始时间
    private String exchangeEndTime;//兑换结束时间
    private Integer hannelsType;// 0:渠道邀请码；1：红包密码

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("InviteSearchParam{");
        sb.append("hannelId='").append(hannelId).append('\'');
        sb.append(", userPhone='").append(userPhone).append('\'');
        sb.append(", userNickName='").append(userNickName).append('\'');
        sb.append(", inviteAccount='").append(inviteAccount).append('\'');
        sb.append(", status=").append(status);
        sb.append(", registerBeginTime='").append(registerBeginTime).append('\'');
        sb.append(", registerEndTime='").append(registerEndTime).append('\'');
        sb.append(", currentPage=").append(currentPage);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", startIndex=").append(startIndex);
        sb.append(", exchangeBeginTime='").append(exchangeBeginTime).append('\'');
        sb.append(", exchangeEndTime='").append(exchangeEndTime).append('\'');
        sb.append(", hannelsType=").append(hannelsType);
        sb.append('}');
        return sb.toString();
    }

    public Integer getHannelsType() {
        return hannelsType;
    }

    public void setHannelsType(Integer hannelsType) {
        this.hannelsType = hannelsType;
    }

    public String getHannelId() {
        return hannelId;
    }

    public void setHannelId(String hannelId) {
        this.hannelId = hannelId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getInviteAccount() {
        return inviteAccount;
    }

    public void setInviteAccount(String inviteAccount) {
        this.inviteAccount = inviteAccount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getRegisterBeginTime() {
        return registerBeginTime;
    }

    public void setRegisterBeginTime(String registerBeginTime) {
        this.registerBeginTime = registerBeginTime;
    }

    public String getRegisterEndTime() {
        return registerEndTime;
    }

    public void setRegisterEndTime(String registerEndTime) {
        this.registerEndTime = registerEndTime;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public String getExchangeBeginTime() {
        return exchangeBeginTime;
    }

    public void setExchangeBeginTime(String exchangeBeginTime) {
        this.exchangeBeginTime = exchangeBeginTime;
    }

    public String getExchangeEndTime() {
        return exchangeEndTime;
    }

    public void setExchangeEndTime(String exchangeEndTime) {
        this.exchangeEndTime = exchangeEndTime;
    }

}