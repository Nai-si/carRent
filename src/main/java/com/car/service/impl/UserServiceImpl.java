package com.car.service.impl;

import com.car.dao.UserDao;
import com.car.entity.User;
import com.car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/17 16:50
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String tel, String password) {
        User user = userDao.findByTel(tel);
        if (user == null) {
            throw new RuntimeException("手机号码错误");
        }
        if (!user.getPassword().equals(password)){
           throw new RuntimeException("密码错误");
        }

        return user;
    }

    @Override
    public void register(String tel, String password, String email, String invitation) {
        User user = new User();
        user.setTel(tel);
        user.setPassword(password);
        user.setEmail(email);
        user.setInvitation(invitation);

        userDao.register(user);
    }
}
