package com.rubbish.community.rubbish_community.filter.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
/**
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/29 21:16
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher{
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        return super.doCredentialsMatch(token,info);
    }
}
