package com.rongyi.rss.roa;

import com.rongyi.core.common.PagingVO;
import com.rongyi.easy.msgcenter.InviteRecordSearchParam;
import com.rongyi.easy.msgcenter.OldPushNewParam;
import com.rongyi.easy.msgcenter.TriggerActivityParam;
import com.rongyi.easy.msgcenter.vo.InviteRelationVo;
import com.rongyi.easy.msgcenter.vo.OldPushNewInviteTotalVo;
import com.rongyi.easy.msgcenter.vo.TriggerActivityVo;

import java.util.Date;
import java.util.List;

public interface ROATriggerActivityService {
	 /**
     * 交易2
     *  Timestamp nowTime,Integer pushCondition,Integer tradeAmount,Integer tradeRange,String userId,String shopId
     * @param StartAt ,
     * pushCondition:'1:注册，2交易，3邀请，4激活',
     * TradeStartAmount : 交易金额,
      * tradeRange为1，shopId为空，
     * shopId:
     *  *'交易品类;“1,2”，1商品，2卡券',
     *  goodsId 商品或卡券id
     * ============
     * 邀请3
     * String userId,Timestamp invityTime,Integer pushCondition,Integer invity,Integer fruitful,Integer fruitfulRange
     *  @param userId
	 * @param invityTime 邀请时间
	 * @param pushCondition  '1:注册，2交易，3邀请，4激活',
	 * @param invity  '邀请人：1不限，2导购，3买手，4容易逛用户',
	 * @param fruitful '获益人：1邀请人，2被邀请人',
	 * @param fruitfulRange  '获益场景 1:注册，2注册并交易',
     * @throws 0,失败，1成功
     */
    public int triggerMessage(TriggerActivityParam param) ;
    /**
     * 判断后台是否配置了注册红包，并给相应用户发送配置的红包
     * @param param
     * @return
     */
    public int getRegisteCoupons(TriggerActivityParam param);

    /**
     * 查询有效的老推新红包 position 1:注册，2交易，3邀请，4激活,5分享 6老推新
     * @return
     */
    public TriggerActivityVo findTriggerActivityVO(int pushCondition);

    /**
     * 新用户注册/交易 根据老用户邀请码领取红包
     * @param param
     * @return
     */
    public int getCouponsByOldPushCode(OldPushNewParam param);

    /**
     * 根据老用户userId查询老用户的领取红包的详情
     * @param userId
     * @return
     */
    public PagingVO<InviteRelationVo> getInviteRecordByUserId(InviteRecordSearchParam param);

    /**
     * 根据老用户id获取老用户获取红包汇总信息
     * @param userId
     * @return
     */
    public OldPushNewInviteTotalVo getInviteRecordTotalVo(String userId);

    /**
     * 根据老用户id获取是否有最新的老推新记录
     * @param userId
     * @return
     */
    public int getUpTodateInviteRecord(String userId,Date searchTime);
    /**
     * 获取当前新人注册红包的金额
     * @return
     */
   public Double getExistRegisteCouponPrice();
}