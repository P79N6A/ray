package com.rongyi.easy.mcmc;

import com.rongyi.core.constant.Identity;
import com.rongyi.core.enumerate.mcmc.CommodityType;
import com.rongyi.easy.activitymanage.entity.GoodsInAppList;
import com.rongyi.easy.malllife.common.util.Utils;
import com.rongyi.easy.malllife.constants.Constants;
import com.rongyi.easy.mcmc.constant.CommodityConstants;
import com.rongyi.easy.mcmc.constant.CommodityDataStatus;
import com.rongyi.easy.mcmc.constant.CommodityTerminalType;
import com.rongyi.easy.mcmc.vo.CommodityVO;
import com.rongyi.easy.util.CommodityUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.io.Serializable;
import java.util.*;

/**
 * 商品表 app商品对象
 */
@Entity(value="mcmc_commodity",noClassnameStored=true)
public class Commodity implements  Serializable,Cloneable{
	private static final long serialVersionUID = -3022699601318372490L;

	@Id
	private ObjectId id;
	private int type; // 渠道  0商家，1买手
	private String liveId; // 直播Id
	private boolean isSpot; // 是否现货	0 否  1是
	private Date liveStartTime; // 直播开始时间
	private Date liveEndTime; // 直播结束时间
	private String create_by; // 创建人
	private Integer saleId; //特卖mysql id
	private Integer flashSaleId; // 闪购mysql id
	private Date activityStartTime; //特卖、闪购、秒杀开始时间
	private Date activityEndTime; //特卖、闪购、秒杀结束时间
	private String secKillSign; //秒杀标记
	private String name;//商品名称
	private String category;//商品品类id
	private String shopId;//店铺id
	private String shopMid;//店铺的mongoid
	private Integer status;//状态 -1：非现货初始化(直播使用） 0下架 1上架 (当前时间在上架时间和下架时间之间)2是删除3待上架4待处理5待审核 6审核失败
	private String code;//商品编码
	private String barCode; // 商品条形码
	private String description;//商品描述
	private String postage;//商品邮费
	private Integer stock;//商品库存
	private Integer sold;//商品销量
	private Integer lockedStock;//锁定库存
	private Date createAt;//数据创建日期
	private Date updateAt;//数据更新日期
	private String originalPrice;//商品原价
	private String currentPrice;//商品现价
	private String oPriceOfLowestCPrice;//商品现价最低值
	private String brandName;//品牌名
	private String mallMid;//商城mongoId
	private String shopNum;//店铺铺位号
	private String filialeMid;//分公司mongoId
	private String update_by;//修改人
	private String brandMid;//品牌mongoId
	private boolean supportCourierDeliver=true;//支持快递发货字段  true 是    false否
	private boolean supportSelfPickup=true;//支持到店自提  true 是    false否
	private int identity = -100;//-100 默认值，老数据，不处理权限 0集团管理员、1商场管理员、2品牌管理员、3分公司、4店长、5导购6买手
	private Integer templateId;//邮费模版id
	private List<String> picList;//商品图片列表
	private List<ObjectId> specList;//商品规格列表
	private Double price;//商品价格（现价最低价，用于排序）
	private String brandId;//商品所属品牌id
	private String mallId;//商品所属商场id
	private List<ObjectId> categoryIds;//商品所属的品类列表
	private List<String> customCategory;//自定义分类
	private Integer freight;//1表示商家承担运费,0表示买家承担运费
	private Integer terminalType;//上架终端：com.rongyi.easy.mcmc.constant.CommodityTerminalType常量定义
	private Date registerAt;//上架时间
	private Date soldOutAt;//下架时间
	private Integer source;//来源0表示页面添加1表示批量导入2app创建商品
	private Integer stockStatus;//0表示统一库存1表示分管库存
	private String systemNumber;//系统编号
	private String reason;//下架原因
	private String oPriceMax;//商品原最高价（用于买家版）
	private String oPriceMin;//商品原最低价（用于买家版）
	private String cPriceMax;//商品现最高价（用于买家版）
	private String cPriceMin;//商品现最高价（用于买家版）
	private Integer purchaseCount;//商品的限购数量
	private Double discount ;//商品的折扣
	private Integer sort;//直播商品的排序
	private boolean goodsSec = true;//正品保障
	private List<Integer> customCategoryIds;//自定义分类集合;
	private String commodityModelNo;//商品款号
	private List<String> goodsParam;//商品参数
	private Integer commodityOffUserId; //商品下架操作人
	private String commodityOffUserName; //商品下架操作人
	private String shopName; ///< 店铺名称
	private String mallName; ///< 商场名称
	private String hotAreaName; ///< 商圈
	private Integer galleryPosition;//橱窗排序商品
	private Integer shelvesType;//1:立即上架，手动下架,2:定时上下架
	private String subheading;  //副标题

	private String commodityDetails; //商品详情

	// 礼品id mysql id 兼容老数据
	private String giftId;
	// 礼品编号
	private String sn;
	// 礼品所属id
	private String mappingId;
	// 商品类型(0:商品, 1:礼品)
	private Integer commodityRange;
	// 礼品参与活动id
	private String activityId;
	// 兑换类型（1.兑换，2.换购）
	private String exchangeTypes;
	// 积分设置类型（1.同一设置 2.按等级设置）
	private Integer pointType;
	// 换购类型（1.同一设置 2.按等级设置）
	private Integer buyType;
	// 配送方式（1.自提 2.快递）
	private String deliveryTypes;
	// 自提类型（1.公共设施 2.指定店铺）
	private Integer selfType;
	// 自提地点
	private String selfAddress;
	// 自提地点备注
	private String selfRemark;
	// 自提地点id
	private String selfAddressId;
	// 自提期限
	private Date selfExpireDate;
	// 标签列表
	private List<String> tagIds;

	private Integer selfTakeDays;

	/**
	 * 是否推荐(0:不推荐,1:推荐)
	 */
	private Integer recommend;

	/*
	 * 是否在积分商城展示（1展示，2不展示）
	 */
	private Integer showIntegralMall;

	// 卡券开始时间
	private Date couponStartDate;
	// 卡券过期时间
	private Date couponEndDate;

	private List<String> locationIds;//商品记录发到集团或者商场或者店铺集合
	private Integer accountType;//0集团商品，1商场商品，4,5店铺商品
	private List<Integer> serviceIds;//微信公众号ids
	private List<String> mallServiceIds;
	private String groupMid; //集团Mid
	private String merchantId;  //商户id
	private Integer merchantType; //商户类型 0:集团 1：商场 4：店铺
	private String freePostage;  // 0包邮 1不包邮
	private List<String> skus;  //规格的sku集合

	private List<String> onServiceIds; // 标记为打开的服务号
	private List<String> offServiceIds; // 被大运营标记为关闭的服务号
	private String weAndTeStatus;
	private Integer isRefund;//是否可以退货，0：不可退货 1：可退货

	private List<String> operationCategorys;  //商品运营总部类目
	private List<String> operationCategoryFenList;  //商品运营分店类目
	private Integer shopSort = 0; //店铺商品列表排序 0-9 越大越靠前

	private boolean categoryFenUpdate;//商品运营分店是否已经改过商品分类;false表示没有,true表示已经改过

	/**
	 * 商品所属的标签,关联CommodityTag的id,只存放的叶节点
	 */
	private List<String> commodityTagIds;

	/**
	 * 商品所属的标签,关联CommodityTag的id,包含父级节点的id
	 */
	private List<String> commodityTagAllIds;

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

	public List<String> getCommodityTagIds() {
		return commodityTagIds;
	}

	public void setCommodityTagIds(List<String> commodityTagIds) {
		this.commodityTagIds = commodityTagIds;
	}

	public List<String> getCommodityTagAllIds() {
		return commodityTagAllIds;
	}

	public void setCommodityTagAllIds(List<String> commodityTagAllIds) {
		this.commodityTagAllIds = commodityTagAllIds;
	}

	public boolean isCategoryFenUpdate() {
		return categoryFenUpdate;
	}

	public void setCategoryFenUpdate(boolean categoryFenUpdate) {
		this.categoryFenUpdate = categoryFenUpdate;
	}

	public List<String> getOperationCategoryFenList() {
		return operationCategoryFenList;
	}

	public void setOperationCategoryFenList(List<String> operationCategoryFenList) {
		this.operationCategoryFenList = operationCategoryFenList;
	}

	public List<String> getOperationCategorys() {
		return operationCategorys;
	}

	public void setOperationCategorys(List<String> operationCategorys) {
		this.operationCategorys = operationCategorys;
	}
	public List<String> getMallServiceIds() {
		return mallServiceIds;
	}

	public void setMallServiceIds(List<String> mallServiceIds) {
		this.mallServiceIds = mallServiceIds;
	}

	public String getWeAndTeStatus() {
		return weAndTeStatus;
	}

	public void setWeAndTeStatus(String weAndTeStatus) {
		this.weAndTeStatus = weAndTeStatus;
	}

	public List<String> getOnServiceIds() {
		return onServiceIds;
	}

	public void setOnServiceIds(List<String> onServiceIds) {
		this.onServiceIds = onServiceIds;
	}

	public List<String> getOffServiceIds() {
		return offServiceIds;
	}

	public void setOffServiceIds(List<String> offServiceIds) {
		this.offServiceIds = offServiceIds;
	}

	// 4都不能
	// 3商家后台商品运营可以编辑微信显示隐藏，
	// 2商家后台商品运营可以编辑容易逛显示隐藏,
	// 1,商家后台商品运营可以编辑容易逛，微信显示隐藏 ，
	private String editAble="1";

	private String postageTemplateId;

	private Double weight;

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public List<String> getSkus() {
		return skus;
	}

	public void setSkus(List<String> skus) {
		this.skus = skus;
	}

	public String getFreePostage() {
		return freePostage;
	}

	public void setFreePostage(String freePostage) {
		this.freePostage = freePostage;
	}

	public Date getCouponStartDate() {
		return couponStartDate;
	}

	public void setCouponStartDate(Date couponStartDate) {
		this.couponStartDate = couponStartDate;
	}

	public Date getCouponEndDate() {
		return couponEndDate;
	}

	public void setCouponEndDate(Date couponEndDate) {
		this.couponEndDate = couponEndDate;
	}

	public Integer getSelfTakeDays() {
		return selfTakeDays;
	}

	public void setSelfTakeDays(Integer selfTakeDays) {
		this.selfTakeDays = selfTakeDays;
	}

	public String getGiftId() {
		return giftId;
	}

	public void setGiftId(String giftId) {
		this.giftId = giftId;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getMappingId() {
		return mappingId;
	}

	public void setMappingId(String mappingId) {
		this.mappingId = mappingId;
	}

	public Integer getCommodityRange() {
		return commodityRange;
	}

	public void setCommodityRange(Integer commodityType) {
		this.commodityRange = commodityType;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getExchangeTypes() {
		return exchangeTypes;
	}

	public void setExchangeTypes(String exchangeTypes) {
		this.exchangeTypes = exchangeTypes;
	}

	public Integer getPointType() {
		return pointType;
	}

	public void setPointType(Integer pointType) {
		this.pointType = pointType;
	}

	public Integer getBuyType() {
		return buyType;
	}

	public void setBuyType(Integer buyType) {
		this.buyType = buyType;
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

	public String getSelfAddressId() {
		return selfAddressId;
	}

	public void setSelfAddressId(String selfAddressId) {
		this.selfAddressId = selfAddressId;
	}

	public Date getSelfExpireDate() {
		return selfExpireDate;
	}

	public void setSelfExpireDate(Date selfExpireDate) {
		this.selfExpireDate = selfExpireDate;
	}

	public List<String> getTagIds() {
		return tagIds;
	}

	public void setTagIds(List<String> tagIds) {
		this.tagIds = tagIds;
	}

	private String serviceDescription;//售后说明

	private Integer serviceDescriptionId;

	private String serviceDescriptionRemark;

	public Integer getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(Integer merchantType) {
		this.merchantType = merchantType;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getGroupMid() {
		return groupMid;
	}

	public void setGroupMid(String groupMid) {
		this.groupMid = groupMid;
	}

	public List<String> getLocationIds() {
		return locationIds;
	}

	public void setLocationIds(List<String> locationIds) {
		this.locationIds = locationIds;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public boolean isSupportCourierDeliver() {
		return supportCourierDeliver;
	}
	public void setSupportCourierDeliver(boolean supportCourierDeliver) {
		this.supportCourierDeliver = supportCourierDeliver;
	}
	public String getBrandMid() {
		return brandMid;
	}
	public void setBrandMid(String brandMid) {
		this.brandMid = brandMid;
	}
	public String getLiveId() {
		return liveId;
	}
	public void setLiveId(String liveId) {
		this.liveId = liveId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public boolean getIsSpot() {
		return isSpot;
	}
	public void setIsSpot(boolean isSpot) {
		this.isSpot = isSpot;
	}
	public Date getLiveStartTime() {
		return liveStartTime;
	}
	public void setLiveStartTime(Date liveStartTime) {
		this.liveStartTime = liveStartTime;
	}
	public Date getLiveEndTime() {
		return liveEndTime;
	}
	public void setLiveEndTime(Date liveEndTime) {
		this.liveEndTime = liveEndTime;
	}
	public String getCreate_by() {
		return create_by;
	}
	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}
	public String getUpdate_by() {
		return update_by;
	}
	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}
	public String getShopNum() {
		return shopNum;
	}
	public void setShopNum(String shopNum) {
		this.shopNum = shopNum;
	}
	public String getMallMid() {
		return mallMid;
	}
	public void setMallMid(String mallMid) {
		this.mallMid = mallMid;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getoPriceOfLowestCPrice() {
		return oPriceOfLowestCPrice;
	}
	public void setoPriceOfLowestCPrice(String oPriceOfLowestCPrice) {
		this.oPriceOfLowestCPrice = oPriceOfLowestCPrice;
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
	public Integer getPurchaseCount() {
		return this.purchaseCount==null || this.purchaseCount < 0 ? 0:this.purchaseCount;
	}
	public void setPurchaseCount(Integer purchaseCount) {
		this.purchaseCount = purchaseCount;
	}

	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
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
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getShopMid() {
		return shopMid;
	}
	public void setShopMid(String shopMid) {
		this.shopMid = shopMid;
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
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getSold() {
		return sold;
	}
	public void setSold(Integer sold) {
		this.sold = sold;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
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
	public List<ObjectId> getSpecList() {
		return specList;
	}
	public void setSpecList(List<ObjectId> specList) {
		this.specList = specList;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getMallId() {
		return mallId;
	}
	public void setMallId(String mallId) {
		this.mallId = mallId;
	}
	public List<ObjectId> getCategoryIds() {
		return categoryIds;
	}
	public void setCategoryIds(List<ObjectId> categoryIds) {
		this.categoryIds = categoryIds;
	}
	public List<String> getCustomCategory() {
		return customCategory;
	}
	public void setCustomCategory(List<String> customCategory) {
		this.customCategory = customCategory;
	}
	/*public Integer getDistribution() {
		return distribution;
	}
	public void setDistribution(Integer distribution) {
		this.distribution = distribution;
	}*/
	public Integer getFreight() {
		return freight;
	}
	public void setFreight(Integer freight) {
		this.freight = freight;
	}
	public Integer getTerminalType() {
		return null ==terminalType ? CommodityTerminalType.TERMINAL_TYPE_7:terminalType;
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
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public Integer getStockStatus() {
		return stockStatus;
	}
	public void setStockStatus(Integer stockStatus) {
		this.stockStatus = stockStatus;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public List<Integer> getCustomCategoryIds() {
		return customCategoryIds;
	}
	public void setCustomCategoryIds(List<Integer> customCategoryIds) {
		this.customCategoryIds = customCategoryIds;
	}
	public String getSystemNumber() {
		return systemNumber;
	}
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public Integer getFlashSaleId() {
		return flashSaleId;
	}
	public void setFlashSaleId(Integer flashSaleId) {
		this.flashSaleId = flashSaleId;
	}
	public Date getActivityStartTime() {
		return activityStartTime;
	}
	public void setActivityStartTime(Date activityStartTime) {
		this.activityStartTime = activityStartTime;
	}
	public Date getActivityEndTime() {
		return activityEndTime;
	}
	public void setActivityEndTime(Date activityEndTime) {
		this.activityEndTime = activityEndTime;
	}
	public void setSystemNumber(String systemNumber) {
		this.systemNumber = systemNumber;
	}
	public String getoPriceMax() {
		return oPriceMax;
	}
	public void setoPriceMax(String oPriceMax) {
		this.oPriceMax = oPriceMax;
	}
	public String getoPriceMin() {
		return oPriceMin;
	}
	public void setoPriceMin(String oPriceMin) {
		this.oPriceMin = oPriceMin;
	}
	public String getcPriceMax() {
		return cPriceMax;
	}
	public void setcPriceMax(String cPriceMax) {
		this.cPriceMax = cPriceMax;
	}
	public String getcPriceMin() {
		return cPriceMin;
	}
	public void setcPriceMin(String cPriceMin) {
		this.cPriceMin = cPriceMin;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getFilialeMid() {
		return filialeMid;
	}
	public void setFilialeMid(String filialeMid) {
		this.filialeMid = filialeMid;
	}
	public Integer getLockedStock() {
		return lockedStock;
	}
	public void setLockedStock(Integer lockedStock) {
		this.lockedStock = lockedStock;
	}
	public boolean isSupportSelfPickup() {
		return supportSelfPickup;
	}
	public void setSupportSelfPickup(boolean supportSelfPickup) {
		this.supportSelfPickup = supportSelfPickup;
	}
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	public String getSecKillSign() {
		return secKillSign;
	}
	public void setSecKillSign(String secKillSign) {
		this.secKillSign = secKillSign;
	}
	public Integer getSort() {
		return null==sort?0:sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	public boolean isGoodsSec() {
		return goodsSec;
	}
	public void setGoodsSec(boolean goodsSec) {
		this.goodsSec = goodsSec;
	}

	public Integer getCommodityOffUserId() {
		return commodityOffUserId;
	}

	public void setCommodityOffUserId(Integer commodityOffUserId) {
		this.commodityOffUserId = commodityOffUserId;
	}

	public String getCommodityOffUserName() {
		return commodityOffUserName;
	}

	public void setCommodityOffUserName(String commodityOffUserName) {
		this.commodityOffUserName = commodityOffUserName;
	}

	public Integer getGalleryPosition() {
		return galleryPosition;
	}

	public void setGalleryPosition(Integer galleryPosition) {
		this.galleryPosition = galleryPosition;
	}

	public String getHotAreaName() {
		return hotAreaName;
	}

	public void setHotAreaName(String hotAreaName) {
		this.hotAreaName = hotAreaName;
	}

	public String getMallName() {
		return mallName;
	}

	public void setMallName(String mallName) {
		this.mallName = mallName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Integer getShelvesType() {
		return null ==shelvesType?2:shelvesType;
	}

	public void setShelvesType(Integer shelvesType) {
		this.shelvesType = shelvesType;
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

	public List<Integer> getServiceIds() {
		return serviceIds;
	}

	public void setServiceIds(List<Integer> serviceIds) {
		this.serviceIds = serviceIds;
	}

	public Integer getServiceDescriptionId() {
		return serviceDescriptionId;
	}

	public void setServiceDescriptionId(Integer serviceDescriptionId) {
		this.serviceDescriptionId = serviceDescriptionId;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public String getServiceDescriptionRemark() {
		return serviceDescriptionRemark;
	}

	public void setServiceDescriptionRemark(String serviceDescriptionRemark) {
		this.serviceDescriptionRemark = serviceDescriptionRemark;
	}

	public String getEditAble() {
		return editAble;
	}

	public void setEditAble(String editAble) {
		this.editAble = editAble;
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

	public Integer getShopSort() {
		return shopSort;
	}

	public void setShopSort(Integer shopSort) {
		this.shopSort = shopSort;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public Integer getShowIntegralMall() {
		return showIntegralMall;
	}

	public void setShowIntegralMall(Integer showIntegralMall) {
		this.showIntegralMall = showIntegralMall;
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
	public Commodity clone() throws CloneNotSupportedException {

		Commodity commodity=new Commodity();
		commodity.setCategory(category);
		commodity.setCategoryIds(categoryIds);
		commodity.setCode(code);
		commodity.setCurrentPrice(currentPrice);
		commodity.setCustomCategoryIds(customCategoryIds);
		commodity.setDescription(description);
		//commodity.setDistribution(distribution);
		commodity.setFreight(freight);
		commodity.setBrandName(brandName);
		commodity.setBrandId(brandId);
		commodity.setcPriceMax(cPriceMax);
		commodity.setcPriceMin(cPriceMin);
		commodity.setCreateAt(createAt);
		commodity.setId(id);
		commodity.setMallId(mallId);
		commodity.setMallMid(mallMid);
		commodity.setName(name);
		commodity.setoPriceMax(oPriceMax);
		commodity.setoPriceMin(oPriceMin);
		commodity.setoPriceOfLowestCPrice(oPriceOfLowestCPrice);
		commodity.setOriginalPrice(originalPrice);
		commodity.setPicList(picList);
		commodity.setPostage(postage);
		commodity.setPrice(price);
		commodity.setRegisterAt(registerAt);
		commodity.setShopId(shopId);
		commodity.setShopMid(shopMid);
		commodity.setShopNum(shopNum);
		commodity.setSold(sold);
		commodity.setSource(source);
		commodity.setSpecList(specList);
		commodity.setStatus(status);
		commodity.setStock(stock);
		commodity.setStockStatus(stockStatus);
		commodity.setTerminalType(terminalType);
		commodity.setUpdate_by(update_by);
		commodity.setUpdateAt(updateAt);
		commodity.setSaleId(saleId);
		commodity.setFlashSaleId(flashSaleId);
		commodity.setSecKillSign(secKillSign);
		commodity.setDiscount(discount);
//		commodity.setActivityStartTime(activityStartTime);
//		commodity.setActivityEndTime(activityEndTime);
		commodity.setPurchaseCount(purchaseCount);
		commodity.setSort(sort);
		commodity.setCommodityModelNo(commodityModelNo);
		commodity.setGoodsParam(goodsParam);
		commodity.setGalleryPosition(galleryPosition);
		commodity.setShopName(shopName);
		commodity.setMallName(mallName);
		commodity.setHotAreaName(hotAreaName);
		commodity.setShelvesType(null == shelvesType ? 2 : shelvesType);
		commodity.setSubheading(subheading);
		commodity.setCommodityDetails(commodityDetails);
		commodity.setServiceDescriptionId(serviceDescriptionId);
		commodity.setServiceDescription(serviceDescription);
		commodity.setServiceDescriptionRemark(serviceDescriptionRemark);
		commodity.setOperationCategorys(operationCategorys);
		commodity.setPostageTemplateId(postageTemplateId);
		commodity.setWeight(weight);
		commodity.setShopSort(shopSort);
		commodity.setCommodityTagIds(commodityTagIds);
		commodity.setCommodityTagAllIds(commodityTagAllIds);
		commodity.setShowMiniProgram(showMiniProgram);
		commodity.setLandingPageType(landingPageType);
		commodity.setLandingPageUrl(landingPageUrl);
		return commodity;
	}


	@Override
	public String toString() {
		return "Commodity{" +
				"id=" + id +
				", type=" + type +
				", liveId='" + liveId + '\'' +
				", isSpot=" + isSpot +
				", liveStartTime=" + liveStartTime +
				", liveEndTime=" + liveEndTime +
				", create_by='" + create_by + '\'' +
				", saleId=" + saleId +
				", flashSaleId=" + flashSaleId +
				", activityStartTime=" + activityStartTime +
				", activityEndTime=" + activityEndTime +
				", secKillSign='" + secKillSign + '\'' +
				", name='" + name + '\'' +
				", category='" + category + '\'' +
				", shopId='" + shopId + '\'' +
				", shopMid='" + shopMid + '\'' +
				", status=" + status +
				", code='" + code + '\'' +
				", barCode='" + barCode + '\'' +
				", description='" + description + '\'' +
				", postage='" + postage + '\'' +
				", stock=" + stock +
				", sold=" + sold +
				", lockedStock=" + lockedStock +
				", createAt=" + createAt +
				", updateAt=" + updateAt +
				", originalPrice='" + originalPrice + '\'' +
				", currentPrice='" + currentPrice + '\'' +
				", oPriceOfLowestCPrice='" + oPriceOfLowestCPrice + '\'' +
				", brandName='" + brandName + '\'' +
				", mallMid='" + mallMid + '\'' +
				", shopNum='" + shopNum + '\'' +
				", filialeMid='" + filialeMid + '\'' +
				", update_by='" + update_by + '\'' +
				", brandMid='" + brandMid + '\'' +
				", supportCourierDeliver=" + supportCourierDeliver +
				", supportSelfPickup=" + supportSelfPickup +
				", identity=" + identity +
				", templateId=" + templateId +
				", picList=" + picList +
				", specList=" + specList +
				", price=" + price +
				", brandId='" + brandId + '\'' +
				", mallId='" + mallId + '\'' +
				", categoryIds=" + categoryIds +
				", customCategory=" + customCategory +
				", freight=" + freight +
				", terminalType=" + terminalType +
				", registerAt=" + registerAt +
				", soldOutAt=" + soldOutAt +
				", source=" + source +
				", stockStatus=" + stockStatus +
				", systemNumber='" + systemNumber + '\'' +
				", reason='" + reason + '\'' +
				", oPriceMax='" + oPriceMax + '\'' +
				", oPriceMin='" + oPriceMin + '\'' +
				", cPriceMax='" + cPriceMax + '\'' +
				", cPriceMin='" + cPriceMin + '\'' +
				", purchaseCount=" + purchaseCount +
				", discount=" + discount +
				", sort=" + sort +
				", goodsSec=" + goodsSec +
				", customCategoryIds=" + customCategoryIds +
				", commodityModelNo='" + commodityModelNo + '\'' +
				", goodsParam=" + goodsParam +
				", commodityOffUserId=" + commodityOffUserId +
				", commodityOffUserName='" + commodityOffUserName + '\'' +
				", shopName='" + shopName + '\'' +
				", mallName='" + mallName + '\'' +
				", hotAreaName='" + hotAreaName + '\'' +
				", galleryPosition=" + galleryPosition +
				", shelvesType=" + shelvesType +
				", subheading='" + subheading + '\'' +
				", commodityDetails='" + commodityDetails + '\'' +
				", giftId='" + giftId + '\'' +
				", sn='" + sn + '\'' +
				", mappingId='" + mappingId + '\'' +
				", commodityRange=" + commodityRange +
				", activityId='" + activityId + '\'' +
				", exchangeTypes='" + exchangeTypes + '\'' +
				", pointType=" + pointType +
				", buyType=" + buyType +
				", deliveryTypes='" + deliveryTypes + '\'' +
				", selfType=" + selfType +
				", selfAddress='" + selfAddress + '\'' +
				", selfRemark='" + selfRemark + '\'' +
				", selfAddressId='" + selfAddressId + '\'' +
				", selfExpireDate=" + selfExpireDate +
				", tagIds=" + tagIds +
				", selfTakeDays=" + selfTakeDays +
				", couponStartDate=" + couponStartDate +
				", couponEndDate=" + couponEndDate +
				", locationIds=" + locationIds +
				", accountType=" + accountType +
				", serviceIds=" + serviceIds +
				", mallServiceIds=" + mallServiceIds +
				", groupMid='" + groupMid + '\'' +
				", merchantId='" + merchantId + '\'' +
				", merchantType=" + merchantType +
				", freePostage='" + freePostage + '\'' +
				", skus=" + skus +
				", onServiceIds=" + onServiceIds +
				", offServiceIds=" + offServiceIds +
				", weAndTeStatus='" + weAndTeStatus + '\'' +
				", isRefund=" + isRefund +
				", postageTemplateId='" + postageTemplateId + '\'' +
				", weight=" + weight +
				", editAble='" + editAble + '\'' +
				", serviceDescription='" + serviceDescription + '\'' +
				", serviceDescriptionId=" + serviceDescriptionId +
				", serviceDescriptionRemark='" + serviceDescriptionRemark + '\'' +
				", commodityTagIds='" + commodityTagIds + '\'' +
				", commodityTagAllIds='" + commodityTagAllIds + '\'' +
				", showMiniProgram='" + showMiniProgram + '\'' +
				", landingPageType='" + landingPageType + '\'' +
				", landingPageUrl='" + landingPageUrl + '\'' +
				'}';
	}

	public void wrapCommodityInfo(CommodityVO vo, long brandId, long mallId, String mallMid,
								  String brandName, String shopNum, CommodityShopInfo shopInfo, Map specMap, String brandMid) {
		if(!CommodityUtil.isGiftType(vo.getCommodityRange())) {
			if (specMap == null) {
				this.setStock(Integer.valueOf(vo.getCommodityStock()));
				this.setOriginalPrice(vo.getCommodityOriginalPrice());
				this.setCurrentPrice((vo.getCommodityCurrentPrice() != null
						&& !vo.getCommodityCurrentPrice().isEmpty()) ?
						vo.getCommodityCurrentPrice() :
						vo.getCommodityOriginalPrice());
				if (null != this.getCurrentPrice()) {
					this.setPrice(Double.parseDouble(this.getCurrentPrice()));
					this.setcPriceMax(this.getCurrentPrice());
					this.setcPriceMin(this.getCurrentPrice());
				}
				if (null != this.getOriginalPrice()) {
					this.setoPriceMax(this.getOriginalPrice());
					this.setoPriceMin(this.getOriginalPrice());
				}
			} else {
				this.setoPriceOfLowestCPrice(null == specMap.get("oPrice")?null:specMap.get("oPrice").toString());
				this.setStock(null == specMap.get("specStock")?null:(Integer) specMap.get("specStock"));
				this.setOriginalPrice(null == specMap.get("oMin")?null:specMap.get("oMin").toString());
				this.setCurrentPrice(null == specMap.get("lowest")?null:specMap.get("lowest").toString());
				this.setPrice(null == specMap.get("lowest")?null:Double.valueOf(specMap.get("lowest").toString()));
				this.setoPriceMax(null == specMap.get("oMax")?null:specMap.get("oMax").toString());
				this.setoPriceMin(null == specMap.get("oMin")?null:specMap.get("oMin").toString());
				this.setcPriceMin(null == specMap.get("lowest")?null:specMap.get("lowest").toString());
				this.setcPriceMax(null == specMap.get("cMax")?null:specMap.get("cMax").toString());
				this.setSkus(null == specMap.get("skus")?null:(List<String>)specMap.get("skus"));
			}

			this.setLocationIds(vo.getLocationIds());
			this.setAccountType(vo.getIdentity());
			this.setMallServiceIds(vo.getMallServiceIds());
			this.setMerchantId(vo.getMerchantId());
			this.setMerchantType(vo.getMerchantType());
			if(vo.getTerminalType() == 1 ||
					vo.getTerminalType() == 3 ||
					vo.getTerminalType() == 5 ||
					vo.getTerminalType() == 7) {
				List<String> onServiceIdsList=new ArrayList();
				onServiceIdsList.add(Constants.ServiceId.APP_RONG_YI_GUANG);
				this.setOnServiceIds(onServiceIdsList);
			}
			/*if(vo.getShowMiniProgram()!=null&&vo.getShowMiniProgram().intValue()==1){
				List<String> onServiceIdsList=new ArrayList();
				if(this.getOnServiceIds()!=null&&this.getOnServiceIds().size()>0){
					onServiceIdsList=this.getOnServiceIds();
				}
				onServiceIdsList.add(Constants.ServiceId.MINI_PROGRAM);
				this.setOnServiceIds(onServiceIdsList);
			}*/
		}

		this.setCode(vo.getCommodityCode());
		this.setName(vo.getCommodityName());
		this.setCategory(vo.getCommodityCategory());
		this.setDescription(vo.getCommodityDescription());
		this.setShopId(vo.getShopId());
		this.setSupportCourierDeliver(vo.isSupportCourierDeliver());//是否支持快递发货
		this.setPostage((vo.getCommodityPostage() == null) ? "0.0" : vo.getCommodityPostage());
		this.setRegisterAt(vo.getRegisterAt());
		this.setSoldOutAt(vo.getSoldOutAt());
		this.setSource((vo.getSource() != null) ? vo.getSource() : 2); //app添加的商品
		this.setType(CommodityType.GUIDE.getValue());
		this.setShelvesType(vo.getShelvesType());
		this.setIsRefund(vo.getIsRefund());//是否可退货
		//发布商品的逻辑有修改，魔店发布的商品不再是默认上下架时间为1年(立即上架是1年)
		// null == vo.getShelvesType() 版本兼容
		if (this.getSource() == 2
				&& ((2 == vo.getShelvesType() && null == vo.getRegisterAt() && null == vo.getSoldOutAt())
				|| vo.getShelvesType() == 1)) {
			this.setRegisterAt(new Date());//设置默认上下架时间
			this.setSoldOutAt(DateUtils.addYears(new Date(), 1));
		}
		this.setSold(0);
		if (this.getStock() == null || this.getStock() <= 0) {
			this.setStatus(CommodityDataStatus.STATUS_COMMODITY_UNSHELVE);
		} else {
			//APP端发布商品的时候发布商品的时候把状态更改为已删除。等待图片上传成功后更新为上架
			if (null != vo.getSource() && vo.getSource() == 2 && CollectionUtils.isEmpty(vo.getCommodityPicList())) {
				this.setStatus(CommodityDataStatus.STATUS_COMMODITY_DELETED);
			} else {
				Integer status = vo.getCommodityStatus();//变为int数据的包装类方便进行空判断
				if (null != status) {
					this.setStatus(vo.getCommodityStatus());
				} else {
					this.setStatus(CommodityDataStatus.STATUS_COMMODITY_SHELVE);
				}
			}
		}

		if (!CommodityUtil.isGiftType(vo.getCommodityRange())) {
			this.setCommodityModelNo(vo.getCommodityModelNo());//商品款号
			this.setGoodsParam(vo.getGoodsParam()); //商品参数
			if (null != vo.getProcessIdentity()) {
				this.setIdentity(vo.getProcessIdentity()); //增加商品身份
			}

			this.setSupportSelfPickup(vo.isSupportSelfPickup()); //支持到店自提

			if (!vo.isSupportCourierDeliver() && !vo.isSupportSelfPickup()) {
				this.setSupportCourierDeliver(true);
				this.setSupportSelfPickup(true);
			}
			//1表示商家承担运费,0表示买家承担运费
			this.setFreight((vo.getFreight() != null) ? vo.getFreight() : 0);
		}
		//上架终端：
		// 1.表示容易逛
		// 2.表示互动屏
		// 3.表示容易逛和互动屏
		// 4.表示微商
		// 5.微商,容易逛
		// 6.微商,互动屏
		// 7.容易逛, 互动屏, 微商(转换成二进制数个位1有容易逛第二位1有 互动屏第三位1有 微商)

		this.setTerminalType((vo.getTerminalType() != null) ? vo.getTerminalType() : CommodityTerminalType.TERMINAL_TYPE_7);

		//0表示统一库存1表示分管库存默认是分管库存
		this.setStockStatus((vo.getStockStatus() != null) ? vo.getStockStatus() : 1);
		this.setReason(vo.getReason());
		this.setPicList(vo.getCommodityPicList());
		this.setCreateAt(new Date());
		this.setUpdateAt(new Date());
		this.setCreate_by(vo.getCreate_by());
		this.setUpdate_by(vo.getCreate_by());
		this.setTemplateId(vo.getTemplateId());
		this.setCommodityRange(vo.getCommodityRange());
		//设置限购数量
		this.setPurchaseCount((null == vo.getPurchaseCount()) ? 0 : vo.getPurchaseCount());
		if (!CommodityUtil.isGiftType(vo.getCommodityRange())) {
			if (StringUtils.isNotBlank(this.originalPrice) && StringUtils.isNotBlank(this.currentPrice)) {
				this.setDiscount(Utils.calculateDiscount(Double.valueOf(this.originalPrice), Double.valueOf(this.currentPrice)));
			} else {
				this.setDiscount(Utils.calculateDiscount(null, null));
			}
			this.setBrandName(vo.getBrandName());
			this.setBrandMid(vo.getBrandMid());
			if (shopInfo != null) {
				this.setShopMid(shopInfo.getShopMid());
			}

			this.setCommodityModelNo(vo.getCommodityModelNo());
			this.setBrandId(String.valueOf(brandId));
			this.setBrandMid(vo.getBrandMid());
			this.setMallId(String.valueOf(mallId));
			this.setMallMid(mallMid);
			this.setShopNum(shopNum);
			this.setSubheading(vo.getSubheading());
			this.setCommodityDetails(vo.getCommodityDetails());
			this.setCommodityModelNo(vo.getCommodityModelNo());
			this.setSpecList(null == specMap.get("specIdList")?null:(List<ObjectId>) specMap.get("specIdList"));
			this.setGroupMid(vo.getGroupMid());
			this.setShelvesType(vo.getShelvesType());
			this.setServiceDescriptionId(vo.getServiceDescriptionId());
			this.setServiceDescription(vo.getServiceDescription());
			this.setServiceDescriptionRemark(vo.getServiceDescriptionRemark());
		}

		if (CommodityUtil.isGiftType(vo.getCommodityRange())) {
			this.setGiftId(vo.getGiftId());
			this.setStock(Integer.parseInt(vo.getCommodityStock()));
			this.setSn(vo.getSn());
			this.setMappingId(vo.getMappingId());
			this.setActivityId(vo.getActivityId() + "");
			this.setExchangeTypes(vo.getExchangeTypes());
			this.setPointType(vo.getPointType());
			this.setBuyType(vo.getBuyType());
			this.setDeliveryTypes(vo.getDeliveryTypes());
			this.setSelfType(vo.getSelfType());
			this.setSelfAddress(vo.getSelfAddress());
			this.setSelfRemark(vo.getSelfRemark());
			this.setSelfAddressId(vo.getSelfAddressId());
			this.setTagIds(vo.getTagIds());
			this.setSelfTakeDays(vo.getSelfTakeDays());
			this.setStatus(CommodityDataStatus.STATUS_COMMODITY_CHECK_PENDING);
			this.setCouponStartDate(vo.getCouponStartDate());
			this.setCouponEndDate(vo.getCouponEndDate());
			this.setPrice(vo.getPrice());
			this.setOriginalPrice(vo.getPrice() + "");
			this.setCurrentPrice(vo.getPrice() + "");
			this.setFreePostage(vo.getFreePostage());
			this.setMallMid(vo.getMallMid());
		}

		// 买手&非现货 商品 临时状态: -1
		if (null != vo.getProcessIdentity() && vo.getProcessIdentity() == Identity.BUYER) {
			//魔店买手发布的商品，上架终端默认只有容易逛
			if (2 == this.getSource()) {
				this.setTerminalType(CommodityTerminalType.TERMINAL_TYPE_1);
			} else {
				this.setTerminalType((vo.getTerminalType() != null) ? vo.getTerminalType() : CommodityTerminalType.TERMINAL_TYPE_1);
			}

			// 买手&非现货 商品 临时状态: -1
			if (null != vo.getProcessIdentity() && vo.getProcessIdentity() == Identity.BUYER) {
				//魔店买手发布的商品，上架终端默认只有容易逛
				if (2 == this.getSource()) {
					this.setTerminalType(CommodityTerminalType.TERMINAL_TYPE_1);
				} else {
					this.setTerminalType((vo.getTerminalType() != null) ? vo.getTerminalType() : CommodityTerminalType.TERMINAL_TYPE_1);
				}

				if (vo.getIsSpot() == 1) {
					this.setIsSpot(true);
					if (this.getStock() <= 0) {
						this.setStatus(0);
					} else {
						//APP端发布商品时，把商品状态更改为已删除，等待图片上传成功后，把商品状态更改为上架
						if ((vo.getSource() == null || vo.getSource() == 2) && CollectionUtils.isEmpty(vo.getCommodityPicList())) {
							this.setStatus(CommodityDataStatus.STATUS_COMMODITY_DELETED);
						} else {
							this.setStatus(CommodityDataStatus.STATUS_COMMODITY_SHELVE);
						}
					}
				} else {
					this.setIsSpot(false);
					this.setStatus(CommodityDataStatus.STATUS_COMMODITY_NOT_SPORT_CONTRACT);
				}
				this.setType(CommodityType.BULL.getValue());
				this.setShopMid(vo.getShopMid());
				//this.setMallServiceIds(Arrays.asList(Constants.ServiceId.APP_RONG_YI_GUANG));
				this.setOnServiceIds(Arrays.asList(Constants.ServiceId.APP_RONG_YI_GUANG));
			}
		}


		// 海信
		if (CommodityConstants.CommodityType.HAIXIN == vo.getCommodityRange()) {
			this.setBarCode(vo.getCommodityBarCode());
			this.setOnServiceIds(vo.getOnServiceIds());
			this.setRegisterAt(vo.getRegisterAt());
			this.setSoldOutAt(vo.getSoldOutAt());
			this.setSold(0);
			this.setStatus(vo.getCommodityStatus());
			this.setTerminalType(vo.getTerminalType());
			// TODO 暂定不处理type
		}
		this.setOperationCategorys(vo.getOperationCategorys());
		this.setPostageTemplateId(vo.getPostageTemplateId());
		this.setWeight(vo.getWeight());
		this.setShopSort(vo.getShopSort());
		this.setLandingPageType(vo.getLandingPageType());
		this.setLandingPageUrl(vo.getLandingPageUrl());
	}

	/**
	 * 重构，新包下的vo
	 * @param vo
	 * @param brandId
	 * @param mallId
	 * @param mallMid
	 * @param shopNum
	 * @param specMap
	 */
	public void wrapCommodityInfo(com.rongyi.easy.mcmc.vo.commodity.new1.CommodityVO vo, long brandId, long mallId, String mallMid,
								  String shopNum, Map specMap) {
		if(!CommodityUtil.isGiftType(vo.getCommodityRange())) {
			if (specMap == null) {
				this.setStock(Integer.valueOf(vo.getCommodityStock()));
				this.setOriginalPrice(vo.getCommodityOriginalPrice());
				this.setCurrentPrice((vo.getCommodityCurrentPrice() != null
						&& !vo.getCommodityCurrentPrice().isEmpty()) ?
						vo.getCommodityCurrentPrice() :
						vo.getCommodityOriginalPrice());
				if (null != this.getCurrentPrice()) {
					this.setPrice(Double.parseDouble(this.getCurrentPrice()));
					this.setcPriceMax(this.getCurrentPrice());
					this.setcPriceMin(this.getCurrentPrice());
				}
				if (null != this.getOriginalPrice()) {
					this.setoPriceMax(this.getOriginalPrice());
					this.setoPriceMin(this.getOriginalPrice());
				}
			} else {
				this.setoPriceOfLowestCPrice(null == specMap.get("oPriceOfLowestCPrice")?null:specMap.get("oPriceOfLowestCPrice").toString());
				this.setStock(null == specMap.get("specStock")?null:(Integer) specMap.get("specStock"));
				this.setOriginalPrice(null == specMap.get("oMin")?null:specMap.get("oMin").toString());
				this.setCurrentPrice(null == specMap.get("lowest")?null:specMap.get("lowest").toString());
				this.setPrice(null == specMap.get("lowest")?null:Double.valueOf(specMap.get("lowest").toString()));
				this.setoPriceMax(null == specMap.get("oMax")?null:specMap.get("oMax").toString());
				this.setoPriceMin(null == specMap.get("oMin")?null:specMap.get("oMin").toString());
				this.setcPriceMin(null == specMap.get("lowest")?null:specMap.get("lowest").toString());
				this.setcPriceMax(null == specMap.get("cMax")?null:specMap.get("cMax").toString());
				this.setSkus(null == specMap.get("skus")?null:(List<String>)specMap.get("skus"));
			}

			this.setLocationIds(vo.getLocationIds());
			this.setAccountType(vo.getIdentity());
			this.setMallServiceIds(vo.getMallServiceIds());
			this.setMerchantId(vo.getMerchantId());
			this.setMerchantType(vo.getMerchantType());
			if(vo.getTerminalType() == 1 ||
					vo.getTerminalType() == 3 ||
					vo.getTerminalType() == 5 ||
					vo.getTerminalType() == 7) {
				List<String> onServiceIdsList=new ArrayList();
				onServiceIdsList.add(Constants.ServiceId.APP_RONG_YI_GUANG);
				this.setOnServiceIds(onServiceIdsList);
			}
			/*if(vo.getShowMiniProgram()!=null&&vo.getShowMiniProgram().intValue()==1){
				List<String> onServiceIdsList=new ArrayList();
				if(this.getOnServiceIds()!=null&&this.getOnServiceIds().size()>0){
					onServiceIdsList=this.getOnServiceIds();
				}
				onServiceIdsList.add(Constants.ServiceId.MINI_PROGRAM);
				this.setOnServiceIds(onServiceIdsList);
			}*/
		}

		this.setCode(vo.getCommodityCode());
		this.setName(vo.getCommodityName());
		this.setCategory(vo.getCommodityCategory());
		this.setDescription(vo.getCommodityDescription());
		this.setShopId(vo.getShopId());
		this.setSupportCourierDeliver(vo.isSupportCourierDeliver());//是否支持快递发货
		this.setPostage((vo.getCommodityPostage() == null) ? "0.0" : vo.getCommodityPostage());
		this.setRegisterAt(vo.getRegisterAt());
		this.setSoldOutAt(vo.getSoldOutAt());
		this.setSource((vo.getSource() != null) ? vo.getSource() : 2); //app添加的商品
		this.setType(CommodityType.GUIDE.getValue());
		this.setShelvesType(vo.getShelvesType());
		//发布商品的逻辑有修改，魔店发布的商品不再是默认上下架时间为1年(立即上架是1年)
		// null == vo.getShelvesType() 版本兼容
		if (this.getSource() == 2
				&& ((2 == vo.getShelvesType() && null == vo.getRegisterAt() && null == vo.getSoldOutAt())
				|| vo.getShelvesType() == 1)) {
			this.setRegisterAt(new Date());//设置默认上下架时间
			this.setSoldOutAt(DateUtils.addYears(new Date(), 1));
		}
		this.setSold(0);
		if (this.getStock() == null || this.getStock() <= 0) {
			this.setStatus(CommodityDataStatus.STATUS_COMMODITY_UNSHELVE);
		} else {
			//APP端发布商品的时候发布商品的时候把状态更改为已删除。等待图片上传成功后更新为上架
			if (null != vo.getSource() && vo.getSource() == 2 && CollectionUtils.isEmpty(vo.getCommodityPicList())) {
				this.setStatus(CommodityDataStatus.STATUS_COMMODITY_DELETED);
			} else {
				Integer status = vo.getCommodityStatus();//变为int数据的包装类方便进行空判断
				if (null != status) {
					this.setStatus(vo.getCommodityStatus());
				} else {
					this.setStatus(CommodityDataStatus.STATUS_COMMODITY_SHELVE);
				}
			}
		}

		if (!CommodityUtil.isGiftType(vo.getCommodityRange())) {
			this.setCommodityModelNo(vo.getCommodityModelNo());//商品款号
			if(CollectionUtils.isNotEmpty(vo.getGoodsParam())) {
				this.setGoodsParam(vo.getGoodsParam()); //商品参数
			} else {
				this.setGoodsParam(Arrays.asList("")); //商品参数
			}
			if (null != vo.getProcessIdentity()) {
				this.setIdentity(vo.getProcessIdentity()); //增加商品身份
			}

			this.setSupportSelfPickup(vo.isSupportSelfPickup()); //支持到店自提

			if (!vo.isSupportCourierDeliver() && !vo.isSupportSelfPickup()) {
				this.setSupportCourierDeliver(true);
				this.setSupportSelfPickup(true);
			}
			//1表示商家承担运费,0表示买家承担运费
			this.setFreight((vo.getFreight() != null) ? vo.getFreight() : 0);
		}
		//上架终端：
		// 1.表示容易逛
		// 2.表示互动屏
		// 3.表示容易逛和互动屏
		// 4.表示微商
		// 5.微商,容易逛
		// 6.微商,互动屏
		// 7.容易逛, 互动屏, 微商(转换成二进制数个位1有容易逛第二位1有 互动屏第三位1有 微商)

		this.setTerminalType((vo.getTerminalType() != null) ? vo.getTerminalType() : CommodityTerminalType.TERMINAL_TYPE_7);

		//0表示统一库存1表示分管库存默认是分管库存
		this.setStockStatus((vo.getStockStatus() != null) ? vo.getStockStatus() : 1);
		this.setReason(vo.getReason());
		this.setPicList(vo.getCommodityPicList());
		this.setCreateAt(new Date());
		this.setUpdateAt(new Date());
		this.setCreate_by(vo.getCreate_by());
		this.setUpdate_by(vo.getCreate_by());
		this.setTemplateId(vo.getTemplateId());
		this.setCommodityRange(vo.getCommodityRange());
		//设置限购数量
		this.setPurchaseCount((null == vo.getPurchaseCount()) ? 0 : vo.getPurchaseCount());
		if (!CommodityUtil.isGiftType(vo.getCommodityRange())) {
			if (StringUtils.isNotBlank(this.originalPrice) && StringUtils.isNotBlank(this.currentPrice)) {
				this.setDiscount(Utils.calculateDiscount(Double.valueOf(this.originalPrice), Double.valueOf(this.currentPrice)));
			} else {
				this.setDiscount(Utils.calculateDiscount(null, null));
			}
			this.setBrandName(vo.getBrandName());
			this.setBrandMid(vo.getBrandMid());
			this.setShopMid(vo.getShopMid());

			this.setCommodityModelNo(vo.getCommodityModelNo());
			this.setBrandId(String.valueOf(brandId));
			this.setMallId(String.valueOf(mallId));
			this.setMallMid(mallMid);
			this.setShopNum(shopNum);
			this.setSubheading(vo.getSubheading());
			this.setCommodityDetails(vo.getCommodityDetails());
			this.setCommodityModelNo(vo.getCommodityModelNo());
			this.setSpecList(null == specMap.get("specIdList")?null:(List<ObjectId>) specMap.get("specIdList"));
			this.setGroupMid(vo.getGroupMid());
			this.setShelvesType(vo.getShelvesType());
			this.setServiceDescriptionId(vo.getServiceDescriptionId());
			this.setServiceDescription(vo.getServiceDescription());
			this.setServiceDescriptionRemark(vo.getServiceDescriptionRemark());
		}

		if (CommodityUtil.isGiftType(vo.getCommodityRange())) {
			this.setGiftId(vo.getGiftId());
			this.setStock(Integer.parseInt(vo.getCommodityStock()));
			this.setSn(vo.getSn());
			this.setMappingId(vo.getMappingId());
			this.setActivityId(vo.getActivityId() + "");
			this.setExchangeTypes(vo.getExchangeTypes());
			this.setPointType(vo.getPointType());
			this.setBuyType(vo.getBuyType());
			this.setDeliveryTypes(vo.getDeliveryTypes());
			this.setSelfType(vo.getSelfType());
			this.setSelfAddress(vo.getSelfAddress());
			this.setSelfRemark(vo.getSelfRemark());
			this.setSelfAddressId(vo.getSelfAddressId());
			this.setTagIds(vo.getTagIds());
			this.setSelfTakeDays(vo.getSelfTakeDays());
			this.setStatus(CommodityDataStatus.STATUS_COMMODITY_CHECK_PENDING);
			this.setCouponStartDate(vo.getCouponStartDate());
			this.setCouponEndDate(vo.getCouponEndDate());
			this.setPrice(vo.getPrice());
			this.setOriginalPrice(vo.getPrice() + "");
			this.setCurrentPrice(vo.getPrice() + "");
			this.setFreePostage(vo.getFreePostage());
			this.setMallMid(vo.getMallMid());
		}

		// 买手&非现货 商品 临时状态: -1
		if (null != vo.getProcessIdentity() && vo.getProcessIdentity() == Identity.BUYER) {
			//魔店买手发布的商品，上架终端默认只有容易逛
			if (2 == this.getSource()) {
				this.setTerminalType(CommodityTerminalType.TERMINAL_TYPE_1);
			} else {
				this.setTerminalType((vo.getTerminalType() != null) ? vo.getTerminalType() : CommodityTerminalType.TERMINAL_TYPE_1);
			}

			// 买手&非现货 商品 临时状态: -1
			if (null != vo.getProcessIdentity() && vo.getProcessIdentity() == Identity.BUYER) {
				//魔店买手发布的商品，上架终端默认只有容易逛
				if (2 == this.getSource()) {
					this.setTerminalType(CommodityTerminalType.TERMINAL_TYPE_1);
				} else {
					this.setTerminalType((vo.getTerminalType() != null) ? vo.getTerminalType() : CommodityTerminalType.TERMINAL_TYPE_1);
				}

				if (vo.getIsSpot() == 1) {
					this.setIsSpot(true);
					if (this.getStock() <= 0) {
						this.setStatus(0);
					} else {
						//APP端发布商品时，把商品状态更改为已删除，等待图片上传成功后，把商品状态更改为上架
						if ((vo.getSource() == null || vo.getSource() == 2) && CollectionUtils.isEmpty(vo.getCommodityPicList())) {
							this.setStatus(CommodityDataStatus.STATUS_COMMODITY_DELETED);
						} else {
							this.setStatus(CommodityDataStatus.STATUS_COMMODITY_SHELVE);
						}
					}
				} else {
					this.setIsSpot(false);
					this.setStatus(CommodityDataStatus.STATUS_COMMODITY_NOT_SPORT_CONTRACT);
				}
				this.setType(CommodityType.BULL.getValue());
				this.setShopMid(vo.getShopMid());
				//this.setMallServiceIds(Arrays.asList(Constants.ServiceId.APP_RONG_YI_GUANG));
				this.setOnServiceIds(Arrays.asList(Constants.ServiceId.APP_RONG_YI_GUANG));
			}
		}


		// 海信
		if (CommodityConstants.CommodityType.HAIXIN == vo.getCommodityRange()) {
			this.setBarCode(vo.getCommodityBarCode());
			this.setOnServiceIds(vo.getOnServiceIds());
			this.setRegisterAt(vo.getRegisterAt());
			this.setSoldOutAt(vo.getSoldOutAt());
			this.setSold(0);
			this.setStatus(vo.getCommodityStatus());
			this.setTerminalType(vo.getTerminalType());
			// TODO 暂定不处理type
		}

		this.setIsRefund(vo.getIsRefund());//是否可退货
		this.setOperationCategorys(vo.getOperationCategorys());
		this.setOperationCategoryFenList(vo.getOperationCategoryFenList());
		this.setPostageTemplateId(vo.getPostageTemplateId());
		this.setWeight(vo.getWeight());
		this.setShopSort(vo.getShopSort());
		this.setCategoryFenUpdate(vo.isCategoryFenUpdate());
		this.setRecommend(vo.getRecommend());
		this.setShowIntegralMall(vo.getShowIntegralMall());
		this.setShowMiniProgram(vo.getShowMiniProgram());
		this.setLandingPageType(vo.getLandingPageType());
		this.setLandingPageUrl(vo.getLandingPageUrl());
	}

	public void setActivityInfoToCommodity(GoodsInAppList goods) {
		this.setCurrentPrice(goods.getRoundSellIngPrice());
		this.setPrice(Double.parseDouble(goods.getRoundSellIngPrice()));
		this.setStock(goods.getRoundRemainCount());
	}



	public static Commodity copyCommodity(Commodity source)  {
		Commodity commodity=new Commodity();
		commodity.setCategory(source.getCategory());
		commodity.setType(source.getType());
		commodity.setCategoryIds(source.getCategoryIds());
		commodity.setCode(source.getCode());
		commodity.setCurrentPrice(source.getCurrentPrice());
		commodity.setCustomCategoryIds(source.getCustomCategoryIds());
		commodity.setDescription(source.getDescription());
		commodity.setFreight(source.getFreight());
		commodity.setBrandName(source.getBrandName());
		commodity.setBrandId(source.getBrandId());
		commodity.setcPriceMax(source.getcPriceMax());
		commodity.setcPriceMin(source.getcPriceMin());
		//commodity.setCreateAt(createAt);
		//commodity.setId(id);
		commodity.setMallId(source.getMallId());
		commodity.setMallMid(source.getMallMid());
		commodity.setName(source.getName());
		commodity.setoPriceMax(source.getoPriceMax());
		commodity.setoPriceMin(source.getoPriceMin());
		commodity.setoPriceOfLowestCPrice(source.getoPriceOfLowestCPrice());
		commodity.setOriginalPrice(source.getOriginalPrice());
		commodity.setPicList(source.getPicList());
		commodity.setPostage(source.getPostage());
		commodity.setPrice(source.getPrice());
		commodity.setRegisterAt(source.getRegisterAt());
		commodity.setShopId(source.getShopId());
		commodity.setShopMid(source.getShopMid());
		commodity.setShopNum(source.getShopNum());
		commodity.setSold(source.getSold());
		commodity.setSource(source.getSource());
		commodity.setSpecList(source.getSpecList());
		commodity.setStatus(source.getStatus());
		commodity.setStock(source.getStock());
		commodity.setStockStatus(source.getStockStatus());
		commodity.setTerminalType(source.getTerminalType());
		//commodity.setUpdate_by(update_by);
		//commodity.setUpdateAt(updateAt);
		commodity.setSaleId(source.getSaleId());
		commodity.setFlashSaleId(source.getFlashSaleId());
		commodity.setSecKillSign(source.getSecKillSign());
		commodity.setDiscount(source.getDiscount());
		commodity.setActivityStartTime(source.getActivityStartTime());
		commodity.setActivityEndTime(source.getActivityEndTime());
		commodity.setPurchaseCount(source.getPurchaseCount());
		commodity.setSort(source.getSort());
		commodity.setCommodityModelNo(source.getCommodityModelNo());
		commodity.setGoodsParam(source.getGoodsParam());
		commodity.setGalleryPosition(source.getGalleryPosition());
		commodity.setShopName(source.getShopName());
		commodity.setMallName(source.getMallName());
		commodity.setHotAreaName(source.getHotAreaName());
		//commodity.setLiveId(source.getLiveId());
		commodity.setIsSpot(source.getIsSpot());
		//commodity.setLiveStartTime(source.getLiveStartTime());
		//commodity.setLiveEndTime(source.getLiveEndTime());
		commodity.setLockedStock(source.getLockedStock());
		commodity.setFilialeMid(source.getFilialeMid());
		commodity.setBrandMid(source.getBrandMid());
		commodity.setSupportCourierDeliver(source.isSupportCourierDeliver());
		commodity.setSupportSelfPickup(source.isSupportSelfPickup());
		commodity.setIdentity(source.getIdentity());
		commodity.setTemplateId(source.getTemplateId());
		commodity.setCustomCategory(source.getCustomCategory());
		commodity.setSoldOutAt(source.getSoldOutAt());
		commodity.setSystemNumber(source.getSystemNumber());
		commodity.setReason(source.getReason());
		commodity.setGoodsSec(source.isGoodsSec());
		commodity.setSubheading(source.getSubheading());
		commodity.setCommodityDetails(source.getCommodityDetails());
		commodity.setCommodityRange(source.getCommodityRange());
		commodity.setFreePostage(source.getFreePostage());
		commodity.setShelvesType(source.getShelvesType());
		commodity.setServiceDescriptionId(source.getServiceDescriptionId());
		commodity.setServiceDescription(source.getServiceDescription());
		commodity.setServiceDescriptionRemark(source.getServiceDescriptionRemark());
		commodity.setIsRefund(source.getIsRefund());//是否可退货

		commodity.setOperationCategorys(source.getOperationCategorys());
		commodity.setPostageTemplateId(source.postageTemplateId);
		commodity.setWeight(source.weight);
		commodity.setCommodityTagIds(source.getCommodityTagIds());
		commodity.setCommodityTagAllIds(source.getCommodityTagAllIds());
		commodity.setShowMiniProgram(source.getShowMiniProgram());
		commodity.setLandingPageType(source.getLandingPageType());
		commodity.setLandingPageUrl(source.getLandingPageUrl());
		return commodity;
	}
}