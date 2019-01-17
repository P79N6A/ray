package com.rongyi.easy.mcmc.vo;


import java.io.Serializable;

/**
 * 礼品详情VO
 *
 * @author yaoyiwei
 * @date 2016-11-16
 * @version 1.0
 *
 */
public class GiftDetailVO extends GiftVO implements Serializable {

    private String sn; //礼品编号
    private Integer purchaseCount;//商品的限购数量
    private String deliveryTypes; // 配送方式（1.自提 2.快递）
    private Integer selfType; // 自提类型（1.公共设施 2.指定店铺）
    private String selfAddress; // 自提地点
    private String selfRemark; // 自提地点备注
    private String selfAddressId; // 自提地点id
    private String description;//商品描述
    private Integer selfTakeDays; //自提天数

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(Integer purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public String getDeliveryTypes() {
        return deliveryTypes;
    }

    public void setDeliveryTypes(String deliveryTypes) {
        this.deliveryTypes = deliveryTypes;
    }

    public Integer getSelfType() {
        return selfType;
    }

    public void setSelfType(Integer selfType) {
        this.selfType = selfType;
    }

    public String getSelfAddress() {
        return selfAddress;
    }

    public void setSelfAddress(String selfAddress) {
        this.selfAddress = selfAddress;
    }

    public String getSelfRemark() {
        return selfRemark;
    }

    public void setSelfRemark(String selfRemark) {
        this.selfRemark = selfRemark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSelfAddressId() {
        return selfAddressId;
    }

    public void setSelfAddressId(String selfAddressId) {
        this.selfAddressId = selfAddressId;
    }

    public Integer getSelfTakeDays() {
        return selfTakeDays;
    }

    public void setSelfTakeDays(Integer selfTakeDays) {
        this.selfTakeDays = selfTakeDays;
    }

    @Override
    public String toString() {
        return "GiftDetailVO{" +
                ", sn='" + sn + '\'' +
                ", price=" + this.getPrice() +
                ", purchaseCount=" + purchaseCount +
                ", deliveryTypes='" + deliveryTypes + '\'' +
                ", selfType=" + selfType +
                ", selfAddress='" + selfAddress + '\'' +
                ", selfRemark='" + selfRemark + '\'' +
                ", selfAddressId='" + selfAddressId + '\'' +
             //   ", description='" + description + '\'' +
                ", selfTakeDays=" + selfTakeDays +
                "} " + super.toString();
    }
}