package com.arnold.www;

import cn.hutool.core.date.DateUtil;
import java.util.Date;

/**
 * @author Arnold
 * @version V1.0
 * @className CustomDateUtils
 * @description 自定义时间工具类
 * @date 2021/1/8
 **/
public class CustomDateUtils {
    public Date formatDate(String format){
       return DateUtil.parse(format);
    }
}