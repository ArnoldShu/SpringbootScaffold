package com.arnold.www;

import com.arnold.www.mapper.UserMapper;
import com.arnold.www.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Arnold
 * @version V1.0
 * @className test
 * @description TODO
 * @date 2020/6/1
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}