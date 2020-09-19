package com.car.service.impl;

import com.car.dao.OrderDao;
import com.car.entity.Order;
import com.car.entity.OrderTwo;
import com.car.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/18 16:46
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public void addCar(Order order) {
        if (order == null) {
            throw new RuntimeException("订单信息错误");
        }
        orderDao.addCar(order);
    }

    @Override
    public List<OrderTwo> orderSelect(int id, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<OrderTwo> orders = orderDao.orderSelect(id);
        return orders;
    }

    @Override
    public int deleteById(Integer id) {
        return orderDao.deleteById(id);
    }
}
