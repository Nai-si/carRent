package com.car.service.impl;

import com.car.dao.CarDao;
import com.car.entity.Car;
import com.car.service.CarService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/18 15:30
 * @Description:
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> selectByCityId(int cid, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Car> cars = carDao.selectByCityId(cid);
        if (cars.size()==0) {
            throw new RuntimeException("抱歉,所选地区暂无车辆");
        }
        return cars;
    }

    @Override
    public Car findCar(int id) {
        Car car = carDao.findCar(id);
        return car;
    }
}
