/** 
* @Title: ROAShopSolrService.java 
* @Package com.rongyi.rss.solr 
* @Description: TODO
* @author 朱泽 zhuze@rongyi.com
* @date 2015年6月2日 下午4:04:32 
* @version V1.0   
* Copyright (C),上海容易网电子商务有限公司
*/
package com.rongyi.rss.solr;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

/** 
 * 
 */
public interface ROAShopSolrService {

	/**
	 * @param params
	 * @param currentpage
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public /*List<String>*/Map<String,Object> getShopPage(Map params, int currentpage, int pagesize)
			throws Exception;

	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<String> getShops(Map params) throws Exception;
	
	List<ObjectId> sortShopByLocation(List<ObjectId> idList, List<Double> position);

}