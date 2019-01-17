package com.rongyi.easy.malllife.param.invitation;


import com.rongyi.easy.rmmm.base.BaseParam;

import java.io.Serializable;

/*
 * Description:  
 * time:  2016/8/25
 * History: 变更记录
 * <author>           <time>             <version>        <desc>
 * yuzhijian             2016/8/25              1.0            创建文件
 * Author   yuzhijian@rongyi.com || yuxia2217@163.com
 * Copyright (C),上海容易网电子商务有限公司
 */
public class InvitationCodeParam extends BaseParam {

    private static final long serialVersionUID = 1L;

    private String invitCode; //邀请码

    private String userPhone;//手机号

    private Integer pageSize;//页码

    private Integer currentPage;//当前页

    public String getInvitCode() {
        return invitCode;
    }

    public void setInvitCode(String invitCode) {
        this.invitCode = invitCode;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

	@Override
	public String toString() {
		return "InvitationCodeParam [invitCode=" + invitCode + ", userPhone="
				+ userPhone + ", pageSize=" + pageSize + ", currentPage="
				+ currentPage + "]";
	}
}