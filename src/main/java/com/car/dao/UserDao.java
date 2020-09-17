package com.car.dao;

import com.car.entity.User;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/17 16:55
 * @Description:
 */
public interface UserDao {
    public User findByTel(String tel);
}
