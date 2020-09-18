package com.car.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/18 23:09
 * @Description:
 */
public class TimeInterceptor implements HandlerInterceptor {
    //创建ThreadLocal对象
    private ThreadLocal<Long> threadLocal =  new ThreadLocal<>();
    //    private long beginTime;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long beginTime = System.currentTimeMillis();
        //多线程之间是互相独立的
        //设置值
        threadLocal.set(beginTime);
        Thread.sleep(5000);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        long endTime = System.currentTimeMillis();
        Long  beginTime= threadLocal.get();
        long v = endTime - beginTime;
        System.out.println(v);
    }
}
