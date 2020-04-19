package com.arnold.www;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

/**
 * @ClassName test
 * @Description: 测试类
 * @Author Arnold
 * @Date 2020/4/15
 * @Version V2.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
    //日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test(){
        //日志级别trace<debug<info<warn<error
        logger.trace("trace日志");
        logger.debug("debug日志");
        logger.info("info日志");
        logger.warn("warn日志");
        logger.error("error日志");
    }

    @Test
    public void tesHash(){
        HashMap hashMap =new HashMap();

    }
}