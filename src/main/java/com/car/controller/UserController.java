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
 * @Time: 2020/9/19 9:08
 * @Description:  用户控制器
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 修改用户信息
     * @param email
     * @param session
     * @return
     */
    @RequestMapping("/update.do")
    public JsonResult updateById(String email, HttpSession session){
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        user.setEmail(email);
        userService.updateById(user);
        return new JsonResult(StrUtils.MESSAGE_SUCCESS,"信息修改成功");
    }

    /**
     * 修改用户密码
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/modifypassword.do")
    public JsonResult update(String password,HttpSession session){
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        user.setPassword(password);
        userService.updateById(user);
        return new JsonResult(StrUtils.MESSAGE_SUCCESS,"密码修改成功");
    }

    /**
     * 用户注册
     * @return
     */
    @RequestMapping("/register.do")
    public JsonResult register(String tel,String password,String email,String invitation){

        userService.register(tel,password,email,invitation);
        User user = userService.login(tel, password);
        return new JsonResult(StrUtils.MESSAGE_SUCCESS,user);

    }
}
