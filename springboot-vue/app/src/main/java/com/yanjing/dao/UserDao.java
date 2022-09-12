package com.yanjing.dao;

import com.yanjing.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author yanjing
 * @date 2021/11/7
 */
public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Query("from User where username = :username")
    @EntityGraph(value = "user-entity-graph", type = EntityGraph.EntityGraphType.FETCH)
    User findWithMenusByUsername(String username);
}
