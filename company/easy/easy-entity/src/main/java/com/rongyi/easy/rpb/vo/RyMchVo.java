package com.rongyi.easy.rpb.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 商户配置信息
 * conan
 * 2017/2/9 11:09
 **/
public class RyMchVo implements Serializable {

    private static final long serialVersionUID = -4572796585429693594L;
    private String ryMchId;//容易网商户号

    private String ryMchName;//容易商户名称

    private String ryAppId;//容易网应用号

    private Byte source;//来源(0:容易逛,1:微信,2:终端屏,3:福利pos,4:开放平台)

    private Byte orgChannel;//服务商渠道(0:容易网,1:微众 2:天翼)

    private Integer nativePay = 0;//0:综合支付服务 1:原生支付接口

    private String token;//商户加密token

    private Integer mchPayId;//支付交易通道id

    private String mchPayInfo;//交易通道json字符串信息

    public String getRyMchId() {
        return ryMchId;
    }

    public void setRyMchId(String ryMchId) {
        this.ryMchId = ryMchId;
    }

    public String getRyAppId() {
        return ryAppId;
    }

    public void setRyAppId(String ryAppId) {
        this.ryAppId = ryAppId;
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public Byte getOrgChannel() {
        return orgChannel;
    }

    public void setOrgChannel(Byte orgChannel) {
        this.orgChannel = orgChannel;
    }

    public Integer getNativePay() {
        return nativePay;
    }

    public void setNativePay(Integer nativePay) {
        this.nativePay = nativePay;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getMchPayId() {
        return mchPayId;
    }

    public void setMchPayId(Integer mchPayId) {
        this.mchPayId = mchPayId;
    }

    public String getMchPayInfo() {
        return mchPayInfo;
    }

    public void setMchPayInfo(String mchPayInfo) {
        this.mchPayInfo = mchPayInfo;
    }

    public String getRyMchName() {
        return ryMchName;
    }

    public void setRyMchName(String ryMchName) {
        this.ryMchName = ryMchName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}