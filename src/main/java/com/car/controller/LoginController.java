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
 * @Description: 登录控制器
 */
@Controller
@ResponseBody
@RequestMapping("/login")
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
    public JsonResult login(String tel, String password, String email, HttpSession session){
        User user = userService.login(tel, password);
        session.setAttribute(StrUtils.LOGIN_USER,user);
        return new JsonResult(StrUtils.MESSAGE_SUCCESS,user);
    }

    /**
     * 获取登录用户信息
     * @param session
     * @return
     */
    @RequestMapping("/query.do")
    public JsonResult query(HttpSession session){
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        if (user == null) {
            return new JsonResult(StrUtils.MESSAGE_FAIL,"请先登录");
        }else{
            return new JsonResult(StrUtils.MESSAGE_SUCCESS,user);
        }
    }



    /**
     * 获取用户手机号
     * @param session
     * @return
     */
    @RequestMapping("/loginStusta.do")
    public JsonResult loginStusta(HttpSession session){
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        return new JsonResult(StrUtils.MESSAGE_SUCCESS,user.getTel());
    }

}
