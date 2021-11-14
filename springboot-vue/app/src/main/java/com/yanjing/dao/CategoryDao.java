package com.yanjing.dao;

import com.yanjing.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yanjing
 * @date 2021/11/14
 */
public interface CategoryDao extends JpaRepository<Category, Integer> {
}
