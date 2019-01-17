package com.rongyi.easy.content_v2.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Created by lijing on 2015/10/21.
 */
public class QuickEntryNewVO implements Serializable {
    private String quickPics; // 快捷入口图标，多个衣逗号分隔。例如："快捷入口图标1,快捷入口图标2"
    /**
     * 商场    1
    * 店铺    2
     *文章    7
    * 商品    4
    * 代金券  5
    * 直播    12（new）
     *特卖    13（new）
     * 外链   9
   *快捷入口类型
     */
    private String quickType;
    private String quickTypeVal;//类型值
    private String title;//标题

    private String shareTitle;//分享标题
    private String shareContent;//分享内容
    private String sharePic;//分享图片
    private String appTitle;//页面标题
    private String picUrl2;

    public String getPicUrl2() {
        return picUrl2;
    }

    public void setPicUrl2(String picUrl2) {
        this.picUrl2 = picUrl2;
    }

    public String getQuickPics() {
        return quickPics;
    }

    public void setQuickPics(String quickPics) {
        this.quickPics = quickPics;
    }

    public String getQuickType() {
        return quickType;
    }

    public void setQuickType(String quickType) {
        this.quickType = quickType;
    }

    public String getQuickTypeVal() {
        return quickTypeVal;
    }

    public void setQuickTypeVal(String quickTypeVal) {
        this.quickTypeVal = quickTypeVal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public String getShareContent() {
        return shareContent;
    }

    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }

    public String getSharePic() {
        return sharePic;
    }

    public void setSharePic(String sharePic) {
        this.sharePic = sharePic;
    }

    public String getAppTitle() {
        return appTitle;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("quickPics", quickPics)
                .append("quickType", quickType)
                .append("quickTypeVal", quickTypeVal)
                .append("title", title)
                .append("shareTitle", shareTitle)
                .append("shareContent", shareContent)
                .append("sharePic", sharePic)
                .append("appTitle", appTitle)
                .append("picUrl2",picUrl2)
                .toString();
    }
}