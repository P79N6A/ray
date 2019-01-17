package com.rongyi.easy.bdata.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * 店铺VO
 * 
 * @author xiaobo
 *
 */
@Entity(value="shops", noClassnameStored = true)
public class Shop implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private ObjectId id;
	private Integer activity_count;
	private String address;//详情地址
	private List<String> applied_card_type_ids;
	private String average_consumption;//平均消费
	private ObjectId brand_id;//主营品牌
	private Integer business_status;//商场营业状态  0正常营业  1即将营业  2暂停营业  3停止营业   4待处理
	private List<ObjectId> category_ids;//店铺分类
	private Integer comment_count;
	private List<String> coordinate;//室内座标
	private List<String> door_coordinate;
	private Date created_at;
	private String crypted_password;
	private String description;//店铺描述
	private List<Double> location;//经纬度  
	private String name;
	private String name_temp;
	private String old_code;
	private Integer old_id;
	private Integer operator_id;//操作者ID
	private Integer rank;//评分
	private Integer shop_nature;//店铺类型   0普通店   1免税店  2专柜  3折扣  4旗舰
	private String shop_number;//铺位号
	private String shop_type;//店铺性质    0商场商铺  1商场专柜  2街边店 3特卖店
	private String slug;
	private String subtitle;
	private String tags;//店铺标签
	private String telephone;//店铺电话
	private String terminal_shop;
	private String token;
	private Date updated_at;
	private Integer valid;//店铺状态   0正常  1隐藏  2删除
	private ObjectId zone_id;
	private List<ObjectId> zone_ids;
	private Integer recommend;//0不置顶  1置顶
	private String business_hours;//营业时间
	private List<String> watcher_ids;
	private ObjectId filiale_id;//分公司ID
    private List<ObjectId> custom_category_ids;//商场自定义分类
    private String qrcode_pic;//二维码
    private List<String> photo_urls;//图片地址

    private String valid_reason ;//隐藏理由 
    private String business_reason ; 
    private Integer created_by;
    private Integer updated_by ;
    private Integer create_source ; //创建来源   0大运营  1商家后台  其它crm
    private Integer update_source ; //修改来源  0大运营  1商家后台  其它crm
    private Date opened_time ;  //开业时间
    private List<ObjectId> brand_ids ; //兼营品牌
    private String icon ; //店铺logo
    private int moreFloors = 0;//0不跨楼，1跨楼
    private String name_en;    //店铺英文名
    private String description_en ; //店铺英文介绍
    private String fID;
    private ObjectId parent_id; //上级店铺ID
    private List<ObjectId> parent_ids; //上级店铺ids
    private String thirdParty;//第三来源
    // 第三方来源参数,  非标准参数
    private String orgCode;//海信 组织编码
    private String orgType;// 海信  0-自营店 1-加盟店 2-配送中心
    private String isCenter;//  海信, 是否是企业组织  0否 1 是
    private String isShowInWeiXin;//0显示,1不显示
    //第三方来源参数,  非标准参数
    private Integer sort;   //排序字段
    private Boolean candidateShop;  //是否备选
    private Boolean newShop;    //是否是新店
    private Boolean featuredShop;  //是否主打
    private String acronym;  //拼音首字母

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public Boolean getCandidateShop() {
        return candidateShop;
    }

    public void setCandidateShop(Boolean candidateShop) {
        this.candidateShop = candidateShop;
    }

    public Boolean getNewShop() {
        return newShop;
    }

    public void setNewShop(Boolean newShop) {
        this.newShop = newShop;
    }

    public Boolean getFeaturedShop() {
        return featuredShop;
    }

    public void setFeaturedShop(Boolean featuredShop) {
        this.featuredShop = featuredShop;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIsShowInWeiXin() {
        return isShowInWeiXin;
    }

    public void setIsShowInWeiXin(String isShowInWeiXin) {
        this.isShowInWeiXin = isShowInWeiXin;
    }

    public String getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(String thirdParty) {
        this.thirdParty = thirdParty;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getIsCenter() {
        return isCenter;
    }

    public void setIsCenter(String isCenter) {
        this.isCenter = isCenter;
    }

    public String getfID() {
        return fID;
    }

    public void setfID(String fID) {
        this.fID = fID;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Integer getActivity_count() {
        return activity_count;
    }

    public void setActivity_count(Integer activity_count) {
        this.activity_count = activity_count;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getApplied_card_type_ids() {
        return applied_card_type_ids;
    }

    public void setApplied_card_type_ids(List<String> applied_card_type_ids) {
        this.applied_card_type_ids = applied_card_type_ids;
    }

    public String getAverage_consumption() {
        return average_consumption;
    }

    public void setAverage_consumption(String average_consumption) {
        this.average_consumption = average_consumption;
    }

   
    public Integer getBusiness_status() {
        return business_status;
    }

    public void setBusiness_status(Integer business_status) {
        this.business_status = business_status;
    }

    public List<ObjectId> getCategory_ids() {
        return category_ids;
    }

    public void setCategory_ids(List<ObjectId> category_ids) {
        this.category_ids = category_ids;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public List<String> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(List<String> coordinate) {
        this.coordinate = coordinate;
    }

    public List<String> getDoor_coordinate() {
        return door_coordinate;
    }

    public void setDoor_coordinate(List<String> door_coordinate) {
        this.door_coordinate = door_coordinate;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getCrypted_password() {
        return crypted_password;
    }

    public void setCrypted_password(String crypted_password) {
        this.crypted_password = crypted_password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_temp() {
        return name_temp;
    }

    public void setName_temp(String name_temp) {
        this.name_temp = name_temp;
    }

    public String getOld_code() {
        return old_code;
    }

    public void setOld_code(String old_code) {
        this.old_code = old_code;
    }

    public Integer getOld_id() {
        return old_id;
    }

    public void setOld_id(Integer old_id) {
        this.old_id = old_id;
    }

    public Integer getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(Integer operator_id) {
        this.operator_id = operator_id;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getShop_nature() {
        return shop_nature;
    }

    public void setShop_nature(Integer shop_nature) {
        this.shop_nature = shop_nature;
    }

    public String getShop_number() {
        return shop_number;
    }

    public void setShop_number(String shop_number) {
        this.shop_number = shop_number;
    }

    public String getShop_type() {
        return shop_type;
    }

    public void setShop_type(String shop_type) {
        this.shop_type = shop_type;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTerminal_shop() {
        return terminal_shop;
    }

    public void setTerminal_shop(String terminal_shop) {
        this.terminal_shop = terminal_shop;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public List<ObjectId> getZone_ids() {
        return zone_ids;
    }

    public void setZone_ids(List<ObjectId> zone_ids) {
        this.zone_ids = zone_ids;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public String getBusiness_hours() {
        return business_hours;
    }

    public void setBusiness_hours(String business_hours) {
        this.business_hours = business_hours;
    }

    public List<String> getWatcher_ids() {
        return watcher_ids;
    }

    public void setWatcher_ids(List<String> watcher_ids) {
        this.watcher_ids = watcher_ids;
    }

    public List<ObjectId> getParent_ids() {
        return parent_ids;
    }

    public void setParent_ids(List<ObjectId> parent_ids) {
        this.parent_ids = parent_ids;
    }

    public List<ObjectId> getCustom_category_ids() {
        return custom_category_ids;
    }

    public void setCustom_category_ids(List<ObjectId> custom_category_ids) {
        this.custom_category_ids = custom_category_ids;
    }

	public String getQrcode_pic() {
		return qrcode_pic;
	}

	public void setQrcode_pic(String qrcode_pic) {
		this.qrcode_pic = qrcode_pic;
	}

    public List<String> getPhoto_urls() {
        return photo_urls;
    }

    public void setPhoto_urls(List<String> photo_urls) {
        this.photo_urls = photo_urls;
    }


	public String getValid_reason() {
		return valid_reason;
	}

	public void setValid_reason(String valid_reason) {
		this.valid_reason = valid_reason;
	}

	public String getBusiness_reason() {
		return business_reason;
	}

	public void setBusiness_reason(String business_reason) {
		this.business_reason = business_reason;
	}

	public Integer getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(Integer updated_by) {
		this.updated_by = updated_by;
	}

	public Integer getCreate_source() {
		return create_source;
	}

	public void setCreate_source(Integer create_source) {
		this.create_source = create_source;
	}

	public Integer getUpdate_source() {
		return update_source;
	}

	public void setUpdate_source(Integer update_source) {
		this.update_source = update_source;
	}

	public Date getOpened_time() {
		return opened_time;
	}

	public void setOpened_time(Date opened_time) {
		this.opened_time = opened_time;
	}

	public List<ObjectId> getBrand_ids() {
		return brand_ids;
	}

	public void setBrand_ids(List<ObjectId> brand_ids) {
		this.brand_ids = brand_ids;
	}

	public Integer getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getMoreFloors() {
		return moreFloors;
	}

	public void setMoreFloors(int moreFloors) {
		this.moreFloors = moreFloors;
	}

	public ObjectId getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(ObjectId brand_id) {
		this.brand_id = brand_id;
	}

	public ObjectId getZone_id() {
		return zone_id;
	}

	public void setZone_id(ObjectId zone_id) {
		this.zone_id = zone_id;
	}

	public ObjectId getFiliale_id() {
		return filiale_id;
	}

	public void setFiliale_id(ObjectId filiale_id) {
		this.filiale_id = filiale_id;
	}

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getDescription_en() {
        return description_en;
    }

    public ObjectId getParent_id() {
        return parent_id;
    }

    public void setParent_id(ObjectId parent_id) {
        this.parent_id = parent_id;
    }

    public void setDescription_en(String description_en) {
        this.description_en = description_en;
    }
}