package com.car.controller;

import com.car.common.JsonResult;
import com.car.entity.City;
import com.car.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/18 9:15
 * @Description:
 */
@Controller
@RequestMapping("city")
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 查询城市信息
     * @param pid
     * @param session
     * @return
     */
    @RequestMapping("/select.do")
    @ResponseBody
    public JsonResult select(String pid, HttpSession session){
        if (pid == null) {
            pid = "0";
        }
        int i = Integer.parseInt(pid);
        System.out.println("i = " + i);
        List<City> list = cityService.selectAll(i);
        System.out.println(i);
        return new JsonResult(1,list);
    }

}
