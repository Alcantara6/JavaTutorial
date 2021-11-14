package com.yanjing.dao;

import com.yanjing.entity.Book;
import com.yanjing.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yanjing
 * @date 2021/11/14
 */
public interface BookDao extends JpaRepository<Book, Integer> {

    List<Book> findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
