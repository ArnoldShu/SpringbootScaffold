package com.arnold.www.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName RestController
 * @Description: 控制器
 * @Author Arnold
 * @Date 2020/4/15
 * @Version V2.0
 **/
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("getNormal" )
    @PreAuthorize("hasAnyRole('normal')")//拥有normal权限才可以访问
    public String getNormal() {
        return "normal登陆成功";
    }
    @GetMapping("getAdmin" )
    @PreAuthorize("hasAnyRole('admin')")//拥有admin权限才可以访问
    public String getAdmin() {
        return "admin登陆成功";
    }

}