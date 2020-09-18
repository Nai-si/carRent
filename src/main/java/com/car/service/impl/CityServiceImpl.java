package com.car.service.impl;

import com.car.dao.CityDao;
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
    private CityDao cityDao;


    @Override
    public List<City> selectAll(int pid) {
        List<City> list = cityDao.selectAll(pid);
        return list;
    }

    @Override
    public City selectMsg(int id) {
        City city = cityDao.selectMsg(id);
        return city;
    }
}
