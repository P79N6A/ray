package com.rongyi.rss.content;

import java.util.Map;

import com.rongyi.core.bean.ResponseVO;
import com.rongyi.easy.content.entity.param.ContentHelpParam;
import com.rongyi.easy.content.entity.param.SpecialCellParam;
import com.rongyi.easy.content_v2.vo.RaidersHomeVo;

/**
 * 
* @ClassName: ISpecialSellService 
* @Description: 特卖列表查询接口
* @author shaozhou 
* @date 2015年11月18日 上午11:11:42 
*
 */
public interface ISpecialSellService {
	/**
	 * 
	* @Title: pagingContentForumList 
	* @Description: 查询list
	* @param @param param
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ResponseVO    返回类型 
	* @author shaozhou 
	* @date 2015年11月18日 下午8:25:10
	* @throws
	 */
	public ResponseVO pagingContentForumList(SpecialCellParam param) throws Exception;
	
	/**
	 * 查询APP首页潮人攻略展示
	 * @param paramMap 
	 *               
	 * @return
	 */
	public RaidersHomeVo getRaidersHomeVo(Map paramMap)throws Exception;
	
	/**
	 * 查询APP潮人攻略列表
	 * @param  paramMap
	 *              currentPage  不传默认1
	 *              pageSize  不传默认10
	 *              version  文章版本号
	 *              appVersion  app版本号
	 * @return
	 * @throws Exception
	 */
	public ResponseVO getRaidersAppList(Map paramMap)throws Exception;
}