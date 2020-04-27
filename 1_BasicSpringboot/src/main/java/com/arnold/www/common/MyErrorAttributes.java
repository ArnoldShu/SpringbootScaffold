package com.arnold.www.common;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyGlobalExceptionHandler
 * @Description: 自定义错误数据属性
 * @Author Arnold
 * @Date 2020/4/18
 * @Version V2.0
 **/
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map map = super.getErrorAttributes(webRequest, includeStackTrace);
        //添加自己的属性
        map.put("company","Facebook");
        Map ext = (Map) webRequest.getAttribute("ext",1);
        map.put("ext",ext);
        return map;
    }
}