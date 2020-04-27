package com.arnold.www.dao;

import com.arnold.www.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Interface UserMapper
 * @Description: 用户映射接口
 * @Author Arnold
 * @Date 2020/4/19
 * @Version V2.0
 **/
//@Mapper
public interface UserMapper {
    @Select("select * from test where name = #{name} and password = #{password}")
    User getUser(String name,String password);
}