package com.arnold.www.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Arnold
 * @version V1.0
 * @className MybatisPlusConfig
 * @description TODO
 * @date 2020/6/2
 **/

/**
 * @version: V1.0
 * @author: fendo
 * @className: MybatisPlusConfig
 * @packageName: com.fendo.mybatis.plus.config
 * @description: Mybatis-plus配置类
 * @data: 2018-01-12 23:13
 **/
//@Configuration
//@MapperScan("com.arnold.www.mapper*")
public class MybatisPlusConfig {
    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     */
    /*@Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }*/

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}