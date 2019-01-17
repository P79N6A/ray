package com.rongyi.easy.solr.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ActivitySearchParam implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 578059263593575051L;

    private String keyword;   //关键词
    private int distance;     //距离筛选
    private String coord_x;   //坐标x
    private String coord_y;   //坐标y

    //0店铺1商场2品牌3分类（类似于美食,多个分类查询用“,”分割，如：1,2,3）
    private String cat_id;
    // 卡券本身适应的分类列表（目前在查看单个券适用的范围查询用到）
    private List<String> srcCategoryList;

    /**
     * 自定义分类id
     */
    private String custom_cat_id;
    private String city_name; //城市名（如  上海&上海市）
    private String sort;      //排序规则（distance，null，couponRequired（commodityRequired），date）
    private int requiredCoupon = 0;  //需要的优惠券[0：全部、1：代金券、2优惠券]（之前的sort最后一个条件迁移到此）
    private int from;         //页（注，从0开始表示第一页）
    private int size;         //一页数量
    private String brand_id;  //品牌id
    private String zone_id;   //区域id
    // 店铺id（多个店铺查询用“,”分割，如：1,2,3）
    private String shop_id;
    private String holder_id;       //优惠券持有者id
    private boolean couponRequired; //是否只看优惠券
    private List<String> shopList;    //终端机参数 店铺id List

    private String mallId; // mall Id for 终端屏
    private String startLetter;  // 首字母 for 终端屏

    private String showChannel;//展示渠道  APP：4，互动屏：5, 微信：6    不填时默认app
    private List<String> keywordList = new ArrayList<>();

    private String couponId;//红包券id

    private String serviceId;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public List<String> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(List<String> keywordList) {
        this.keywordList = keywordList;
    }

    public void addKeywordList(String keyword) {
        this.keywordList.add(keyword);
    }

    public List<String> getSrcCategoryList() {
        return srcCategoryList;
    }

    public void setSrcCategoryList(List<String> srcCategoryList) {
        this.srcCategoryList = srcCategoryList;
    }

    public int getRequiredCoupon() {
        return requiredCoupon;
    }

    public void setRequiredCoupon(int requiredCoupon) {
        this.requiredCoupon = requiredCoupon;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getCoord_x() {
        return coord_x;
    }

    public void setCoord_x(String coord_x) {
        this.coord_x = coord_x;
    }

    public String getCoord_y() {
        return coord_y;
    }

    public void setCoord_y(String coord_y) {
        this.coord_y = coord_y;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public String getZone_id() {
        return zone_id;
    }

    public void setZone_id(String zone_id) {
        this.zone_id = zone_id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getHolder_id() {
        return holder_id;
    }

    public void setHolder_id(String holder_id) {
        this.holder_id = holder_id;
    }

    public boolean isCouponRequired() {
        return couponRequired;
    }

    public void setCouponRequired(boolean couponRequired) {
        this.couponRequired = couponRequired;
    }

    public List<String> getShopList() {
        return shopList;
    }

    public void setShopList(List<String> shopList) {
        this.shopList = shopList;
    }

    public String getMallId() {
        return mallId;
    }

    public void setMallId(String mallId) {
        this.mallId = mallId;
    }

    public String getStartLetter() {
        return startLetter;
    }

    public void setStartLetter(String startLetter) {
        this.startLetter = startLetter;
    }

    public String getShowChannel() {
        return showChannel;
    }

    public void setShowChannel(String showChannel) {
        this.showChannel = showChannel;
    }

    /**
     * @return the custom_cat_id
     */
    public String getCustom_cat_id() {
        return custom_cat_id;
    }

    /**
     * @param custom_cat_id the custom_cat_id to set
     */
    public void setCustom_cat_id(String custom_cat_id) {
        this.custom_cat_id = custom_cat_id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ActivitySearchParam{");
        sb.append("keyword='").append(keyword).append('\'');
        sb.append(", distance=").append(distance);
        sb.append(", coord_x='").append(coord_x).append('\'');
        sb.append(", coord_y='").append(coord_y).append('\'');
        sb.append(", cat_id='").append(cat_id).append('\'');
        sb.append(", srcCategoryList=").append(srcCategoryList);
        sb.append(", custom_cat_id='").append(custom_cat_id).append('\'');
        sb.append(", city_name='").append(city_name).append('\'');
        sb.append(", sort='").append(sort).append('\'');
        sb.append(", requiredCoupon=").append(requiredCoupon);
        sb.append(", from=").append(from);
        sb.append(", size=").append(size);
        sb.append(", brand_id='").append(brand_id).append('\'');
        sb.append(", zone_id='").append(zone_id).append('\'');
        sb.append(", shop_id='").append(shop_id).append('\'');
        sb.append(", holder_id='").append(holder_id).append('\'');
        sb.append(", couponRequired=").append(couponRequired);
        sb.append(", shopList=").append(shopList);
        sb.append(", mallId='").append(mallId).append('\'');
        sb.append(", startLetter='").append(startLetter).append('\'');
        sb.append(", showChannel='").append(showChannel).append('\'');
        sb.append(", keywordList=").append(keywordList);
        sb.append(", couponId='").append(couponId).append('\'');
        sb.append(", serviceId='").append(serviceId).append('\'');
        sb.append('}');
        return sb.toString();
    }

}