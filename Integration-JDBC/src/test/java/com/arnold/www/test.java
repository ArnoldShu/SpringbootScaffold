package com.arnold.www;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

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
    @Autowired
    DataSource dataSources;
    @Test
    public void testConnectMysql(){
        try {
            Connection dataSource = dataSources.getConnection();
            System.out.println("====================================="+dataSource);
            dataSource.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}