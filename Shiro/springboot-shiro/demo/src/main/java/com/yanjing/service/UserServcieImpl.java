package com.yanjing.service;

import com.yanjing.entity.User;
import com.yanjing.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yanjing
 * @date 2021/11/4
 */
@Service
public class UserServcieImpl implements UserService {
    
    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {

        return userDao.findByUsername(username);
    }
}
