package com.arnold.www.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.arnold.www.common.LoginInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.beans.ConstructorProperties;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MvcConfig
 * @Description: druid配置一个监控serlvlet
 * @Author Arnold
 * @Date 2020/4/17
 * @Version V2.0
 **/
@Configuration
public class DruidConfig  {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
    //配置druid监控
    @Bean
    public ServletRegistrationBean druidServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map map = new HashMap();
        map.put("jmxUsername","admin");
        map.put("jmxPassword","admin");
        bean.setInitParameters(map);
        return  bean;
    }

    //配置监控filter
    @Bean
    public FilterRegistrationBean druidFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        Map map = new HashMap();
        map.put("exclusions","*.css,*.images,/druid/*");
        bean.setInitParameters(map);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}