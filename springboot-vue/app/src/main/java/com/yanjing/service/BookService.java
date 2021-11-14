package com.yanjing.service;

import com.yanjing.dao.BookDao;
import com.yanjing.dao.CategoryDao;
import com.yanjing.entity.Book;
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
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private CategoryDao categoryDao;

    public List<Book> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return bookDao.findAll(sort);
    }

    public Book addOrUpdate(Book book) {
        return bookDao.save(book);
    }

    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

    public List<Book> listByCategory(int cid) {
        Category category = categoryDao.findById(cid).orElse(null);
        if (category == null) {

            return List.of();
        }
        return bookDao.findAllByCategory(category);
    }
}
