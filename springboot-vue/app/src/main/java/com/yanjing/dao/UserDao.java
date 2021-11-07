package com.yanjing.dao;

import com.yanjing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yanjing
 * @date 2021/11/7
 */
public interface UserDao extends JpaRepository<User, Integer> {

    public User findByUsername(String username);

    public User getByUsernameAndPassword(String username, String password);
}
