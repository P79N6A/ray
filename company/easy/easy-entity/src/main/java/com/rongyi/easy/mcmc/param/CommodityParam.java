package com.rongyi.easy.mcmc.param;

import com.rongyi.easy.mcmc.Commodity;
import com.rongyi.easy.mcmc.CommoditySpec;
import com.rongyi.easy.mcmc.TotalCommodity;
import com.rongyi.easy.mcmc.constant.CommodityDataStatus;
import com.rongyi.easy.mcmc.constant.CommodityTerminalType;
import com.rongyi.easy.mcmc.mvc.DateJson.DateJsonDeserializer;
import com.rongyi.easy.mcmc.vo.HaiXinCommodity;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.bson.types.ObjectId;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;



public class CommodityParam implements Serializable{

	private Integer type;//类型0表示只修改库存1表示修改山商品所有信息

	private String id;//系统编号

	private String name;//商品名称

	private String category;//商品品类id

	//private String shopId;//店铺id

	private Integer status;//状态 0下架 1上架 (当前时间在上架时间和下架时间之间)2是删除3待上架4待处理 5立即上架

	private String code;//商品编码

	private String barCode;//商品条形码（海信）

	private String description;//商品描述

	private String postage;//商品邮费

	private String originalPrice;//商品原价

	private String currentPrice;//商品现价

	private List<String> picList;//商品图片列表

	//private List<ObjectId> specList;//商品规格列表

	private List<ObjectId> categoryIds;//商品所属的品类列表

	private List<Integer> customCategoryIds;//自定义分类集合

	private Integer distribution;//配送方式 1表示到店自提2快递3表示支持两种方式

	private Integer freight;//1表示商家承担运费,0表示买家承担运费

	private Integer terminalType;//上架终端：com.rongyi.easy.mcmc.constant.CommodityTerminalType常量定义说明

	private List<String> serviceIds; //公众号

	private Integer createBy;

	@JsonDeserialize(using=DateJsonDeserializer.class)
	private Date registerAt;//上架时间
	@JsonDeserialize(using=DateJsonDeserializer.class)
	private Date soldOutAt;//下架时间

	private Integer stockStatus;//0表示统一库存1表示分管库存

	private List<CommoditySpecParam> commoditySpeceParams;

	private Integer stock;//总库存

	private Integer remain;//剩余总量

	private int hasSpec;//0表示无规格 1表示有规格
	private String  weAndTeStatus;//1表示终端机，2表示微信，3表示都显示，4表示都不显示
	private Integer purchaseCount;//限购数量，0表示不限购

	private Integer templateId;//商城运费模版id

	private String reason;

	private String subheading;  //副标题

	private String commodityDetails; //商品详情

	private Integer source;

	private Integer shelvesType;//1:立即上架，手动下架,2:定时上下架

	private String brandId;

	private String brandMid;

	private String brandName;

	private String commodityModelNo;

	private String serviceDescription;//售后说明

	private Integer serviceDescriptionId;

	private String serviceDescriptionRemark;

	private String pass; // 0：不通过  1：通过

	private String haiXinId;

	private String merchantId; // 海信导入时，存入shopmid，用作权限控制
	
	private Integer isRefund;//是否可退货   0：不可退货 1：可退货
	private Double weight; // 商品重量
	private String postageTemplateId;// 运费模版MID
	private Integer isEditCategory; // 编辑运营类目

	private List<String> operationCategorys; //运营类目

	private String updateMerchantId;

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

	public String getUpdateMerchantId() {
		return updateMerchantId;
	}

	public void setUpdateMerchantId(String updateMerchantId) {
		this.updateMerchantId = updateMerchantId;
	}

	public List<String> getOperationCategorys() {
		return operationCategorys;
	}

	public void setOperationCategorys(List<String> operationCategorys) {
		this.operationCategorys = operationCategorys;
	}

	public Integer getIsEditCategory() {
		return isEditCategory;
	}

	public void setIsEditCategory(Integer isEditCategory) {
		this.isEditCategory = isEditCategory;
	}

	public String getHaiXinId() {
		return haiXinId;
	}

	public void setHaiXinId(String haiXinId) {
		this.haiXinId = haiXinId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getBrandMid() {
		return brandMid;
	}

	public void setBrandMid(String brandMid) {
		this.brandMid = brandMid;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	private String  goodsParam;//运营后台商品参数

	private Integer commodityType;//运营后台商品渠道

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public List<String> getServiceIds() {
		return serviceIds;
	}

	public void setServiceIds(List<String> serviceIds) {
		this.serviceIds = serviceIds;
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

	public String getBarCode() { return barCode; }

	public void setBarCode(String barCode) { this.barCode = barCode; }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostage() {
		return postage;
	}

	public void setPostage(String postage) {
		this.postage = postage;
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

	public List<ObjectId> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<ObjectId> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public List<Integer> getCustomCategoryIds() {
		return customCategoryIds;
	}

	public void setCustomCategoryIds(List<Integer> customCategoryIds) {
		this.customCategoryIds = customCategoryIds;
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
		return terminalType == null ? CommodityTerminalType.TERMINAL_TYPE_1 : terminalType;
	}

	public void setTerminalType(Integer terminalType) {
		this.terminalType = terminalType;
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

	/*public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}*/

	public Integer getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(Integer stockStatus) {
		this.stockStatus = stockStatus;
	}

	public List<CommoditySpecParam> getCommoditySpeceParams() {
		return commoditySpeceParams;
	}

	public void setCommoditySpeceParams(
			List<CommoditySpecParam> commoditySpeceParams) {
		this.commoditySpeceParams = commoditySpeceParams;
	}


	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public int getHasSpec() {
		return hasSpec;
	}

	public void setHasSpec(int hasSpec) {
		this.hasSpec = hasSpec;
	}

	public Integer getRemain() {
		return remain;
	}

	public void setRemain(Integer remain) {
		this.remain = remain;
	}

	public String getWeAndTeStatus() {
		return weAndTeStatus;
	}

	public void setWeAndTeStatus(String weAndTeStatus) {
		this.weAndTeStatus = weAndTeStatus;
	}

	public Integer getPurchaseCount() {
		return purchaseCount;
	}

	public void setPurchaseCount(Integer purchaseCount) {
		this.purchaseCount = purchaseCount;
	}


	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getShelvesType() {
		return shelvesType;
	}

	public void setShelvesType(Integer shelvesType) {
		this.shelvesType = shelvesType;
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
	
	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public String getCommodityDetails() {
		return commodityDetails;
	}

	public void setCommodityDetails(String commodityDetails) {
		this.commodityDetails = commodityDetails;
	}

	public String getSubheading() {
		return subheading;
	}

	public void setSubheading(String subheading) {
		this.subheading = subheading;
	}

	public String getCommodityModelNo() {
		return commodityModelNo;
	}

	public void setCommodityModelNo(String commodityModelNo) {
		this.commodityModelNo = commodityModelNo;
	}

	public String getGoodsParam() {
		return goodsParam;
	}

	public void setGoodsParam(String goodsParam) {
		this.goodsParam = goodsParam;
	}

	public Integer getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(Integer commodityType) {
		this.commodityType = commodityType;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	
	public Integer getIsRefund() {
		return isRefund;
	}

	public void setIsRefund(Integer isRefund) {
		this.isRefund = isRefund;
	}

	public String getPostageTemplateId() {
		return postageTemplateId;
	}

	public void setPostageTemplateId(String postageTemplateId) {
		this.postageTemplateId = postageTemplateId;
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

	public void haiXinTotalCommodityToCommodityParam(CommodityParam commodityParam, TotalCommodity totalCommodity){
		commodityParam.setId(totalCommodity.getId().toString());
		commodityParam.setBrandMid(totalCommodity.getBrandMid());
		commodityParam.setBrandName(totalCommodity.getBrandName());
		commodityParam.setDescription(totalCommodity.getDescription());// 海信导入：没有描述
		commodityParam.setCommodityDetails(totalCommodity.getCommodityDetails());// 海信导入：没有详情
		commodityParam.setPicList(totalCommodity.getPicList());// 海信导入：没有图片
		commodityParam.setPostage(totalCommodity.getPostage());
		commodityParam.setDistribution((totalCommodity.isSupportSelfPickup()?1:0)
				+(totalCommodity.isSupportCourierDeliver()?2:0));
		commodityParam.setFreight(totalCommodity.getFreight());
		commodityParam.setStockStatus(totalCommodity.getStockStatus());
		commodityParam.setPurchaseCount(totalCommodity.getPurchaseCount());
		commodityParam.setTemplateId(totalCommodity.getTemplateId());
		commodityParam.setPostageTemplateId(totalCommodity.getPostageTemplateId());
	}

	public void haiXinCommodityToCommodityParam(CommodityParam commodityParam, HaiXinCommodity haiXinCommodity, String shopMid,
												String shopParentMid){
		commodityParam.setType(1); // 必须赋值type=1，在后面要根据type做一定的判断（total的更新）
		commodityParam.setSource(1);// 海信导入
		commodityParam.setStatus(CommodityDataStatus.STATUS_COMMODITY_PENDING);
		commodityParam.setTerminalType(CommodityTerminalType.TERMINAL_TYPE_4);

		commodityParam.setName(haiXinCommodity.getPluName());
		commodityParam.setCode(haiXinCommodity.getPluCode());
		commodityParam.setBarCode(haiXinCommodity.getBarCode());
		commodityParam.setOriginalPrice(String.valueOf(haiXinCommodity.getPrice()));
		commodityParam.setCurrentPrice(String.valueOf(haiXinCommodity.getPrice()));
		commodityParam.setStock(haiXinCommodity.getCounts().intValue());
		commodityParam.setCreateBy(-1);
		if (StringUtils.isNotBlank(shopParentMid)) {
			commodityParam.setMerchantId(shopParentMid);
		} else {
			commodityParam.setMerchantId(shopMid);
		}


		// 生成CommoditySpecParam信息，并赋值到CommodityParam中
		toCommodityParamAboutSpecParam(commodityParam, haiXinCommodity, shopMid, null, null);
	}

	/**
	 * 海信导入：编辑
	 * @param haiXinCommodity
	 * @param commodityMongo
	 * @return
	 */
	public void haiXinCommodityToCommodityParam(CommodityParam commodityParam, HaiXinCommodity haiXinCommodity, Commodity commodityMongo,
														  String shopMid, String shopParentMid, CommoditySpec spec){

		commodityParam.setType(1); // 含义：编辑，修改商品信息
		commodityParam.setSource(1); // 海信导入
		commodityParam.setTerminalType(CommodityTerminalType.TERMINAL_TYPE_4);
		commodityParam.setName(StringUtils.isNotBlank(haiXinCommodity.getPluName())?haiXinCommodity.getPluName():commodityMongo.getName());
		commodityParam.setCode(haiXinCommodity.getPluCode());
		commodityParam.setBarCode(StringUtils.isNotBlank(haiXinCommodity.getBarCode())?haiXinCommodity.getBarCode():commodityMongo.getBarCode());
		commodityParam.setOriginalPrice(null != haiXinCommodity.getPrice()?String.valueOf(haiXinCommodity.getPrice()):commodityMongo.getOriginalPrice());
		commodityParam.setCurrentPrice(null != haiXinCommodity.getPrice()?String.valueOf(haiXinCommodity.getPrice()):commodityMongo.getCurrentPrice());
		commodityParam.setDescription(commodityMongo.getDescription());
		commodityParam.setStock(null != haiXinCommodity.getCounts()?haiXinCommodity.getCounts().intValue() : commodityMongo.getStock());

		// 理想状况，继续使用我方的状态
		Integer commodityStatus = commodityMongo.getStatus();
		commodityParam.setStatus(commodityStatus);
		if (haiXinCommodity.isOKAboutPluStatus(haiXinCommodity.getPluStatus())) { // 编辑时：如果海信数据是可用的，
			// 且，我方的状态是“删除、下架”，则状态改为“待处理”
			if (CommodityDataStatus.STATUS_COMMODITY_UNSHELVE == commodityStatus || CommodityDataStatus.STATUS_COMMODITY_DELETED == commodityStatus) {
				commodityParam.setStatus(CommodityDataStatus.STATUS_COMMODITY_PENDING);
			}
		} else { // 编辑时：如果海信数据是不可用的，
			if (CommodityDataStatus.STATUS_COMMODITY_PENDING == commodityStatus || CommodityDataStatus.STATUS_COMMODITY_CHECK_PENDING == commodityStatus) {
				// 且，我方的状态是“待处理、待审核”，则状态改为“删除”
				commodityParam.setStatus(CommodityDataStatus.STATUS_COMMODITY_DELETED);
			} else if (CommodityDataStatus.STATUS_COMMODITY_SHELVE == commodityStatus) {
				// 且，我方的状态是“上架”，则状态改为“下架”
				commodityParam.setStatus(CommodityDataStatus.STATUS_COMMODITY_UNSHELVE);
			}
		}

		//commodityParam.setId(commodityMongo.getSystemNumber());
		commodityParam.setTerminalType(commodityMongo.getTerminalType());
		commodityParam.setPostage(commodityMongo.getPostage());
		commodityParam.setPicList(commodityMongo.getPicList());
		commodityParam.setDistribution((commodityMongo.isSupportSelfPickup()?1:0)
				+(commodityMongo.isSupportCourierDeliver()?2:0));
		commodityParam.setFreight(commodityMongo.getFreight());
		commodityParam.setCreateBy(StringUtils.isBlank(commodityMongo.getCreate_by())?-1:Integer.valueOf(commodityMongo.getCreate_by()));
		commodityParam.setRegisterAt(commodityMongo.getRegisterAt());
		commodityParam.setSoldOutAt(commodityMongo.getSoldOutAt());

		commodityParam.setStockStatus(commodityMongo.getStockStatus());
		commodityParam.setPurchaseCount(commodityMongo.getPurchaseCount());
		commodityParam.setTemplateId(commodityMongo.getTemplateId());
		commodityParam.setCommodityDetails(commodityMongo.getCommodityDetails());

		// 外面已经赋值
		/*commodityParam.setBrandMid(commodityMongo.getBrandMid());
		commodityParam.setBrandName(commodityMongo.getBrandName());*/

		if (StringUtils.isNotBlank(shopParentMid)) {
			commodityParam.setMerchantId(shopParentMid);
		} else {
			commodityParam.setMerchantId(shopMid);
		}

		// 生成CommoditySpecParam信息，并赋值到CommodityParam中
		toCommodityParamAboutSpecParam(commodityParam, haiXinCommodity, shopMid, commodityMongo.getId().toString(), spec);
	}

	/**
	 * 从HaiXinCommodity、服务号、商铺ID等获取CommoditySpecParam所需信息，赋值到CommodityParam中
	 * @param commodityParam
	 * @param haiXinCommodity
	 * @param shopMid
	 */
	private void toCommodityParamAboutSpecParam(CommodityParam commodityParam, HaiXinCommodity haiXinCommodity,
													 String shopMid, String commodityId, CommoditySpec spec) {
		CommoditySpecParam specParam=new CommoditySpecParam();
		if (StringUtils.isNotBlank(commodityId)) {
			specParam.setCommodityId(commodityId);
		}
		specParam.setOriginalPrice(null != haiXinCommodity.getPrice()?String.valueOf(haiXinCommodity.getPrice()):spec.getOriginalPrice());
		specParam.setCurrentPrice(null != haiXinCommodity.getPrice()?String.valueOf(haiXinCommodity.getPrice()):spec.getCurrentPrice());
		specParam.setStock(null != haiXinCommodity.getCounts()?haiXinCommodity.getCounts().intValue():Integer.valueOf(spec.getTotal()));
		specParam.setRemain(null != haiXinCommodity.getCounts()?haiXinCommodity.getCounts().intValue():Integer.valueOf(spec.getStock()));
		specParam.setColumnValues(Arrays.asList(haiXinCommodity.getSpec()));
		specParam.setType(4);
		specParam.setShopMid(shopMid);
		specParam.setServiceIds(Arrays.asList(shopMid));

		if (null != spec) {
			if (StringUtils.isBlank(haiXinCommodity.getSpec())) {
				specParam.setColumnValues(spec.getColumnValues());
			}
		}
		commodityParam.setCommoditySpeceParams(Arrays.asList(specParam));
	}

	@Override
	public String toString() {
		
		return ReflectionToStringBuilder.toString(this);
	}

	public static void main(String[] args) {
		CommodityParam param = new CommodityParam();
		List<CommoditySpecParam> specParamList = new ArrayList<>();
		CommoditySpecParam specParam = new CommoditySpecParam();
		specParamList.add(specParam);
		param.setCommoditySpeceParams(specParamList);
		System.out.println("vo:" + JSONObject.fromObject(param));
	}
}