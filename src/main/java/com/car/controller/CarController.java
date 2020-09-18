package com.car.controller;


import com.car.entity.Car;
import com.car.service.CarService;
import com.car.utils.DistrictUtils;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/18 15:29
 * @Description:
 */
@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/showCar.do")
    @ResponseBody
    public Map<String ,Object> showCar(Integer page,Integer limit){
        List<Car> cars = carService.selectByCityId(DistrictUtils.getQuiz2(), page, limit);
        long total = ((Page) cars).getTotal();
        Map<String , Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",cars);
        return map;
    }
}
