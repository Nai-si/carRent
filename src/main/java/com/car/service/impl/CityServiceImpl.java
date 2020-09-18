package com.car.service.impl;

import com.car.dao.CarDao;
import com.car.entity.City;
import com.car.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/18 9:18
 * @Description:
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CarDao carDao;


    @Override
    public List<City> selectAll(int pid) {
        List<City> list = carDao.selectAll(pid);
        return list;
    }
}
