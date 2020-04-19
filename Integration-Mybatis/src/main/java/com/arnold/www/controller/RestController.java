package com.arnold.www.controller;

import com.alibaba.fastjson.JSON;
import com.arnold.www.dao.UserMapper;
import com.arnold.www.dao.UserMapper2;
import com.arnold.www.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
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
        User user = userMapper.getUser(name,password);
        if (null!=user){
            session.setAttribute("name",user.getName());
            session.setAttribute("password",user.getPassword());
            return "redirect:/successpage.html";
        }
        else{
            request.setAttribute("msg","用户名密码错误!!!");
            return "login";
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