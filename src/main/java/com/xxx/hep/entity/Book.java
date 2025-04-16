package com.xxx.hep.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Book {

    private Integer id;

    private String author;

    private String name;

    private Long price;

    private Date createTime;

    private String description;
}