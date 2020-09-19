package com.car.dao;

import com.car.entity.Order;
import com.car.entity.OrderTwo;

import java.util.List;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/18 16:44
 * @Description:
 */
public interface OrderDao {
    public void addCar(Order order);

    public List<OrderTwo> orderSelect(int id);

    public int deleteById(Integer id);
}
