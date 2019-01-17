package com.rongyi.easy.activitymanage.vo;

import com.rongyi.easy.mcmc.vo.CommodityBuyerVO;
import com.rongyi.easy.mcmc.vo.CommodityPageBuyerVO;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 特卖的详情
 * Created by lijing on 2015/11/24 21:03
 * .com.rongyi.easy.activitymanage.vo
 * easy-api
 */
public class SaleDetailVO implements Serializable {
    private Integer id;
    private String bannerPic;
    private String replacePic;
    private String name;
    private String subTitle;
    private Long startAt;
    private Long endAt;
    private String shareTitle;
    private String sharePic;
    private String shareDesc;
    private String activityUrl;
    private String contentUrl;
    private List<CommodityBuyerVO> commodityList;
    private Integer nextTemplateRoundId;//null没有下一场字段，0没有下一场，其余有下一场
    private Integer nextId;
    private Integer nextContentId;
    private String nextShareTitle;
    private String nextShareDesc;
    private String nextSharePic;
    private String couponPic;//卡卷图片
    private Integer associateCoupon;//是否关联卡卷
    private String desc;//描述

    private Object reserveField;  //预留字段

    public Object getReserveField() {
        return reserveField;
    }

    public void setReserveField(Object reserveField) {
        this.reserveField = reserveField;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getAssociateCoupon() {
        return associateCoupon;
    }

    public void setAssociateCoupon(Integer associateCoupon) {
        this.associateCoupon = associateCoupon;
    }

    public String getCouponPic() {
        return couponPic;
    }

    public void setCouponPic(String couponPic) {
        this.couponPic = couponPic;
    }

    public String getNextShareTitle() {
        return nextShareTitle;
    }

    public void setNextShareTitle(String nextShareTitle) {
        this.nextShareTitle = nextShareTitle;
    }

    public String getNextShareDesc() {
        return nextShareDesc;
    }

    public void setNextShareDesc(String nextShareDesc) {
        this.nextShareDesc = nextShareDesc;
    }

    public String getNextSharePic() {
        return nextSharePic;
    }

    public void setNextSharePic(String nextSharePic) {
        this.nextSharePic = nextSharePic;
    }

    public String getReplacePic() {
        return replacePic;
    }

    public void setReplacePic(String replacePic) {
        this.replacePic = replacePic;
    }

    public Integer getNextTemplateRoundId() {
        return nextTemplateRoundId;
    }

    public void setNextTemplateRoundId(Integer nextTemplateRoundId) {
        this.nextTemplateRoundId = nextTemplateRoundId;
    }

    public Integer getNextId() {
        return nextId;
    }

    public void setNextId(Integer nextId) {
        this.nextId = nextId;
    }

    public Integer getNextContentId() {
        return nextContentId;
    }

    public void setNextContentId(Integer nextContentId) {
        this.nextContentId = nextContentId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBannerPic() {
        return bannerPic;
    }

    public void setBannerPic(String bannerPic) {
        this.bannerPic = bannerPic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CommodityBuyerVO> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<CommodityBuyerVO> commodityList) {
        this.commodityList = commodityList;
    }

    public String getActivityUrl() {
        return activityUrl;
    }

    public void setActivityUrl(String activityUrl) {
        this.activityUrl = activityUrl;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Long getStartAt() {
        return startAt;
    }

    public void setStartAt(Long startAt) {
        this.startAt = startAt;
    }

    public Long getEndAt() {
        return endAt;
    }

    public void setEndAt(Long endAt) {
        this.endAt = endAt;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public String getSharePic() {
        return sharePic;
    }

    public void setSharePic(String sharePic) {
        this.sharePic = sharePic;
    }

    public String getShareDesc() {
        return shareDesc;
    }

    public void setShareDesc(String shareDesc) {
        this.shareDesc = shareDesc;
    }




    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("bannerPic", bannerPic)
                .append("name", name)
                .append("subTitle", subTitle)
                .append("startAt", startAt)
                .append("endAt", endAt)
                .append("shareTitle", shareTitle)
                .append("sharePic", sharePic)
                .append("shareDesc", shareDesc)
                .append("replacePic", replacePic)
                .append("activityUrl", activityUrl)
                .append("contentUrl", contentUrl)
                .append("commodityList", commodityList)
                .append("nextActTemplateId",nextTemplateRoundId)
                .append("nextId",nextId)
                .append("nextContentId",nextContentId)
                .append("nextShareDesc", nextShareDesc)
                .append("nextSharePic",nextSharePic)
                .append("nextSharePic",nextSharePic)
                .append("couponPic", couponPic)
                .append("associateCoupon", associateCoupon)
                .append("desc", desc)
                .toString();
    }
}