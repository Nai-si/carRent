package com.car.controller;

import com.car.common.JsonResult;
import com.car.entity.City;
import com.car.service.CityService;
import com.car.utils.DistrictUtils;
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
 * @Description: 城市列表控制器
 */
@Controller
@RequestMapping("city")
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 获取城市列表
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


    /**
     * 获取租车门店
     * @return
     */
    @RequestMapping("/selectName.do")
    @ResponseBody
    public JsonResult selectName(){
        City city = cityService.selectMsg(DistrictUtils.getQuiz1());
        City city1 = cityService.selectMsg(DistrictUtils.getQuiz4());
        String[] citys = {city.getName() , city1.getName()};
        return new JsonResult(1,citys);

    }

    /**
     * 设置选择城市
     * @param quiz1
     * @param quiz2
     * @param quiz3
     * @param quiz4
     * @return
     */
    @RequestMapping("/button.do")
    @ResponseBody
    public JsonResult button(Integer quiz1,Integer quiz2,Integer quiz3,Integer quiz4){
        if (quiz1==null||quiz2==null||quiz3==null||quiz4==null){
            return new JsonResult(0,"请选择正确的城市或门店");
        }
        DistrictUtils.setQuiz1(quiz1);
        DistrictUtils.setQuiz2(quiz2);
        DistrictUtils.setQuiz3(quiz3);
        DistrictUtils.setQuiz4(quiz4);
        return new JsonResult(1,"选择成功,请稍后");
    }
}
