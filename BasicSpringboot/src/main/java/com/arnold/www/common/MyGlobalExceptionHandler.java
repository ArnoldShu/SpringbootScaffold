package com.arnold.www.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyGlobalExceptionHandler
 * @Description: TODO
 * @Author Arnold
 * @Date 2020/4/18
 * @Version V2.0
 **/
@ControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String customException(Exception e, HttpServletRequest request) {
        Map map = new HashMap();
        map.put("message", e.getMessage());
        map.put("class", "MyGlobalExceptionHandler");
        //map.put("myerror");
        request.setAttribute("ext",map);
        //传入自己的错误码,不然找不到页面
        request.setAttribute("javax,servlet.error.status_code",404);
        return "forward:/error";
    }
}