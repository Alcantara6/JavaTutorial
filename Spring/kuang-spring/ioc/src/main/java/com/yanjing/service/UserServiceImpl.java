package com.yanjing.service;

import com.yanjing.dao.UserDao;

/**
 * @author yanjing
 * @date 2021/8/4
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {

        this.userDao = userDao;
    }

    @Override
    public String getUser() {

        return userDao.getUser();
    }
}
