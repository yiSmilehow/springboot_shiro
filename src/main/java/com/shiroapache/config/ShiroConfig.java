package com.shiroapache.config;

import com.shiroapache.pojo.Resources;
import com.shiroapache.service.ResourcesService;
import com.shiroapache.web.shiro.ShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * spring_shrio.xml整合到springboot
 */
@Configuration
public class ShiroConfig {

    @Resource
    private ResourcesService resourcesService;

    /**
     * 构造securityManager
     * 核心组件
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm());
        return securityManager;
    }

    /**
     * 自定义realm类
     *
     * @return
     */
    @Bean
    public ShiroRealm realm() {
        ShiroRealm realm = new ShiroRealm();
        realm.setCredentialsMatcher(credentialsMatcher());
        return realm;
    }

    /**
     * 构造加密算法
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1000);
        return credentialsMatcher;
    }

    /**
     * 自定义资源权限
     *
     * @return
     */
    @Bean
    public ShiroFilterChainDefinition filterChainDefinition() {
        DefaultShiroFilterChainDefinition filterChainDefinition = new DefaultShiroFilterChainDefinition();
        filterChainDefinition.addPathDefinitions(builder());
        return filterChainDefinition;
    }

    /**
     * 查询所有的资源权限
     *
     * @return
     */
    public Map<String, String> builder() {
        Map<String, String> map = new LinkedHashMap<String, String>();
        List<Resources> resourcesList = resourcesService.selectAllByStatusAndSortNumAsc();
        for (Resources resources : resourcesList) {
            map.put(resources.getKey(), resources.getVal());
        }
        return map;
    }
}
