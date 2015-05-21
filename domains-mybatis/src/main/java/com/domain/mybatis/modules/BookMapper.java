package com.domain.mybatis.modules;

import com.domain.mybatis.core.Mapper;
import com.domain.mybatis.entities.Book;

import java.util.List;

/**
 * Created by seokangchun on 15. 5. 21..
 */
@Mapper
public interface BookMapper {
    List<Book> findAll();
    Book findById(Integer id);
    void insert(Book book);
    void update(Book book);
    void delete(Integer id);
}
