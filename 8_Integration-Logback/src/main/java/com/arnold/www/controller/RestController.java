package com.arnold.www.controller;

import com.alibaba.fastjson.JSON;
import com.arnold.www.dao.UserMapper;
import com.arnold.www.dao.UserMapper2;
import com.arnold.www.pojo.User;
import com.arnold.www.service.RedisService;
import io.swagger.annotations.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RestController
 * @Description: 控制器
 * @Author Arnold
 * @Date 2020/4/15
 * @Version V2.0
 **/
@org.springframework.web.bind.annotation.RestController
//添加Swagger的注解
@Api(tags = "登陆")
public class RestController {

    //操作数据源
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserMapper2 userMapper2;

    //redis操作类
    @Autowired
    RedisService redisService;

    //redis 原生操作类
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/home")
    public String home() {
       return "Hello World!";
    }

    /*@RequestMapping("/")
    public ModelAndView login() {
        return new ModelAndView("login");
    }*/
    @ApiOperation(value = "登陆校验",notes = "通过用户名和密码校验")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户名",paramType = "querry",required = true,dataType = "string"),
            @ApiImplicitParam(name = "password",value = "密码",paramType = "querry",required = true,dataType = "string"),

    })
    @PostMapping("/login")
    public String loginCheck(HttpSession session, HttpServletRequest request, @RequestParam(name = "name") String name, @RequestParam(name = "password") String password) {
        String redisKey = this.getClass().getName()+"-"+name+"-"+password;
        User user = new User();
        //添加一个缓存减少数据访问压力
        if (redisService.existsKey(redisKey)){
            user = JSON.parseObject(redisTemplate.opsForValue().get(redisKey).toString(),User.class);
            session.setAttribute("name",user.getName());
            session.setAttribute("password",user.getPassword());
            return "redirect:/successpage.html";
        }else {
            user = userMapper.getUser(name,password);
            if (null!=user){
                String userStr = JSON.toJSONString(user);
                //设置到缓存
                redisTemplate.opsForValue().set(redisKey,userStr);
                //设置自动过期
                redisTemplate.opsForValue().set(redisKey,userStr,30, TimeUnit.MINUTES);
                session.setAttribute("name",user.getName());
                session.setAttribute("password",user.getPassword());
                return "redirect:/successpage.html";
            }
            else{
                request.setAttribute("msg","用户名密码错误!!!");
                return "login";
            }
        }
    }

    @GetMapping("/throw")
    public void login() throws Exception{
        throw new Exception("爬出错误");
    }

    @GetMapping("/getUser")
    public String  getUser() {
        List<User> list = userMapper2.getUser();
        return  JSON.toJSONString(list);
    }

    @RabbitListener(queues={"testmq"})
    public void listenRabbitMQ(){
        Object obj = rabbitTemplate.receiveAndConvert("testmq");
        //System.out.println(new String((byte[])obj));
        System.out.println(obj);
        System.out.println(obj.toString());
        System.out.println("收到mq消息提醒!!!");
    }
}