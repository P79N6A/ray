package com.rongyi.easy.bdata.entity;

import org.apache.commons.lang.StringUtils;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Desc: floor info
 * User: chris
 * Date: 2015/10/25 12:52
 */

@Entity(value="zones", noClassnameStored = true)
public class Floor implements Serializable {
    @Id
    private String id;

    private String name;
    private Integer systemStatus;
    private Integer position;
    private List<String> parent_ids;
    private String parent_id;
    private String navigation_pic;
    private String pathImg;
    private String picture;
    //private String swfpic;//步步高新增楼层动态导航图片 支持swf svg格式
    private Date   created_at;
    private Integer mall_valid ;

    private ObjectId building_id;
    private String swf;//swf图--商家后台用的
    private String fmap;//fmap图--商家后台用的
    private String aliasename;
    private String aliasname;
    private String   tmap;//图聚版地图
    private Integer system_status;//1 隐藏 0正常
    private String thirdFloorId;//第三方楼层id
    private String configFile;//配置文件
    private String simpleFloorName;//楼层名
    private String androidPic;//安卓楼层图片

    public String getThirdFloorId() {
        return thirdFloorId;
    }

    public void setThirdFloorId(String thirdFloorId) {
        this.thirdFloorId = thirdFloorId;
    }

    public Integer getSystem_status() {
        return system_status;
    }

    public void setSystem_status(Integer system_status) {
        this.system_status = system_status;
    }

    public String getTmap() {
        return tmap;
    }

    public void setTmap(String tmap) {
        this.tmap = tmap;
    }

    public String getFullTmap() {
        if (StringUtils.isNotBlank(tmap)) {
            return "http://rongyi.b0.upaiyun.com/system/mall_area/picture/" + id + "/" + tmap;
        } else {
            return null;
        }
    }

    public ObjectId getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(ObjectId building_id) {
        this.building_id = building_id;
    }

    public String getAliasename() {
        return aliasename;
    }

    public void setAliasename(String aliasename) {
        this.aliasename = aliasename;
    }

    public String getAliasname() {
        return aliasname;
    }

    public void setAliasname(String aliasname) {
        this.aliasname = aliasname;
    }

    public String getSwf() {
		return swf;
	}
	public String getFmap() {
		return fmap;
	}
	
	public String getFullFmap() {
		 if (StringUtils.isNotBlank(fmap)) {
	            return "http://rongyi.b0.upaiyun.com/system/mall_area/picture/" + id + "/" + fmap;
	        } else {
	            return null;
	        }
	}
	
	public void setFmap(String fmap) {
		this.fmap = fmap;
	}
	
	public String getFullSwf() {
		 if (StringUtils.isNotBlank(swf)) {
	            return "http://rongyi.b0.upaiyun.com/system/mall_area/picture/" + id + "/" + swf;
	        } else {
	            return null;
	        }
	}
	
	public void setSwf(String swf) {
		this.swf = swf;
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

    public Integer getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(Integer systemStatus) {
        this.systemStatus = systemStatus;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public List<String> getParent_ids() {
        return parent_ids;
    }

    public void setParent_ids(List<String> parent_ids) {
        this.parent_ids = parent_ids;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getNavigation_pic() {
        return navigation_pic;
    }

    public String getFullNavigation_pic() {
        if (StringUtils.isNotBlank(navigation_pic)) {
            return "http://rongyi.b0.upaiyun.com/system/mall_area/navigation_pic/" + (created_at.getYear()+1900) + "/" + (created_at.getMonth() + 1) + "/" + id + "/" + navigation_pic;
        } else {
            return null;
        }
    }

    public void setNavigation_pic(String navigation_pic) {
        this.navigation_pic = navigation_pic;
    }

    public String getPathImg() {
        return pathImg;
    }

    public String getFullPathImg() {
        if (StringUtils.isNotBlank(pathImg)) {
            return "http://rongyi.b0.upaiyun.com/system/mall_area/picture/" + id + "/" + pathImg;
        } else {
            return null;
        }
    }

    public void setPathImg(String pathImg) {
        this.pathImg = pathImg;
    }

    public String getPicture() {
        return picture;
    }

    public String getFullPicture() {
        if (StringUtils.isNotBlank(picture)) {
            return "http://rongyi.b0.upaiyun.com/system/mall_area/picture/" + id + "/" + picture;
        } else {
            return null;
        }
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


	public Integer getMall_valid() {
		return mall_valid;
	}

	public void setMall_valid(Integer mall_valid) {
		this.mall_valid = mall_valid;
	}
	
    public String getConfigFile() {
		return configFile;
	}

	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}

	public String getFullConfigFile() {
		if (StringUtils.isNotBlank(configFile)) {
            return "http://rongyi.b0.upaiyun.com/system/mall_area/picture/" + id + "/" + configFile;
        } else {
            return null;
        }
	}
	
	public String getSimpleFloorName() {
		return simpleFloorName;
	}

	public void setSimpleFloorName(String simpleFloorName) {
		this.simpleFloorName = simpleFloorName;
	}
	
	public String getAndroidPic() {
		return androidPic;
	}

	public void setAndroidPic(String androidPic) {
		this.androidPic = androidPic;
	}
	
	public String getFullAndroidPic() {
		if (StringUtils.isNotBlank(androidPic)) {
            return "http://rongyi.b0.upaiyun.com/system/mall_area/picture/" + id + "/" + androidPic;
        } else {
            return null;
        }
	}
	
	@Override
	public String toString() {
		return "Floor [id=" + id + ", name=" + name + ", systemStatus="
				+ systemStatus + ", position=" + position + ", parent_ids="
				+ parent_ids + ", parent_id=" + parent_id + ", navigation_pic="
				+ navigation_pic + ", pathImg=" + pathImg + ", picture="
				+ picture + ", created_at=" + created_at + ", mall_valid="
				+ mall_valid + ", swf=" + swf + ", fmap=" + fmap
				+ ", aliasename=" + aliasename + ", aliasname=" + aliasname
				+ ", tmap=" + tmap + ", system_status=" + system_status
				+ ", thirdFloorId=" + thirdFloorId + ", configFile="
				+ configFile + ", simpleFloorName=" + simpleFloorName
				+ ", androidPic=" + androidPic + "]";
	}
	
}