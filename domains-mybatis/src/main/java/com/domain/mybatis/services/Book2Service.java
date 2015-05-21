package com.domain.mybatis.services;

import com.domain.mybatis.entities.Book;

import java.util.List;

/**
 * Created by seokangchun on 15. 5. 21..
 */
public interface Book2Service {
    List<Book> list();
    Book read(Integer id);
    void insert(Book book);
    void update(Book book);
    void delete(Integer id);
}
