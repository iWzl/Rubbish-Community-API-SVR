package com.rubbish.community.rubbish_community.config;

import com.rubbish.community.rubbish_community.filter.jwt.JWTFilter;
import com.rubbish.community.rubbish_community.filter.shiro.AuthRealm;
import com.rubbish.community.rubbish_community.filter.shiro.CredentialsMatcher;
import com.rubbish.community.rubbish_community.filter.shiro.RedisShiroCacheManager;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * Shiro 权限框架配置
 *
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/29 20:41
 */

@Configuration
public class ShiroConfig {

    /**
     * Shiro 过滤器链
     *
     * @author Leo Wang
     * @return org.apache.shiro.spring.web.ShiroFilterFactoryBean
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {

        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

        // 添加自定义安全过滤器：JWT
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("JWT", new JWTFilter());
        factoryBean.setFilters(filterMap);

        factoryBean.setSecurityManager(manager);


        /*
         * 自定义url规则
         */
        final Map<String, String> filterRuleMap = new LinkedHashMap<>();

        // 访问401和404页面不通过Filter
        filterRuleMap.put("/error/401", "anon");
        filterRuleMap.put("/error", "anon");
        filterRuleMap.put("/druid/**", "anon");
        filterRuleMap.put("/webjar/**", "anon");
        filterRuleMap.put("/swagger-ui.html", "anon");
        filterRuleMap.put("/swagger-resources/**", "anon");
        filterRuleMap.put("/v2/api-docs", "anon");
        filterRuleMap.put("/webjars/**", "anon");
        filterRuleMap.put("/doc.html", "anon");
        filterRuleMap.put("/favicon.ico", "anon");
        filterRuleMap.put("/index","anon");
        filterRuleMap.put("/csrf", "anon");

        filterRuleMap.put("/api/account/login/**", "anon");
        // 所有请求通过JWT Filter
        //filterRuleMap.put("/api/**","JWT");
        factoryBean.setFilterChainDefinitionMap(filterRuleMap);
        return factoryBean;

    }

    //配置核心安全事务管理器
    @Bean(name = "securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();

        /*
         * 关闭shiro自带的session，详情见文档
         * http://shiro.apache.org/session-management.html#SessionManagement-StatelessApplications%28Sessionless%29
         */
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        manager.setSubjectDAO(subjectDAO);
        manager.setRealm(authRealm);
        return manager;
    }

    //ShiroCacheManager(使用Redis)
    @Bean(name = "redisShiroCacheManager")
    public RedisShiroCacheManager redisShiroCacheManager() {
        return new RedisShiroCacheManager();
    }

    //配置自定义的权限登录器
    @Bean(name = "authRealm")
    public AuthRealm authRealm(@Qualifier("credentialsMatcher") CredentialsMatcher matcher) {
        AuthRealm authRealm = new AuthRealm();
        authRealm.setCredentialsMatcher(matcher);
        authRealm.setCachingEnabled(true);
        //只缓存 登陆的token
        authRealm.setAuthenticationCachingEnabled(true);
        //不缓存 权限信息 换成在service 层控制缓存
        authRealm.setAuthorizationCachingEnabled(false);
        // 自定义缓存实现 使用redis
        authRealm.setCacheManager(redisShiroCacheManager());
        authRealm.setAuthenticationCacheName("authenticationCache");
        authRealm.setAuthorizationCacheName("authorizationCache");
        return authRealm;
    }

    //配置自定义的密码比较器
    @Bean(name = "credentialsMatcher")
    public CredentialsMatcher credentialsMatcher() {
        return new CredentialsMatcher();
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }

    /**
     * 添加注解支持
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        // 强制使用cglib，防止重复代理和可能引起代理出错的问题
        // https://zhuanlan.zhihu.com/p/29161098
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

}
