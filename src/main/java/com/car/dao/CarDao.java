package com.car.dao;

import com.car.entity.City;

import java.util.List;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/18 9:39
 * @Description:
 */
public interface CarDao {

    public List<City> selectAll(int pid);

    public City selectMsg(int id);

}
