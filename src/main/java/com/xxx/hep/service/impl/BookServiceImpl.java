package com.xxx.hep.service.impl;

import com.xxx.hep.entity.Book;
import com.xxx.hep.mapper.datasource2.BookMapper;
import com.xxx.hep.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> selectAll() {
        return bookMapper.selectAll();
    }
}