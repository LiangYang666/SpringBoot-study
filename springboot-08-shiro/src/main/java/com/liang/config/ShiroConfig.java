package com.liang.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(
            @Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager
    ){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);
        // 添加shiro的内置过滤器
        /*
            anon: 无需认证就可以登录
            authc:必须认证才能登录
            user: 必须拥有“记住我”这个功能
            perms:拥有对某个资源的权限才能访问
            role:拥有某个角色才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/add", "perms[user:add]");
        filterMap.put("/user/update", "perms[user:update]");
//        filterMap.put("/user/*", "authc");

        bean.setFilterChainDefinitionMap(filterMap);
        bean.setLoginUrl("/toLogin");
        bean.setUnauthorizedUrl("/noAuth"); //设置未授权情况下跳转的页面
        return bean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    // 结合Mybatis，整合ShiroDialect进组件
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
