package com.rongyi.easy.tradecenter.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jason
 * on 2015/11/5.17:33
 */
public class MerchantOsmOrderVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer orderId;
    private String orderNo;//订单编号
    private String createTime;//下单时间
    private String paymentTime;//支付时间
    private String shopId;//店铺mysqlid
    private String shopName;//店铺名称
    private String commodityNum;//商品种类数
    private  String guideName;//导购名称
    private Integer guideId;//导购id
    private Integer orderSource;//0为微网站，1为容易逛，2为终端机，3其他
    private String orderSourceForWeiXin;// 订单渠道微信来源     1 微商城 ，2 标准微信
    private String weixinAppId;//
    private Byte payChannel;//导购id
    private String buyerAccount;//买家账号
    private String buyerNameByWeixin;//标准微信下单昵称 需要解码
    private String buyerNickName;//买家账号
    private String paymentAmount;//订单实际支付金额 元
    private String discountAmount;//订单优惠金额 元
    private BigDecimal discountAmountByChange;//卖家折扣之后的金额
    private BigDecimal expressPrice;//邮费 元
    private BigDecimal integralAmount;//积分优惠
    private String integralNum= "0";//积分数
    private String orderStatus;//订单状态 1：订单未付款、2：订单待发货、3、订单已发货、4：订单确认收货、5：订单关闭、8：取消
    private String type;//补充订单状态
    private String buyerComment;//买家备注
    private String closeReason;//关闭原因
    private String cancelReason;//取消原因
    private String expressInfoChangeFlg;//"物流信息是否允许修改 0：不允许 1：允许 "
    private List<MerchantOrderCommodityVO> commodityList;//订单下的商品列表
    private String createTimeStr;   //格式化下单时间  （今天 12:06:55）
    private String orderChannel; //下单渠道 SmallProgram ：小程序
    private Integer activityType;//活动类型 0不参与活动 3秒杀 4拼团
    private Long activityRoundId;//活动场次
    private String activityName;//活动名称
    private String activityStatus;//活动状态
    private String deleverTime;//发货时间
    private String reveiveTime;//收货时间
    private BigDecimal merchantRedDiscount;//商家红包补贴金额
    private BigDecimal merchantRebateDiscount;//商家抵扣券补贴金额
    private BigDecimal reductionFee; ///< 满减金额
    private Integer deliveryType;//快递方式 1：自提 2：快递


    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    public Byte getPayChannel() {
        return payChannel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPayChannel(Byte payChannel) {
        this.payChannel = payChannel;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getBuyerComment() {
        return buyerComment;
    }

    public void setBuyerComment(String buyerComment) {
        this.buyerComment = buyerComment;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public String getBuyerNickName() {
        return buyerNickName;
    }

    public void setBuyerNickName(String buyerNickName) {
        this.buyerNickName = buyerNickName;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
    }

    public BigDecimal getIntegralAmount() {
        return integralAmount==null?new BigDecimal(0):integralAmount;
    }

    public void setIntegralAmount(BigDecimal integralAmount) {
        this.integralAmount = integralAmount;
    }

    public BigDecimal getExpressPrice() {
        return expressPrice;
    }

    public void setExpressPrice(BigDecimal expressPrice) {
        this.expressPrice = expressPrice;
    }

    public String getIntegralNum() {
        return integralNum;
    }
    public void setIntegralNum(String integralNum) {
        this.integralNum = integralNum;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCommodityNum() {
        return commodityNum;
    }

    public void setCommodityNum(String commodityNum) {
        this.commodityNum = commodityNum;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<MerchantOrderCommodityVO> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<MerchantOrderCommodityVO> commodityList) {
        this.commodityList = commodityList;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getExpressInfoChangeFlg()
    {
        return expressInfoChangeFlg;
    }

    public void setExpressInfoChangeFlg(String expressInfoChangeFlg)
    {
        this.expressInfoChangeFlg = expressInfoChangeFlg;
    }

    public String getOrderChannel()
    {
        return orderChannel;
    }

    public void setOrderChannel(String orderChannel)
    {
        this.orderChannel = orderChannel;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Long getActivityRoundId() {
        return activityRoundId;
    }

    public void setActivityRoundId(Long activityRoundId) {
        this.activityRoundId = activityRoundId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

	public String getCreateTimeStr() {
		return createTimeStr;
	}

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

    public String getBuyerNameByWeixin() {
        return buyerNameByWeixin;
    }

    public void setBuyerNameByWeixin(String buyerNameByWeixin) {
        this.buyerNameByWeixin = buyerNameByWeixin;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public BigDecimal getDiscountAmountByChange() {
        return discountAmountByChange;
    }

    public void setDiscountAmountByChange(BigDecimal discountAmountByChange) {
        this.discountAmountByChange = discountAmountByChange;
    }

    public String getDeleverTime() {
        return deleverTime;
    }

    public void setDeleverTime(String deleverTime) {
        this.deleverTime = deleverTime;
    }

    public String getReveiveTime() {
        return reveiveTime;
    }

    public void setReveiveTime(String reveiveTime) {
        this.reveiveTime = reveiveTime;
    }

    public BigDecimal getMerchantRedDiscount() {
        return merchantRedDiscount;
    }

    public void setMerchantRedDiscount(BigDecimal merchantRedDiscount) {
        this.merchantRedDiscount = merchantRedDiscount;
    }

    public BigDecimal getMerchantRebateDiscount() {
        return merchantRebateDiscount;
    }

    public void setMerchantRebateDiscount(BigDecimal merchantRebateDiscount) {
        this.merchantRebateDiscount = merchantRebateDiscount;
    }

    public String getOrderSourceForWeiXin() {
        return orderSourceForWeiXin;
    }

    public void setOrderSourceForWeiXin(String orderSourceForWeiXin) {
        this.orderSourceForWeiXin = orderSourceForWeiXin;
    }

    public String getWeixinAppId() {
        return weixinAppId;
    }

    public void setWeixinAppId(String weixinAppId) {
        this.weixinAppId = weixinAppId;
    }

    public BigDecimal getReductionFee() {
        return reductionFee;
    }

    public void setReductionFee(BigDecimal reductionFee) {
        this.reductionFee = reductionFee;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}