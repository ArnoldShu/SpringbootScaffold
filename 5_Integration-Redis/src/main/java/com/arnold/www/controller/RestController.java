package com.arnold.www.controller;

import com.alibaba.fastjson.JSON;
import com.arnold.www.dao.UserMapper;
import com.arnold.www.dao.UserMapper2;
import com.arnold.www.pojo.User;
import com.arnold.www.service.RedisService;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RestController
 * @Description: 控制器
 * @Author Arnold
 * @Date 2020/4/15
 * @Version V2.0
 **/
@Controller
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

    @RequestMapping("/home")
    public String home() {
       return "Hello World!";
    }

    /*@RequestMapping("/")
    public ModelAndView login() {
        return new ModelAndView("login");
    }*/

    @RequestMapping(path = "/login", method = {RequestMethod.GET, RequestMethod.POST}  )
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

    @RequestMapping("/throw")
    public void login() throws Exception{
        throw new Exception("爬出错误");
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public String  getUser() {
        List<User> list = userMapper2.getUser();
        return  JSON.toJSONString(list);
    }
}