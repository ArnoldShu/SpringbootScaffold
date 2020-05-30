package com.arnold.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @ClassName com.arnold.www.Application
 * @Description: 启动器
 * @Author Arnold
 * @Date 2020/4/15
 * @Version V2.0
 **/
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)//禁用弹出框
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}