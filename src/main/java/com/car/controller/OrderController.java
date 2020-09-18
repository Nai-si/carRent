package com.car.controller;

import com.car.common.JsonResult;
import com.car.entity.City;
import com.car.entity.Order;
import com.car.entity.OrderTwo;
import com.car.entity.User;
import com.car.service.CityService;
import com.car.service.OrderService;
import com.car.utils.DistrictUtils;
import com.car.utils.StrUtils;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 预定车辆
     * @param id
     * @param oprice
     * @param session
     * @return
     */
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

    @RequestMapping("/orderSelect.do")
    @ResponseBody
    public Map<String , Object> orderSelect(Integer page,Integer limit,HttpSession session){
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);
        if (user == null) {
            return null;
        }
        Integer id = user.getId();
        List<OrderTwo> orders = orderService.orderSelect (id,page,limit);
        long total = ((Page) orders).getTotal();
        Map<String , Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",orders);
        return map;
    }

}
