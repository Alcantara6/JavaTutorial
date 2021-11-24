package com.yanjing.dao;

import com.yanjing.entity.Book;
import com.yanjing.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yanjing
 * @date 2021/11/14
 */
public interface BookDao extends JpaRepository<Book, Integer> {

    Page<Book> findAllByCategory(Category category, Pageable pageable);
    Page<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2, Pageable pageable);
}
