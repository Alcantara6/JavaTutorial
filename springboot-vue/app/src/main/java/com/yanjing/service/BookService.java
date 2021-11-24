package com.yanjing.service;

import com.yanjing.dao.BookDao;
import com.yanjing.dao.CategoryDao;
import com.yanjing.entity.Book;
import com.yanjing.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page<Book> list(Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return bookDao.findAll(pageable);
    }

    public Book addOrUpdate(Book book) {
        return bookDao.save(book);
    }

    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

    public Page<Book> listByCategory(int cid, Integer pageNo, Integer pageSize) {

        Sort sort = Sort.by(Sort.Direction.DESC, "category");
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Category category = categoryDao.findById(cid).orElse(null);
        if (category == null) {

            return Page.empty(pageable);
        }
        return bookDao.findAllByCategory(category, pageable);
    }

    public Page<Book> search(String keywords, Integer pageNo, Integer pageSize) {

        Sort sort = Sort.by(Sort.Direction.DESC, "title", "author");
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return bookDao.findAllByTitleLikeOrAuthorLike("%" + keywords + "%", "%" + keywords + "%", pageable);
    }
}
