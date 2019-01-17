package com.rongyi.rss.ryoms.callcenter;

import com.rongyi.core.bean.ResponseVO;
import com.rongyi.easy.malllife.param.wish.WishParam;
import com.rongyi.easy.malllife.param.wish.WishSearchParam;
import com.rongyi.easy.malllife.vo.wish.WishListVO;

import java.util.List;

/**
 * Created by yangyang on 2016/8/25.
 * 心愿单服务
 */
public interface WishListService {

    /**
     * 心愿单回复
     * @param id
     * @param response
     * @param userName
     * @return
     */
    public boolean resWishList(int id,String response,String userName);

    /**
     * 已查看心愿单(红点，dubbo-redis)
     * @param userId  容易逛用户id
     * @return
     */
    public boolean readingWishList(String userId);

    /**
     * 在redis中根据用户id查询是否有已回复为查看的心愿单
     * @param userId 容易逛用户id
     * @return
     */
    public boolean queryRedisWishList(String userId);

    /**
     * 心愿单列表
     * @param param
     * @return
     */
    public ResponseVO wishLists(WishSearchParam param);

    /**
     * 心愿单详情
     * @param id
     * @return
     */
    public WishListVO wishListDetail(int id);

    /**
     * 提交心愿单
     * @param param
     * @return
     */
    public boolean saveWishList(WishParam param);


}