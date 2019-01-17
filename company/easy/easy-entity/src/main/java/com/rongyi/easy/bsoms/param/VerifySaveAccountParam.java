package com.rongyi.easy.bsoms.param;

import java.io.Serializable;
import java.util.Date;

public class VerifySaveAccountParam  implements Serializable{
	
	private static final long serialVersionUID = 385086252904386601L;
	
	private Integer id;
	private Integer verifyStatus;//审核状态
	private String reason;//不通过理由
	private Integer industryId;
	private Integer industryVersionId;
	private Integer childAccountNum;
	private String validStartAtStamp;//有效期开始时间戳
	private String validEndAtStamp;//有效期结束时间戳
	private boolean bShowChiefInfo;
	private String mallMid;
	private String shopMid;
	private Integer isOpenQrCode;//是否开放用户专属二维码  0:否,1:是
	private Integer isAllowBindingWechat ;//是否允许分店绑定微信  0:否,1:是
	private String synTarget;//终端类型
	private Integer defaultTerminal ; //默认终端:0 无默认终端,1 容易逛,2 微信,3 终端机'
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVerifyStatus() {
		return verifyStatus;
	}
	public void setVerifyStatus(Integer verifyStatus) {
		this.verifyStatus = verifyStatus;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getIndustryId() {
		return industryId;
	}
	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}
	public Integer getIndustryVersionId() {
		return industryVersionId;
	}
	public void setIndustryVersionId(Integer industryVersionId) {
		this.industryVersionId = industryVersionId;
	}
	public Integer getChildAccountNum() {
		return childAccountNum;
	}
	public void setChildAccountNum(Integer childAccountNum) {
		this.childAccountNum = childAccountNum;
	}
	public boolean isbShowChiefInfo() {
		return bShowChiefInfo;
	}
	public void setbShowChiefInfo(boolean bShowChiefInfo) {
		this.bShowChiefInfo = bShowChiefInfo;
	}
	
	public String getMallMid() {
		return mallMid;
	}
	public void setMallMid(String mallMid) {
		this.mallMid = mallMid;
	}
	public String getShopMid() {
		return shopMid;
	}
	public void setShopMid(String shopMid) {
		this.shopMid = shopMid;
	}
	
	public Date getValidStartAt(){
		Date date = null;
		try {
			if(this.validStartAtStamp != null){
				long lt = new Long(this.validStartAtStamp);
				date = new Date(lt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return date;
		}
	}
	
	public Date getValidEndAt(){
		Date date = null;
		try {
			if(this.validEndAtStamp != null){
				long lt = new Long(this.validEndAtStamp);
				date = new Date(lt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return date;
		}
	}
	
	public String getValidStartAtStamp() {
		return validStartAtStamp;
	}
	public void setValidStartAtStamp(String validStartAtStamp) {
		this.validStartAtStamp = validStartAtStamp;
	}
	public String getValidEndAtStamp() {
		return validEndAtStamp;
	}
	public void setValidEndAtStamp(String validEndAtStamp) {
		this.validEndAtStamp = validEndAtStamp;
	}
	public Integer getIsOpenQrCode() {
		return isOpenQrCode;
	}
	public void setIsOpenQrCode(Integer isOpenQrCode) {
		this.isOpenQrCode = isOpenQrCode;
	}
	public Integer getIsAllowBindingWechat() {
		return isAllowBindingWechat;
	}
	public void setIsAllowBindingWechat(Integer isAllowBindingWechat) {
		this.isAllowBindingWechat = isAllowBindingWechat;
	}
	public String getSynTarget() {
		return synTarget;
	}
	public void setSynTarget(String synTarget) {
		this.synTarget = synTarget;
	}
	public Integer getDefaultTerminal() {
		return defaultTerminal;
	}
	public void setDefaultTerminal(Integer defaultTerminal) {
		this.defaultTerminal = defaultTerminal;
	}
	@Override
	public String toString() {
		return "VerifySaveAccountParam [id=" + id + ", verifyStatus="
				+ verifyStatus + ", reason=" + reason + ", industryId="
				+ industryId + ", industryVersionId=" + industryVersionId
				+ ", childAccountNum=" + childAccountNum
				+ ", validStartAtStamp=" + validStartAtStamp
				+ ", validEndAtStamp=" + validEndAtStamp + ", bShowChiefInfo="
				+ bShowChiefInfo + ", mallMid=" + mallMid + ", shopMid="
				+ shopMid + ", isOpenQrCode=" + isOpenQrCode
				+ ", isAllowBindingWechat=" + isAllowBindingWechat
				+ ", synTarget=" + synTarget + ", defaultTerminal="
				+ defaultTerminal + "]";
	}
	
	
}