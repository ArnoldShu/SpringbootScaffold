package com.arnold.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName com.arnold.www.Application
 * @Description: 启动器
 * @Author Arnold
 * @Date 2020/4/15
 * @Version V2.0
 **/
@SpringBootApplication
@MapperScan(value = "com.arnold.www.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}