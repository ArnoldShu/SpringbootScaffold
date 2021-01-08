package com.arnold.www.controller;

import com.arnold.www.CustomDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

/**
 * @ClassName RestController
 * @Description: 控制器
 * @Author Arnold
 * @Date 2020/4/15
 * @Version V2.0
 **/
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    CustomDateUtils customDateUtils;

    @GetMapping("/getDateByStr/{format}")
    public Date getDateByStr(@PathVariable("format") String format) {
        return customDateUtils.formatDate(format);
    }
}