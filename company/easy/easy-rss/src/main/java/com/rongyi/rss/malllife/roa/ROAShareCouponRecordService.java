package com.rongyi.rss.malllife.roa;

import java.util.List;

import com.rongyi.easy.rmmm.param.ShareCouponParam;
import com.rongyi.easy.usercenter.entity.ShareCouponRecordEntity;

public interface ROAShareCouponRecordService {
	
	/**
	 * 
	 * @param  、shareId、orderNum、orderType、price
	 * @return
	 * @throws Exception
	 */
	public int insertShareCouponRecord(ShareCouponParam param) throws Exception;
	
	/**
	 * 
	 * @param  、nickName、headImg、couponCode、orderNum、shareId
	 * @return
	 * @throws Exception
	 */
    public int updateShareCouponRecord(ShareCouponParam param) throws Exception;
	
	/**
	 * 根据分享红包id获取已领取的记录列表
	 * @return
	 * @throws Exception
	 */
	public List<ShareCouponRecordEntity> selectShareCouponByShareId(String shareId,String orderNo) throws Exception;
	
	/**
	 * 查询用户已领取的记录
	 * @param  、orderNo、openId、type
	 * @return
	 * @throws Exception
	 */
	public ShareCouponRecordEntity selectShareCouponByOpenId(ShareCouponParam param)  throws Exception;
	
	/**
	 * 剩余未领取红包数量
	 * @param orderNum
	 * @param shareId
	 * @return
	 * @throws Exception
	 */
	public int getRemainCouponByOrderNum(String orderNum, String shareId)  throws Exception;
	
	/**
	 * 判断订单号是否已生成红包记录
	 * @param orderNo
	 * @return  true已生成  false未生成
	 * @throws Exception
	 */
	public boolean checkShareCouponByOrderNo(String orderNo)  throws Exception;

}