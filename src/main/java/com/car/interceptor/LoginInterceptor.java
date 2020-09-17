package com.car.interceptor;

import com.car.entity.User;
import com.car.utils.StrUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/17 16:45
 * @Description:
 */
public class LoginInterceptor implements HandlerInterceptor {
    //在请求前处理，只需要这一个方法即可
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        //uri  统一资源标识符
        //url  统一资源定位符
        System.out.println("requestURI = " + requestURI);
        User user = (User) request.getSession().getAttribute(StrUtils.LOGIN_USER);
        if (user == null) {//证明没有登录需要跳转到login.html
            //如果是ajaxq请求也得跳转到login.html
            //如果是jquery的ajax请求的话，浏览器会带有一个特殊的请求头
            String value = request.getHeader("X-Requested-With");
            if (value != null&& value.equals("XMLHttpRequest")) {//说明是ajax请求
                response.getWriter().write("{\"code\":0, \"info\":\"未登录\"}");
            } else {
                //没有登录，直接跳转到 login.html  非ajax请求的时候直接登录页面
                response.sendRedirect(request.getContextPath() + "/login.html");
            }
            return false;

        }

        return true;
    }
}
