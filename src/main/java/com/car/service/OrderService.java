package com.car.service;

import com.car.entity.Order;
import com.car.entity.OrderTwo;

import java.util.List;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/18 16:46
 * @Description:
 */
public interface OrderService {
    public void addCar(Order order);

    public List<OrderTwo> orderSelect(int id , int page , int limit);

    public int deleteById(Integer id);
}
