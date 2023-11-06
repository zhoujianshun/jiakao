package top.imono.jk.common.shiro;

import jakarta.servlet.Filter;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import top.imono.jk.filter.ErrorFilter;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * shiro启用注解拦截控制器
 * shiro的三个重要配置
 * 1、Realm
 * 2、DefaultWebSecurityManager
 * 3、ShiroFilterFactoryBean
 */
@Configuration
public class ShiroConfig {

    @Bean("tokenRealm")
    public TokenRealm tokenRealm(){
        return new TokenRealm(new TokenMatcher());
    }
    /*
    * 告诉shiro如何进行拦截
    * */
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

        /**
         *  注册jwt过滤器，除/login外都先经过jwtFilter
         */
        HashMap<String, Filter> filterMap = new HashMap<>();
        filterMap.put("jwt", new TokenFilter());
        shiroFilter.setFilters(filterMap);

        // 拦截器
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        // anno内置拦截器，表示直接通过
        map.put("/user/login", "anon");
        // swagger
        map.put("/swagger-ui/**", "anon");
        map.put("/v3/api-docs/**", "anon");
        // 全局Filter的异常处理
        map.put(ErrorFilter.ERROR_URI, "anon");

        // 其他路径使用jwt拦截器拦截
        map.put("/**", "jwt");
        shiroFilter.setFilterChainDefinitionMap(map);
        return shiroFilter;
    }


    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager(@Qualifier("tokenRealm") TokenRealm tokenRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(tokenRealm);
        // 关闭shiroDao功能
//        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
//        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
//        // 不需要将ShiroSession中的东西存到任何地方包括Http Session中）
//        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
//        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
//        securityManager.setSubjectDAO(subjectDAO);
        // securityManager.setSubjectFactory(subjectFactory());
        return securityManager;
    }


    /**
     * 解决@RequiresAuthentication注解不生效的配置
     */
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 为Spring-Bean开启对Shiro注解的支持
     */
    @Bean("authorizationAttributeSourceAdvisor")
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
//    /**
//     * 解决：@RequiresPermissions导致控制器接口404
//     */
//    @Bean
//    public DefaultAdvisorAutoProxyCreator proxyCreator() {
//        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
//        proxyCreator.setUsePrefix(true);
//        return proxyCreator;
//    }
}
