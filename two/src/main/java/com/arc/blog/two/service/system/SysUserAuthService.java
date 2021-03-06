package com.arc.blog.two.service.system;

import com.arc.blog.two.model.domain.system.SysUserAuth;


/**
 * @author 叶超
 * @since 2019/1/30 17:33
 */
public interface SysUserAuthService {

    int save(SysUserAuth auth);

    int delete(Long id);

    int update(SysUserAuth auth);

    SysUserAuth get(Long id);

    /**
     * 通过 登录类型 & 标识 获取用户登录信息
     * @param identityType 登录类型
     * @param identifier 标识
     * @return 用户授权信息
     */
    SysUserAuth getByIdentityTypeAndIdentifier( Integer identityType, String identifier);

    /**
     * 通过 登录类型=1 & 标识 获取用户登录信息
     * @param username 标识
     * @return 用户授权信息
     */
    SysUserAuth getByUsername(String username);
}
