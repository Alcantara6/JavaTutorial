package com.yanjing.service;

import com.yanjing.dao.CategoryDao;
import com.yanjing.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yanjing
 * @date 2021/11/14
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public List<Category> list() {
        // 搜索结果排序
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return categoryDao.findAll(sort);
    }

    public Category get(int id) {
        return categoryDao.findById(id).orElse(null);
    }
}
