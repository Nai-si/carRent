package com.car.service;

import com.car.entity.User;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/17 16:50
 * @Description:
 */
public interface UserService {
    public User login(String tel,String password);
}
