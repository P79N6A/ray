package com.rongyi.easy.mcmc.vo;

import com.rongyi.easy.mcmc.entity.CommodityCustomCategoryEntity;
import com.rongyi.easy.mcmc.mvc.DateJson.JsonDateSerializer;
import com.rongyi.easy.mcmc.vo.commodity.new1.postage.PostageTemplateVO;
import com.rongyi.easy.ryoms.entity.WechatInfoVo;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommodityVO2 implements  Serializable {

	private static final long serialVersionUID = -3022699601318372490L;

	private String id;//系统编号
	private String name;//商品名称

	private Integer status;//状态 0下架 1上架 (当前时间在上架时间和下架时间之间)2是删除3待上架4待处理
	private String code;//商品编码
	private Integer stock;//商品库存（包括卖出的商品和锁定的商品）
	private Integer remain;//商品剩余量
	private Integer lockedStock;//锁定库存
	private Integer isNormalized;//0表示没有规格1表示有规格的
	private String originalPrice;//商品原价
	private String currentPrice;//商品现价
	private List<String> picList;//商品图片列表
	private List<CommoditySpecVO1> specList;//商品规格列表
	private List<CommoditySpecVO2> specVO2List;//商品规格店铺表
	private List<String> categoryIds;//商品所属的品类id
	private List<String> categoryNames;//商品所属的品类列表
	private List<CommodityCustomCategoryEntity> customCategory=new ArrayList<CommodityCustomCategoryEntity>();//自定义分类列表
	private String description;//商品描述
	private Integer distribution;//配送方式 1表示到店自提2快递3表示支持两种方式
	private Integer freight;//1表示商家承担运费,0表示买家承担运费
	private Integer terminalType;//上架终端：1.表示容易逛2.表示互动屏3.表示容易逛和互动屏4.表示微商5.微商,容易逛6.微商,互动屏7.容易逛, 互动屏, 微商(转换成二进制数个位1有容易逛第二位1有 互动屏第三位1有 微商)
	private String postage;//商品邮费
	private Integer source;//来源
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date updateAt;//数据更新日期

	@JsonSerialize(using=JsonDateSerializer.class)
	private Date registerAt;//上架时间

	@JsonSerialize(using=JsonDateSerializer.class)
	private Date soldOutAt;//下架时间

	@JsonSerialize(using=JsonDateSerializer.class)
	private Date createAt; //创建时间

	private Integer stockStatus;//0表示统一库存1表示分管库存

	private boolean immediateOn = false;//true表示设置是立即上架
	private Integer templateId;//邮费模版id
	private Integer purchaseCount;
	private List<String> mallMids;//商品对应店铺所在的商场
	private String subheading;  //副标题

	private String commodityDetails; //商品详情
	private List<WechatInfoVo> wechatInfoVos;
	private List<String> serviceIds;
	private String commodityModelNo;//商品款号
	private List<String> goodsParam;//商品参数
	private String createBy;
	private String updateBy;
	private String brandName;
	private String brandMid;
	private List<String> referencePriceList;
	private List<String> originalPriceList;
	private List<String> currentPriceList;
	private String serviceDescription;//售后说明

	private Integer serviceDescriptionId;

	private String serviceDescriptionRemark;

	private String reason;
	
	private Integer isRefund;//是否可退货  0:否，1:可退货
	private com.rongyi.easy.mcmc.vo.commodity.new1.postage.PostageTemplateVO postageTemplateVO;//运费模版详情
	private Double weight; // 重量

	private List<String> operationCategorys;  //商品运营类目

	/*
	 * 是否在小程序端展示（1展示，0不展示）
	 */
	private Integer showMiniProgram;

	/**
	 * 落地类型(0:默认,1:外部网页,2:小程序)
	 */
	private Integer landingPageType;

	/**
	 * 落地Url地址
	 */
	private String landingPageUrl;

	public List<String> getOperationCategorys() {
		return operationCategorys;
	}

	public void setOperationCategorys(List<String> operationCategorys) {
		this.operationCategorys = operationCategorys;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getCommodityModelNo() {
		return commodityModelNo;
	}

	public void setCommodityModelNo(String commodityModelNo) {
		this.commodityModelNo = commodityModelNo;
	}

	public List<String> getGoodsParam() {
		return goodsParam;
	}

	public void setGoodsParam(List<String> goodsParam) {
		this.goodsParam = goodsParam;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public List<String> getServiceIds() {
		return serviceIds;
	}

	public void setServiceIds(List<String> serviceIds) {
		this.serviceIds = serviceIds;
	}

	public List<WechatInfoVo> getWechatInfoVos() {
		return wechatInfoVos;
	}

	public void setWechatInfoVos(List<WechatInfoVo> wechatInfoVos) {
		this.wechatInfoVos = wechatInfoVos;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getRemain() {
		return remain;
	}
	public void setRemain(Integer remain) {
		this.remain = remain;
	}
	public Integer getIsNormalized() {
		return isNormalized;
	}
	public void setIsNormalized(Integer isNormalized) {
		this.isNormalized = isNormalized;
	}
	public String getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}
	public String getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}
	public List<String> getPicList() {
		return picList;
	}
	public void setPicList(List<String> picList) {
		this.picList = picList;
	}
	public List<CommoditySpecVO1> getSpecList() {
		return specList;
	}
	public void setSpecList(List<CommoditySpecVO1> specList) {
		this.specList = specList;
	}
	public List<CommoditySpecVO2> getSpecVO2List() {
		return specVO2List;
	}
	public void setSpecVO2List(List<CommoditySpecVO2> specVO2List) {
		this.specVO2List = specVO2List;
	}
	public List<String> getCategoryNames() {
		return categoryNames;
	}
	public void setCategoryNames(List<String> categoryNames) {
		this.categoryNames = categoryNames;
	}

	public List<CommodityCustomCategoryEntity> getCustomCategory() {
		return customCategory;
	}

	public void setCustomCategory(List<CommodityCustomCategoryEntity> customCategory) {
		this.customCategory = customCategory;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getDistribution() {
		return distribution;
	}
	public void setDistribution(Integer distribution) {
		this.distribution = distribution;
	}
	public Integer getFreight() {
		return freight;
	}
	public void setFreight(Integer freight) {
		this.freight = freight;
	}
	public Integer getTerminalType() {
		return terminalType;
	}
	public void setTerminalType(Integer terminalType) {
		this.terminalType = terminalType;
	}
	public String getPostage() {
		return postage;
	}
	public void setPostage(String postage) {
		this.postage = postage;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public Date getRegisterAt() {
		return registerAt;
	}
	public void setRegisterAt(Date registerAt) {
		this.registerAt = registerAt;
	}
	public Date getSoldOutAt() {
		return soldOutAt;
	}
	public void setSoldOutAt(Date soldOutAt) {
		this.soldOutAt = soldOutAt;
	}
	public Integer getStockStatus() {
		return stockStatus;
	}
	public void setStockStatus(Integer stockStatus) {
		this.stockStatus = stockStatus;
	}
	public List<String> getCategoryIds() {
		return categoryIds;
	}
	public void setCategoryIds(List<String> categoryIds) {
		this.categoryIds = categoryIds;
	}
	public Integer getLockedStock() {
		return lockedStock;
	}
	public void setLockedStock(Integer lockedStock) {
		this.lockedStock = lockedStock;
	}

	public boolean isImmediateOn() {
		return immediateOn;
	}

	public void setImmediateOn(boolean immediateOn) {
		this.immediateOn = immediateOn;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public Integer getPurchaseCount() {
		return purchaseCount;
	}

	public void setPurchaseCount(Integer purchaseCount) {
		this.purchaseCount = purchaseCount;
	}

	public List<String> getMallMids() {
		return mallMids;
	}

	public void setMallMids(List<String> mallMids) {
		this.mallMids = mallMids;
	}

	public String getSubheading() {
		return subheading;
	}

	public void setSubheading(String subheading) {
		this.subheading = subheading;
	}

	public String getCommodityDetails() {
		return commodityDetails;
	}

	public void setCommodityDetails(String commodityDetails) {
		this.commodityDetails = commodityDetails;
	}

	public String getBrandMid() {
		return brandMid;
	}

	public void setBrandMid(String brandMid) {
		this.brandMid = brandMid;
	}

	public List<String> getReferencePriceList() {
		return referencePriceList;
	}

	public void setReferencePriceList(List<String> referencePriceList) {
		this.referencePriceList = referencePriceList;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getIsRefund() {
		return isRefund;
	}

	public void setIsRefund(Integer isRefund) {
		this.isRefund = isRefund;
	}
	
	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public Integer getServiceDescriptionId() {
		return serviceDescriptionId;
	}

	public void setServiceDescriptionId(Integer serviceDescriptionId) {
		this.serviceDescriptionId = serviceDescriptionId;
	}

	public String getServiceDescriptionRemark() {
		return serviceDescriptionRemark;
	}

	public void setServiceDescriptionRemark(String serviceDescriptionRemark) {
		this.serviceDescriptionRemark = serviceDescriptionRemark;
	}

	public List<String> getOriginalPriceList() {
		return originalPriceList;
	}

	public void setOriginalPriceList(List<String> originalPriceList) {
		this.originalPriceList = originalPriceList;
	}

	public List<String> getCurrentPriceList() {
		return currentPriceList;
	}

	public void setCurrentPriceList(List<String> currentPriceList) {
		this.currentPriceList = currentPriceList;
	}

public PostageTemplateVO getPostageTemplateVO() {
		return postageTemplateVO;
	}

	public void setPostageTemplateVO(PostageTemplateVO postageTemplateVO) {
		this.postageTemplateVO = postageTemplateVO;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getShowMiniProgram() {
		return showMiniProgram;
	}

	public void setShowMiniProgram(Integer showMiniProgram) {
		this.showMiniProgram = showMiniProgram;
	}

	public Integer getLandingPageType() {
		return landingPageType;
	}

	public void setLandingPageType(Integer landingPageType) {
		this.landingPageType = landingPageType;
	}

	public String getLandingPageUrl() {
		return landingPageUrl;
	}

	public void setLandingPageUrl(String landingPageUrl) {
		this.landingPageUrl = landingPageUrl;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}