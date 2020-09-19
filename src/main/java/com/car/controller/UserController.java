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
 * @Description:
 */
@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/update.do")
    public JsonResult updateById(String tel , String email, HttpSession session){
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        user.setTel(tel);
        user.setEmail(email);
        userService.updateById(user);
        return new JsonResult(1,"信息修改成功");
    }



}
