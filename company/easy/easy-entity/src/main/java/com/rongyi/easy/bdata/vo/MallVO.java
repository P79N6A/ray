package com.rongyi.easy.bdata.vo;

/**
 * Desc: bdata mallvo
 * User: chris
 * Date: 2015/10/24 18:19
 */
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.bson.types.ObjectId;

public class MallVO implements Serializable {



	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public double getLogoX() {
		return logoX;
	}

	public void setLogoX(double logoX) {
		this.logoX = logoX;
	}

	public double getLogoY() {
		return logoY;
	}

	public void setLogoY(double logoY) {
		this.logoY = logoY;
	}

	private static final long serialVersionUID = 1L;
    private String id;//商场ID
    private String name;//商场名称
    private String mold;//商场类型
    private Integer businessStatus;//商场营业状态, 0:正常营业1:即将开业2:暂停营业3:停止营业
    private Integer mallValid;//商场营业状态, 0:正常营业1:即将开业2:暂停营业3:停止营业
	private Integer recommend;//商场推荐：1-未推荐、2-已推荐
    private List<String> aliases;//商场别名
    private String weixin;//微信号
    private MallAddressVO mallAddress;//商场地址
    private String businessHours;//营业时间
    private String description;//商场介绍
    private String telephone;
    private String transInfor;//交通信息
    private List<ParkingVO> parking;//停车信息
    private Boolean terminalMall;//终端机合作1-无合作、2-有合作
    private String appearPic;//APP外景图片：APP外景图的url地址
	private String webAppearPic;//WEB外景图片：WEB外景图url地址
    private String traffPic;//商场交通图：交通图url地址
    private String introPic;//商场介绍图：商场介绍图url地址
    private String terminalLogo;//终端机logo：终端机logourl地址
    private String wechatPic; //商场 微信展示图片：微信地址
    private String icon;//商场ICOn：图片logoURl
    private String tags;
    private Integer rank;
    private String slug;
    private Long shopNum;
    private double logoX;  //经度
    private double logoY;  //纬度
	private boolean hasCustomCategory;//是否有自定义分类
	private String merlogPic;  //商家后台logo
    private String mallGroupId;//商场所属集团id
    private String mallLevel;//商场等级
    private Date updatedAt;//修改时间
    private String lastUpdateId;//最后修改人
    private String openTime;//开业时间
    private Date createdAt;//创建时间
    private String operatorId;//创建者
    private String operatorName;//创建者
    private String lastUpdateName;//修改者
    private String parentId; // 上一级id
	private List parentIds; // 上一级所有ids
	private String mobile;
	private String validReason;
	private String businessStatusReason;
    private String ename;    //商场英文名称
    private String descriptionEn;//商场英文介绍
    private  Integer dailyPeople ;//日均人流量

    private String opDirectorName;  //运维负责人

    private String opDirectorPhone;  //运维电话

    private String bdDirectorName; //BD负责人

    private String bdPDirectorPhone; //bd负责人电话

    private String mallDirectorName;  //商场负责人

    private Integer cooperateTerminalNumber; //合同终端数

    private Boolean displayAdTemplate;

    /**
     * 是否使用新广告系统
     */
    private Boolean newAdvertisementSystem;

    public Boolean getNewAdvertisementSystem() {
        return newAdvertisementSystem;
    }

    public void setNewAdvertisementSystem(Boolean newAdvertisementSystem) {
        this.newAdvertisementSystem = newAdvertisementSystem;
    }

    public Boolean getDisplayAdTemplate() {
        return displayAdTemplate;
    }

    public void setDisplayAdTemplate(Boolean displayAdTemplate) {
        this.displayAdTemplate = displayAdTemplate;
    }

    public String getOpDirectorName() {
        return opDirectorName;
    }

    public void setOpDirectorName(String opDirectorName) {
        this.opDirectorName = opDirectorName;
    }

    public String getOpDirectorPhone() {
        return opDirectorPhone;
    }

    public void setOpDirectorPhone(String opDirectorPhone) {
        this.opDirectorPhone = opDirectorPhone;
    }

    public String getBdDirectorName() {
        return bdDirectorName;
    }

    public void setBdDirectorName(String bdDirectorName) {
        this.bdDirectorName = bdDirectorName;
    }

    public String getBdPDirectorPhone() {
        return bdPDirectorPhone;
    }

    public void setBdPDirectorPhone(String bdPDirectorPhone) {
        this.bdPDirectorPhone = bdPDirectorPhone;
    }

    public String getMallDirectorName() {
        return mallDirectorName;
    }

    public void setMallDirectorName(String mallDirectorName) {
        this.mallDirectorName = mallDirectorName;
    }

    public Integer getCooperateTerminalNumber() {
        return cooperateTerminalNumber;
    }

    public void setCooperateTerminalNumber(Integer cooperateTerminalNumber) {
        this.cooperateTerminalNumber = cooperateTerminalNumber;
    }

    public Integer getDailyPeople() {
        return dailyPeople;
    }

    public void setDailyPeople(Integer dailyPeople) {
        this.dailyPeople = dailyPeople;
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

    public String getMold() {
        return mold;
    }

    public void setMold(String mold) {
        this.mold = mold;
    }

    public Integer getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(Integer businessStatus) {
        this.businessStatus = businessStatus;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public MallAddressVO getMallAddress() {
        return mallAddress;
    }

    public void setMallAddress(MallAddressVO mallAddress) {
        this.mallAddress = mallAddress;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTransInfor() {
        return transInfor;
    }

    public void setTransInfor(String transInfor) {
        this.transInfor = transInfor;
    }

    public List<ParkingVO> getParking() {
        return parking;
    }

    public void setParking(List<ParkingVO> parking) {
        this.parking = parking;
    }



    public String getAppearPic() {
        return appearPic;
    }

    public void setAppearPic(String appearPic) {
        this.appearPic = appearPic;
    }

    public String getWebAppearPic() {
        return webAppearPic;
    }

    public void setWebAppearPic(String webAppearPic) {
        this.webAppearPic = webAppearPic;
    }

    public String getTraffPic() {
        return traffPic;
    }

    public void setTraffPic(String traffPic) {
        this.traffPic = traffPic;
    }

    public String getIntroPic() {
        return introPic;
    }

    public void setIntroPic(String introPic) {
        this.introPic = introPic;
    }

    public String getTerminalLogo() {
        return terminalLogo;
    }

    public void setTerminalLogo(String terminalLogo) {
        this.terminalLogo = terminalLogo;
    }

    public String getWechatPic() {
        return wechatPic;
    }

    public void setWechatPic(String wechatPic) {
        this.wechatPic = wechatPic;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Long getShopNum() {
        return shopNum;
    }

    public void setShopNum(Long shopNum) {
        this.shopNum = shopNum;
    }

	public Integer getMallValid() {
		return mallValid;
	}

	public void setMallValid(Integer mallValid) {
		this.mallValid = mallValid;
	}

	public Boolean getTerminalMall() {
		return terminalMall;
	}

	public void setTerminalMall(Boolean terminalMall) {
		this.terminalMall = terminalMall;
	}

	public boolean isHasCustomCategory() {
		return hasCustomCategory;
	}

	public void setHasCustomCategory(boolean hasCustomCategory) {
		this.hasCustomCategory = hasCustomCategory;
	}

	public String getMallGroupId() {
		return mallGroupId;
	}

	public void setMallGroupId(String mallGroupId) {
		this.mallGroupId = mallGroupId;
	}

	public String getMallLevel() {
		return mallLevel;
	}

	public void setMallLevel(String mallLevel) {
		this.mallLevel = mallLevel;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getLastUpdateId() {
		return lastUpdateId;
	}

	public void setLastUpdateId(String lastUpdateId) {
		this.lastUpdateId = lastUpdateId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getLastUpdateName() {
		return lastUpdateName;
	}

	public void setLastUpdateName(String lastUpdateName) {
		this.lastUpdateName = lastUpdateName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List getParentIds() {
		return parentIds;
	}

	public void setParentIds(List parentIds) {
		this.parentIds = parentIds;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getValidReason() {
		return validReason;
	}

	public void setValidReason(String validReason) {
		this.validReason = validReason;
	}

	public String getBusinessStatusReason() {
		return businessStatusReason;
	}

	public void setBusinessStatusReason(String businessStatusReason) {
		this.businessStatusReason = businessStatusReason;
	}

	public String getId() {
		return id;
	}

	public String getMerlogPic() {
		return merlogPic;
	}

	public void setMerlogPic(String merlogPic) {
		this.merlogPic = merlogPic;
	}

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}