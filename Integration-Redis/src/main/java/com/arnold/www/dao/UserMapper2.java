package com.arnold.www.dao;

import com.arnold.www.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Interface UserMapper
 * @Description: 用户映射接口配置版
 * @Author Arnold
 * @Date 2020/4/19
 * @Version V2.0
 **/
public interface UserMapper2 {
    List<User> getUser();
}