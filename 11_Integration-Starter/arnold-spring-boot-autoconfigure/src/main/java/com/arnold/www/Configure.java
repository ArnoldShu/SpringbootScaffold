package com.arnold.www;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Arnold
 * @version V1.0
 * @className Configure
 * @description 配置类
 * @date 2021/1/8
 **/
@Configuration
public class Configure {
    @Bean
    public CustomDateUtils getCustomDateUtils(){
        return new CustomDateUtils();
    }
}