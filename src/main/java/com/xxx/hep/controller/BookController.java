package com.xxx.hep.controller;

import com.xxx.hep.anno.SysLog;
import com.xxx.hep.entity.Book;
import com.xxx.hep.service.BookService;
import com.xxx.hep.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // http://localhost:10094/books
    @SysLog("查询所有书籍信息")
    @GetMapping(value = "/books")
    public Result selectAll() throws Exception {
        List<Book> books = bookService.selectAll();
        return Result.ok(books);
    }
}