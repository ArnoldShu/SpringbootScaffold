package com.arnold.www;

import com.arnold.www.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
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
    @Autowired
    RabbitTemplate rabbitTemplate;


    @Test
    public void testProduceText(){
        //测试发送消息队列
        //String messageStr = "test rabbitmq send message";
        //Message message = new Message(messageStr.getBytes(),new MessageProperties());
        //rabbitTemplate.send("exchange.testmq","testmq",message);
        User user = new User();
        user.setId("1");
        user.setName("rabbit mq ");
        user.setPassword("123452345");
        user.setSex("男");
        rabbitTemplate.convertAndSend("testmq",user);
    }

    @Test
    public void testReceiveText(){
        //测试接受消息
        //Message message = rabbitTemplate.receive("testmq");
        //System.out.println(message.getBody());
        //System.out.println(message.getMessageProperties());
        //System.out.println(message.toString());
        Object obj = rabbitTemplate.receiveAndConvert("testmq");
        //System.out.println(new String((byte[])obj));
        System.out.println(obj);
        System.out.println(obj.toString());
    }
}