package com.car.service;

import com.car.entity.Car;

import java.util.List;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/18 15:30
 * @Description:
 */
public interface CarService {

    public List<Car> selectByCityId(int cid,Integer page,Integer limit);

}
