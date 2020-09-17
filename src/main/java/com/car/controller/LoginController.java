package com.car.controller;

import com.car.common.JsonResult;
import com.car.entity.User;
import com.car.service.UserService;
import com.car.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/17 16:49
 * @Description:
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param tel
     * @param password
     * @param email
     * @param session
     * @return
     */
    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult login(String tel, String password, String email, HttpSession session){
        User user = userService.login(tel, password);
        session.setAttribute(StrUtils.LOGIN_USER,user);
        return new JsonResult(1,user);
    }

    @RequestMapping("/query.do")
    @ResponseBody
    public JsonResult query(HttpSession session){
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        if (user == null) {
            return new JsonResult(0,"请先登录");
        }else{
            return new JsonResult(1,user);
        }
    }


}
