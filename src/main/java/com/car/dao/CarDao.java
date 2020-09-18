package com.car.dao;

import com.car.entity.Car;

import java.util.List;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/18 15:29
 * @Description:
 */
public interface CarDao {

    public List<Car> selectByCityId(int cid);

    public Car findCar(int id);

}
