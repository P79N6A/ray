package com.rongyi.rss.code;

import com.rongyi.core.common.PagingVO;
import com.rongyi.easy.code.*;
import com.rongyi.easy.coupon.entity.CouponChannel;

import java.util.List;
import java.util.Map;

/**
 * Created by shaozhou on 2016/6/29.
 * 促销推广码service层
 */
public interface HannelsService {
    /**
     * 查询促销推广码数量
     * @param hannelsSearchParam
     * @return
     */
    int count(HannelsSearchParam hannelsSearchParam) throws Exception;
    /**
     * 查询促销推广码列表
     * @param hannelsSearchParam
     * @return
     */
    HannelResponseVO list(HannelsSearchParam hannelsSearchParam) throws Exception;
    /**
     * 当选择渠道为买手，导购和店长时，有效期内有效的推广码互斥
     * @param hannelsSaveParam
     * @return
     */
    boolean validMutex(HannelsSaveParam hannelsSaveParam) throws Exception;

    /**
     * 保存促销推广码数据
     * @param saveMap
     * @throws Exception
     */
    void save(Map<String, Object> saveMap) throws Exception;

    /**
     * 修改促销推广码状态
     * @param map
     * @throws Exception
     */
    void operateHannelStatus(Map<String,Object> map) throws Exception;

    /**
     * 通过id查询促销推广码详情
     * @param i
     * @return
     */
    HannelsVO info(int i);

    /**
     * 查询渠道列表数量
     * @param param
     * @return
     */
    PagingVO<CouponChannel> couponChannelPagingVO(ChannelSearchParam param);

    /**
     * 通过id获取促销码
     * @param i
     * @return
     */
    Hannels getHannelsById(int i);

    /**
     * 校验参数
     * @param hannelsSaveParam
     * @return
     */
    boolean validParam(HannelsSaveParam hannelsSaveParam);

    /**
     * id查询hannels信息
     * @param hannelsId
     * @return
     */
    HannelsVO selectById(int hannelsId);

    /**
     * @param channelId 渠道id
     * @param type 0：渠道邀请码；1：渠道推广码
     * @return
     */
    Hannels findCurrentHannels(Integer type,Integer channelId);

    /**
     * 获取所有的推广码各个状态的数量
     * @return
     */
    HannelResponseVO allcount();

    /**
     * 根据用户id 和 hannelsType ,查询该用户关联的且当前有效的hannels
     * @param userId
     * @param hannelsType
     * @return
     */
    List<Hannels> getHannelsByUserId(Integer userId,Integer hannelsType);

    /**
     * 根据商场和店铺id 和 hannelsType ,查询该用户关联的且当前有效的hannels
     * @param assignId
     * @param hannelsType
     * @return
     */
    List<Hannels> getHannelsByAssignId(String assignId,Integer hannelsType);

    /**
     * 查询当前是否存在关联全部店员的促销推广
     * @return
     */
    List<Hannels> findIsAllUser();
}