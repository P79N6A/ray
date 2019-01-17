package com.rongyi.easy.activitymanage.vo.groupBuy;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/***
 * 团信息
 * @author caohongjiang
 *
 */
public class GroupInfo implements Serializable{


	private static final long serialVersionUID = -1213255267725151298L;
	/**
	 * 团id
	 */
	private Long groupId;
	
	/***
	 * 活动id
	 */
	private Integer activityId;
	
	
	/***
	 * 商品id
	 */
	private String goodId;
	
	/**
	 * 团创建时间
	 */
	private Date createAt;
	
	/**
	 * 团创关闭时间
	 */
	private Date endAt;
	
	/***
	 * 成团人数  :3人团   5 人团
	 */
	private Integer  groupPeopleLimit;

	/**
	 * 最大成团人数
	 */
	private Integer groupPeopleMaxLimit;
	
	
	private List<GroupDetail> groupDetail;
	
	
	
	/***
	 * 团状态:
	 *  第一个人发起,未支付,等待支付--   0
	 *    发起,未支付,开团失败--- 1
	 *    组团进行中 			2
	 *    组团成功			3
	 *    组团失败:团时间到了,人数不够,自动失败 4
	 *    活动下线,团失败 5
	 *    
	 */
	private Integer  state;

	private Integer type;//8普通团，9超级团


	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getGroupPeopleMaxLimit() {
		return groupPeopleMaxLimit;
	}

	public void setGroupPeopleMaxLimit(Integer groupPeopleMaxLimit) {
		this.groupPeopleMaxLimit = groupPeopleMaxLimit;
	}

	public List<GroupDetail> getGroupDetail() {
		return groupDetail;
	}




	public void setGroupDetail(List<GroupDetail> groupDetail) {
		this.groupDetail = groupDetail;
	}




	public long getGroupId() {
		return groupId;
	}




	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}




	public int getActivityId() {
		return activityId;
	}




	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}




	public String getGoodId() {
		return goodId;
	}




	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}




	public Date getCreateAt() {
		return createAt;
	}




	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}




	public Date getEndAt() {
		return endAt;
	}




	public void setEndAt(Date endAt) {
		this.endAt = endAt;
	}


	public Integer getGroupPeopleLimit() {
		return groupPeopleLimit;
	}

	public void setGroupPeopleLimit(Integer groupPeopleLimit) {
		this.groupPeopleLimit = groupPeopleLimit;
	}

	public int getState() {
		return state;
	}




	public void setState(int state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
	
	

}