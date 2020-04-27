package com.arnold.www.config;

import com.arnold.www.common.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MvcConfig
 * @Description: mvn配置
 * @Author Arnold
 * @Date 2020/4/17
 * @Version V2.0
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求，排除静态资源和登陆界面
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/css/**","/images/**","/login");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //默认访问到login.html
        registry.addViewController("/").setViewName("login");
        //登陆成功
        registry.addViewController("/successpage.html").setViewName("successpage");
    }
}