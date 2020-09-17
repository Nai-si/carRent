package com.car.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/17 16:41
 * @Description:
 */
public class CustomerDateConvert implements Converter<String , Date> {
    //基本的日期转换类
    SimpleDateFormat[] sdfs = new SimpleDateFormat[]{
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyyMMdd"),
            new SimpleDateFormat("yyyy年MM月dd日")};
    //方法的目的就是把字符串转换为时间日期对象
    @Override
    public Date convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        for (SimpleDateFormat sdf: sdfs) {
            try {
                //把字符串转化为日期对象
                return sdf.parse(s);
            } catch (ParseException e) {
                //e.printStackTrace();
                continue;
            }
        }
        return null;
    }
}
