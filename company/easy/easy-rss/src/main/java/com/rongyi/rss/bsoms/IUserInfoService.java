package com.rongyi.rss.bsoms;

import java.util.List;
import java.util.Map;

import com.rongyi.core.common.PagingVO;
import com.rongyi.easy.bdata.entity.HierarchicalMerchantInfo;
import com.rongyi.easy.bsoms.entity.BAuthorities;
import com.rongyi.easy.bsoms.entity.CertifiedCheckInfo;
import com.rongyi.easy.bsoms.entity.SessionUserInfo;
import com.rongyi.easy.bsoms.entity.UserInfo;
import com.rongyi.easy.bsoms.param.VerifySaveAccountParam;
import com.rongyi.easy.bsoms.vo.BsUserVO;
import com.rongyi.easy.bsoms.vo.BusinessAccountVO;
import com.rongyi.easy.bsoms.vo.UserBindingVO;
import com.rongyi.easy.mallshop.MallShopException;
import com.rongyi.easy.rmmm.param.user.UserManagerParam;
import com.rongyi.easy.roa.vo.distributor.UserInfoForDistributorVO;
import com.rongyi.easy.ryoms.param.buyer.BuyerCheckParam;
import com.rongyi.easy.ryoms.param.buyer.BuyerListParam;
import com.rongyi.easy.ryoms.user.vo.BuyerDetailVO;
import com.rongyi.easy.ryoms.user.vo.BuyerListVO;
import com.rongyi.easy.va.vo.VirtualAccountVO;

/**
 * 账户用户相关
 * @author hebo 2015/07/17
 *
 */
public interface IUserInfoService {

	/**
	 * 分页查询商家账户列表
	 * @param paramsMap
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PagingVO<BusinessAccountVO> searchAccountListByMap(Map<String, Object> paramsMap, int currentPage, int pageSize);

	/**
	 * 查询商家账户列表 不分页
	 * @param paramsMap
	 *           mallMids
	 *           shopMids
	 *           identity
	 *           identitys
	 * @return
	 */
	List<BusinessAccountVO> searchAccountListByMap(Map<String, Object> paramsMap);

	
	/**
	 * 资金账户：冻结/解冻
	 * @param userId
	 * @param isSuspended
	 * @return
	 */
	boolean updateAccountSuspended(String userId, boolean isSuspended, String stopReason);

	/**
	 * 根据id修改账户状态：启用/停用
	 * @param id
	 */
	boolean updateAccountStatus(int id, int accountStatus, String stopReason, Integer userId)throws MallShopException,Exception;

	UserInfo getUserInfoById(Integer id);

	/**
	 * 查询商家账户信息（包含关联信息）
	 * @param id
	 * @return
	 */
	BusinessAccountVO getUserDetailInfoById(Integer id);

	/**
	 * 新增商家账号
	 * @param userParam
	 * @return
	 * @throws MallShopException
	 * @throws Exception
	 */
	boolean insertUserInfo (UserManagerParam userParam)throws MallShopException, Exception;

	/**
	 * 修改商家账号
	 * @param param
	 * @param merUserId
	 * @return
	 * @throws Exception
	 */
	public Boolean updateMerAccountInfo(UserManagerParam param,Integer merUserId) throws Exception;

	/**
	 * 虚拟账户查询
	 *
	 * @date 2015年8月24日
	 * @param userId
	 *            用户id
	 * @return
	 */
	public VirtualAccountVO queryVirtualAccount(String userId);

	/**
	 * 获取角色下的所有账户（）
	 * @param roleId
	 * @return
	 */
	public List<Integer> getAllUserIdByRole(Integer roleId);

	/**
	 * 修改个人信息
	 * @param paramsMap
	 * @return
	 */
	public boolean updateUserInfo(UserManagerParam userManagerParam) throws Exception;

	/**
	 * 修改个人信息
	 * @param paramsMap 参数
	 * @return 结果
	 * @throws Exception
	 */
	boolean updateSelfUserInfo(Map<String,Object> paramsMap) throws Exception;

	UserInfo getUserByMap(Map<String, Object> paramsMap);

	/**
	 * 得到用户的所有权限值
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<String> getAuthsValueByUserId(Integer userId) throws Exception;

	/**
	 * 得到用户的特殊权限
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<BAuthorities> getUserAuthsByUserId(Integer userId) throws Exception;

	/**
	 * 得到用户的角色权限
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<BAuthorities> getRoleAuthsByUserId(Integer userId) throws Exception;

	/**
	 * 通过service ticket获取登录用户信息
	 * 返回Map{userInfo:com.rongyi.easy.bsoms.entity.SessionUserInfo,authorities:List<String>}
	 * @param bsst
	 * @return
	 * @throws Exception
	 */
	public Map getSessionUserFromRedis(String bsst,boolean bConvertToObj) throws Exception;


	/**
	 * 查询买手账号列表
	 * @param paramsMap
	 * @param currpage
	 * @param pageSize
	 * @return
	 */
	 PagingVO<BusinessAccountVO> getBuyerInfoListByMap(Map<String, Object>paramsMap,int currpage,int pageSize);

	/**
	 * 验证用户信息是否已存在
	 * @param paramsMap
	 * @return
	 * @throws Exception
	 */
	public boolean validateUserByUserParam(UserInfo userInfo)throws Exception;

	/**
	 * 查询买手账号详情
	 * @param id 用户ID
	 * @return
	 */
	public BusinessAccountVO getBuyerDetailById(Integer id);
	
	/**
	 * 查询买手账号详情
	 * @param id
	 * @return
	 */
	public BuyerDetailVO getBuyerDetailByBuyerId(Integer id);
	/**
	 * 根据角色ID查询关联账号
	 * @return
	 */
	public List<SessionUserInfo> getRelationUserListByRoleId(Map<String, Object> paramMap);


	/**
	 * 通过关联id（shopId,mallId,filialeId,brandId,shopId...）条件查询商家用户账户
	 * @param paramsMap
	 * @return
	 */
	List<UserInfo> getFullUserInfoByRelevanceId(Map<String, Object> paramsMap);

	/**
	 * 通过service ticket获取登录top页信息
	 * 返回Map{userInfo:com.rongyi.easy.bsoms.entity.SessionUserInfo,authorities:List<String>,logoutUrl}
	 * @param bsst
	 * @return
	 * @throws Exception
	 */
	public Map getBsTop(String bsst)throws Exception ;

	/**
	 * 查询各状态的用户数量
	 * @param map
	 * @return
	 */
	public Map<String, Integer> getUserStatusCount(Map map);

	/**
	 * 查询用户审核失败理由
	 * @param map
	 * @return
	 */
	public List<CertifiedCheckInfo> getCertifiedFailList(Map map);

	/**
	 * 审核用户信息
	 * @param paramMap
	 * @return
	 */
	public Map<String,Object> checkCertifiedUser(VerifySaveAccountParam param,Integer optId) throws MallShopException, Exception;

	/**
	 * 查询用户审核记录
	 * @param paramMap
	 * @return
	 */
	public List<CertifiedCheckInfo> getCheckListByUserId(Map paramMap);

	/**
	 * 根据用户ID查询用户列表（提供给推送）
	 * @param paramMap
	 *              userId  用户ID
	 *              currentPage 当前页  从1开始
	 *              pageSize 每页显示行数 （不分页不传）
	 * @return
	 */
	public List<UserInfo> getUserInfoListByUserId(Map paramMap) ;

	public Integer getUserBuyerIdByMobileAndIdentity(String mobile,Integer identity);

	/**
	 * 根据ID查询用户
	 * @param id ID
	 * @return 用户信息
	 */
	SessionUserInfo getSessionUserInfoById(Integer id);

	/**
	 * 查询用户数据
	 * @param paramMap
	 *           identity
	 *           shopId
	 *           mallId
	 *           isChief
	 * @return 数量
	 */
	int searchUserInfoCount(Map<String, Object> paramMap);

	public List<Map> getClassifiedAuthsByAccountId(Integer accountId)throws Exception;
	public boolean hasMerchantAccount(String merchantId,String type,Integer accountConfine)throws Exception;
	
	public UserInfo getUserConfineAccount(String merchantId,String merchantType,Integer accountConfine)throws Exception;

	public boolean insertBuyerInfo(UserManagerParam userManagerParam) throws MallShopException,Exception;
	
	/**
	 * 查询买手账号列表
	 * @param param
	 * @return
	 */
	public List<BuyerListVO> getBuyerList(BuyerListParam param);
	/**
	 * 查询买手账号总数量
	 * @param param
	 * @return
	 */
	public Integer getBuyerAccountListCount(BuyerListParam param);
	/**
	 * 审核买手账号
	 * @param param
	 * @param operatorId
	 * @return
	 */
	boolean checkBuyerUser(BuyerCheckParam param, Integer operatorId);
	
	/**
	 * 查询二级店铺账号列表
	 * @param currentPage 当前页从1开始
	 * @param pageSize  每页显示的数量
	 * @return
	 */
	public List<UserInfoForDistributorVO> getUserInfoForDistributorVOList(String mallId,String shopId,int currentPage,int pageSize);
	/**
	 * 查询二级店铺账号数量
	 * @return
	 */
	public Integer getUserInfoCountForDistributor(String mallId,String shopId);
	/**
	 * 新建分销商账号信息
	 * @param userManagerParam
	 * @return
	 * @throws MallShopException
	 * @throws Exception
	 */
	public String insertDistributorInfo(UserManagerParam userManagerParam) throws MallShopException,Exception;
	/**
	 * 修改分销商账号信息
	 * @param userManagerParam
	 * @return
	 * @throws Exception
	 */
	public Boolean updateDistributorUserInfo(UserManagerParam userManagerParam) throws Exception;

	/**
	 * 根据登录用户或手机号查询用户
	 * @param userPhone 用户名或手机号
	 * @return 用户信息
	 */
	List<UserInfo> getAllByUserPhone(String userPhone);

	/**
	 * 根据用户信息查询用户权限
	 * @param user 用户
	 * @return 权限
	 * @throws Exception
	 */
	List<String> getAuths(UserInfo user) throws Exception ;

	/**
	 * 根据用户手机号修改密码
	 * @param userPhone 手机号
	 * @param pwd 密码
	 * @return 影响账号数
	 */
	int updatePwdByUserPhone(String userPhone,String pwd);

	/**
	 * 变更 b_user_authority 的用户权限
	 * @param authList
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	boolean updateSpecificAuthorities(List<String> authList,Integer userId) throws Exception;

	/**
	 * 删除b_user_authority 的用户权限
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	boolean deleteSpecificAuthoritiesByUserId(Integer userId) throws Exception;
	/**
	 * 根据帐号/手机号集合查询用户列表
	 * @param accountList
	 * @param type  2买手 其他为商家帐户
	 * @return
	 * @throws Exception
	 */
	public List<UserInfo> getUserListByType(List<String> accountList,Integer type) throws Exception;

   /*
	 * 修改账号资金状态
	 */
	public int updateUsersFunds(Integer userId,Integer fundStatus) throws Exception;
	
	public UserBindingVO getBindingMIdByshopId(Integer shopId) throws Exception;
	/**
	 * 根据店铺id获取总店/所属商场下具有权限值的账号列表
	 * @param shopId
	 * @param authValue  'GOOD_ORDER_APPEAL'
	 * @return
	 * @throws Exception
	 */
	public List<BsUserVO> getHasAppealAuthAccountListByShopId(Integer shopId, String authValue) throws Exception;
	/**
	 * 根据店铺id查询所有具有退款单列表菜单权限的帐号列表
	 * @param shopId
	 * @param authValue 'GOOD_ORDER_REFUND'
	 * @return
	 * @throws Exception
	 */
	public List<BsUserVO> getHashRefundAccountListByShopId(Integer shopId, String authValue) throws Exception;
	/**
	 * 根据用户id查询店铺mongoId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public String selectShopMIdByUserId(Integer userId) throws Exception;
	/**
	 * 根据店铺mongoId查询店铺主账号信息
	 * @param shopMId
	 * @return
	 */
	public UserInfo getChiefAccountByShopMId(String shopMId);

	/**
	 * 解绑用户手机号码
	 *  @author zhuming
	 * @date 2017/9/27
	 * @param id
	 * @return
	 */
	public int unBindUserPhoneById(Integer id);

	HierarchicalMerchantInfo getHierarchicalMerchantInfo(Integer userId);
}