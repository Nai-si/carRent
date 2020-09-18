package com.car.service;

import com.car.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/18 9:18
 * @Description:
 */
@Service
public interface CityService {

    public List<City> selectAll(int pid);

}
