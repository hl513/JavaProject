package com.xxx.hep.mapper.datasource2;

import com.xxx.hep.entity.Book;

import java.util.List;


public interface BookMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    Book selectByPrimaryKey(Integer id);

    List<Book> selectAll();

    int updateByPrimaryKey(Book record);
}