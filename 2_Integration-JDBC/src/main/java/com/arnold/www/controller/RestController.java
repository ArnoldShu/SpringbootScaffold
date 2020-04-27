package com.arnold.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    JdbcTemplate jdbcTemplate;

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
        List <Map<String,Object>> result  = jdbcTemplate.queryForList("select * from test where name = ? and password = ?",name,password);

        if (result.size()!=0){
            session.setAttribute("name",result.get(0).get("name"));
            session.setAttribute("password",result.get(0).get("password"));
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
}