package com.arnold.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Arnold
 * @version V1.0
 * @className application
 * @description TODO
 * @date 2020/6/1
 **/
@SpringBootApplication
@MapperScan("com.arnold.www.mapper")
public class application {
}