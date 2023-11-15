package top.imono.jk.common.cfg;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.imono.jk.common.prop.JkProperties;
import top.imono.jk.filter.ErrorFilter;


@Configuration
public class WebCfg implements WebMvcConfigurer {
    @Autowired
    private JkProperties properties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        String[] corsOrigins = properties.getCfg().getCorsOrigins();

        // /**表示对所有的路径开放全局跨域访问权限
        registry.addMapping("/**")
                // 开放哪些IP、端口、域名的访问权限
                .allowedOriginPatterns(corsOrigins)
                // 是否允许发送Cookie信息
                .allowCredentials(true)
                // 哪些HTTP方法允许跨域访问
                .allowedMethods("GET", "POST");
    }

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        // 设置Filter
        bean.setFilter(new ErrorFilter());
        bean.addUrlPatterns("/*");
        // 最高权限
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);

        // 参考：https://sa-token.cc/doc.html#/use/route-check
        // 注册 Sa-Token 拦截器，打开路由式鉴权功能
        registry.addInterceptor(new SaInterceptor(handler -> {
                    SaRouter
                            .match("/**")
                            .notMatch("/user/login",
                                                "/user/logout",
                                                "/swagger-ui/**",
                                                "/v3/api-docs/**")
                            .check(r -> StpUtil.checkLogin());

                    SaRouter.match("/sysUsers/**", r -> StpUtil.checkPermission("sysUser"));
                    // SaRouter.match("/sysUsers/**", r -> StpUtil.checkRole("总经理"));

                }).isAnnotation(false) // 指定关闭掉注解鉴权能力，这样框架就只会做路由拦截校验了
        ).addPathPatterns("/**");
    }
}
