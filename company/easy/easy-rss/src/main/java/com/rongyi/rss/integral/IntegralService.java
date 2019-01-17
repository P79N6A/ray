package com.rongyi.rss.integral;

import net.sf.json.JSONObject;
import com.rongyi.easy.integral.vo.IntegralRecordVO;

/**
 * 积分
* @Title: IntegralService.java 
* @Package com.rongyi.integral.service 
* @Description: 
* @author zzq 
* @date 2015-7-17 下午5:13:51
 */
public interface IntegralService {  
	
	/**
	 * 修改积分
	 * @param integral
	 */
	public JSONObject addOrSubScore(IntegralRecordVO integral);
	
	/**
	 * 根据用户id查询用户积分
	 * @param userId
	 */
	public JSONObject getScoreByUserId(String userId);
	
	/**
	 * 根据规则类型获取规则信息
	 * @param scoreRuleEnum
	 * @return
	 */
	public JSONObject  getRuleByType(int scoreRuleEnum);

	/**
	 * 根据规则类型获取规则比率
	 * @param scoreRuleEnum
	 * @return 
	 */
	public JSONObject  getRuleRateByType(int scoreRuleEnum);
	/**
	 * 获取积分记录
	 * @param userid
	 * @param scoreRuleEnum
	 * @param actionType
	 * @param row
	 * @param page
	 * @return
	 */
	public JSONObject  getScoreRecord(String userid,int actionType,int row,int page);
	/**
	 * 根据订单号获取积分记录
	 * @param orderSn
	 * @return
	 */
	public IntegralRecordVO getIntegralRecordByOrderSn(String orderSn);
	
	/**
	 * 根据条件查询用户积分信息
	 * @param userid
	 * @param source
	 * @param type
	 * @param action
	 * @param update_at
	 * @param endTime 
	 * @return
	 */
	public JSONObject getScoreRecordByConditioin(String userid, int source ,int type,int action ,String  beginTime,String endTime, int page, int row);

}