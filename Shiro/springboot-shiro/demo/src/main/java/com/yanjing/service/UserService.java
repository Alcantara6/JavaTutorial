package com.yanjing.service;

import com.yanjing.entity.User;

/**
 * @author yanjing
 * @date 2021/11/4
 */
public interface UserService {
    
    public User findByUsername(String username);
}
