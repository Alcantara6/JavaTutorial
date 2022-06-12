package com.yanjing.dao;

import com.yanjing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yanjing
 * @date 2021/11/4
 */
public interface UserDao extends JpaRepository<User, Long> {
    
    User findByUsername(String username);
}
