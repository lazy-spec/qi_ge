package com.person.qi_boot.config;

import com.person.qi_boot.consts.Const;
import com.person.qi_boot.interceptor.AuthorizedInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /** 虚拟映射路径 */
    private static final String path = "file:" + Const.path_url;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations(path);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorizedInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(Const.LOGIN, "/layui/**", "/employee/login", "/js/**", "/css/**");
    }
}
