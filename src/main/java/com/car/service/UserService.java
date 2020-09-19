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

    public void register(String tel ,String password,String email,String invitation);

    public int updateById(User record);

    public int updatePasswordById(User record);
}
