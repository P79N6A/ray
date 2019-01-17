package com.rongyi.easy.mcmc.vo;

import com.rongyi.easy.ryoms.entity.WechatInfoVo;

import java.io.Serializable;
import java.util.List;

public class MallTerminalVO implements Serializable {
	private static final long serialVersionUID = -7647318295364366168L;

	// 1 表示绑定 0 表示未绑定
	//private Integer wechat;	 		// 是否绑定微信终端

	private List<WechatInfoVo> wechatInfoVoList;
	private Integer mallTerminal;	// 商场终端
	private String rongyiguangStatus;//容易逛是否展示  1是 0否

	private String miniprogramStatus;//小程序是否展示  1是 0否

	public List<WechatInfoVo> getWechatInfoVoList() {
		return wechatInfoVoList;
	}

	public void setWechatInfoVoList(List<WechatInfoVo> wechatInfoVoList) {
		this.wechatInfoVoList = wechatInfoVoList;
	}

	public Integer getMallTerminal() {
		return mallTerminal;
	}
	public void setMallTerminal(Integer mallTerminal) {
		this.mallTerminal = mallTerminal;
	}

	public String getRongyiguangStatus() {
		return rongyiguangStatus;
	}

	public void setRongyiguangStatus(String rongyiguangStatus) {
		this.rongyiguangStatus = rongyiguangStatus;
	}

	public String getMiniprogramStatus() {
		return miniprogramStatus;
	}

	public void setMiniprogramStatus(String miniprogramStatus) {
		this.miniprogramStatus = miniprogramStatus;
	}

	@Override
	public String toString() {
		return "MallTerminalVO [wechatInfoVoList=" + wechatInfoVoList + ", rongyiguangStatus=" + rongyiguangStatus+ ", mallTerminal=" + mallTerminal +", miniprogramStatus=" + miniprogramStatus+ "]";
	}

}