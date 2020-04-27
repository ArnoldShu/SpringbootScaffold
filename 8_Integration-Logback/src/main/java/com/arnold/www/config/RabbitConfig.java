package com.arnold.www.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitConfig
 * @Description: 自定义rabbitmq的配置
 * @Author Arnold
 * @Date 2020/4/26
 * @Version V2.0
 **/
@Configuration
public class RabbitConfig {

    //自定义序列化器
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}