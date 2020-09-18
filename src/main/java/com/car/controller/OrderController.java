package com.car.controller;

import com.car.common.JsonResult;
import com.car.entity.City;
import com.car.entity.Order;
import com.car.entity.User;
import com.car.service.CityService;
import com.car.service.OrderService;
import com.car.utils.DistrictUtils;
import com.car.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/18 16:44
 * @Description:
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CityService cityService;

    @RequestMapping("/addCar.do")
    @ResponseBody
    public JsonResult addCar(Integer id, double oprice, HttpSession session){
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        if (user == null) {
            return new JsonResult(0,"请先登录");
        }
        Integer quiz2 = DistrictUtils.getQuiz2();
        Integer quiz4 = DistrictUtils.getQuiz4();
        City city = cityService.selectMsg(quiz2);
        City city1 = cityService.selectMsg(quiz4);

        Order order = new Order();
        order.setCid(id);
        order.setOprice(oprice);
        order.setGetid(city.getId());
        order.setBackid(city1.getId());
        order.setUid(user.getId());
        order.setStatus("已预定");
        orderService.addCar(order);
        return new JsonResult(1,"预定成功");

    }

}
