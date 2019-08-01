package com.rubbish.community.rubbish_community.filter.shiro;

import com.rubbish.community.rubbish_community.filter.jwt.JWTUtil;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Shrio 权限认证的实现
 *
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/29 21:06
 */
public class AuthRealm extends AuthorizingRealm {

    //角色权限和对应权限添加
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String jwtToken= (String) principalCollection.getPrimaryPrincipal();
        Long userId = JWTUtil.getUserId(jwtToken);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermission("TEST");
        return simpleAuthorizationInfo;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        String token = (String) auth.getCredentials();
        Long userId = JWTUtil.getUserId(token);
        if (userId == null) {
            throw new AuthenticationException("token invalid");
        }

        // Todo 查询数据库，验证相关信息
        return new SimpleAuthenticationInfo(userId, token, getName());
    }

}
