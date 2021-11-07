package com.yanjing.service;

import com.yanjing.dao.UserDao;
import com.yanjing.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yanjing
 * @date 2021/11/7
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean isExist(String username) {

        User user = getByName(username);
        return user != null;
    }

    public User getByName(String username) {

        return userDao.findByUsername(username);
    }

    public User get(String username, String password) {

        return userDao.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {

        userDao.save(user);
    }
}
