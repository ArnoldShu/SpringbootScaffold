package com.arnold.www.common;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginInterceptor
 * @Description: 登陆拦截器
 * @Author Arnold
 * @Date 2020/4/17
 * @Version V2.0
 **/
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object name = request.getSession().getAttribute("name");
        Object password = request.getSession().getAttribute("password");
        if (null==name&&null==password){
            request.setAttribute("msg","没有登陆！！！");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}