package com.yanjing.mapper;

import com.yanjing.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yanjing
 * @date 2021/10/27
 */
@Mapper
@Repository
public interface UserMapper {
    
    // 相当于：
    // public static final int age = 18;
    int age = 18;
    
    List<User> queryUserList();
    
    User queryUserById(int id);
    
    int addUser(User user);
    
    int updateUser(User user);
    
    int deleteUser(int id);
}
