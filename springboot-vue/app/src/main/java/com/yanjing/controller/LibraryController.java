package com.yanjing.controller;

import com.yanjing.dto.response.response.Response;
import com.yanjing.dto.response.response.ResponseUtils;
import com.yanjing.entity.Book;
import com.yanjing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanjing
 * @date 2021/11/14
 */
@RestController
public class LibraryController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public Response<List<Book>> list() {

        List<Book> books = bookService.list();
        return ResponseUtils.success(books);
    }

    @PostMapping("/books")
    public Response<Book> addOrUpdate(@RequestBody Book book) {

        // the saved entity; will never be null.
        Book resultBook = bookService.addOrUpdate(book);
        return ResponseUtils.success(resultBook);
    }

    @DeleteMapping("/books/{id}")
    public Response<String> delete(@PathVariable int id) {

        bookService.deleteById(id);
        return ResponseUtils.success("删除成功");
    }

    @GetMapping("/categories/{cid}/books")
    public Response<List<Book>> listByCategory(@PathVariable("cid") int cid) {

        if (0 != cid) {
            List<Book> categoryBooks = bookService.listByCategory(cid);
            return ResponseUtils.success(categoryBooks);
        } else {
            List<Book> allBooks = bookService.list();
            return ResponseUtils.success(allBooks);
        }
    }
}
