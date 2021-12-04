package com.yanjing.controller;

import com.yanjing.dto.response.response.Response;
import com.yanjing.dto.response.response.ResponseUtils;
import com.yanjing.entity.Book;
import com.yanjing.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yanjing
 * @date 2021/11/14
 */
@RestController
public class LibraryController {

    private final String PAGE_SIZE = "20";

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public Response<Page<Book>> list(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = PAGE_SIZE) Integer pageSize
    ) {

        Page<Book> books = bookService.list(pageNo, pageSize);
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

    @GetMapping("/categories/{categoryId}/books")
    public Response<Page<Book>> listByCategory(
            @PathVariable("categoryId") int categoryId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = PAGE_SIZE) Integer pageSize
    ) {

        if (0 != categoryId) {
            Page<Book> categoryBooks = bookService.listByCategory(categoryId, pageNo, pageSize);
            return ResponseUtils.success(categoryBooks);
        } else {
            Page<Book> allBooks = bookService.list(pageNo, pageSize);
            return ResponseUtils.success(allBooks);
        }
    }

    @GetMapping("/books/search")
    public Response<Page<Book>> search(
            @RequestParam String keywords,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = PAGE_SIZE) Integer pageSize
    ) {

        if (keywords.isEmpty()) {

            return ResponseUtils.success(bookService.list(pageNo, pageSize));
        } else {

            return ResponseUtils.success(bookService.search(keywords, pageNo, pageSize));
        }
    }

    /**
     *
     * @param file
     * @return JsonNode
     *
     * idea Http Client示例
     * POST http://localhost:8443/books/cover
     * Content-Type: multipart/form-data; boundary=WebAppBoundary
     *
     * --WebAppBoundary
     * Content-Disposition: form-data; name="file"; filename="Allianz.jpg"
     *
     * < /home/yanjing/图片/Allianz.jpg
     * --WebAppBoundary--
     */
    @PostMapping("/books/cover")
    public Response<String> uploadCove(@RequestParam MultipartFile file) {

        String coverUrl = bookService.uploadCover(file);
        if (StringUtils.isBlank(coverUrl)) {

            return ResponseUtils.internalServerError("upload failed");
        } else {

            return ResponseUtils.success(coverUrl);
        }
    }
}
