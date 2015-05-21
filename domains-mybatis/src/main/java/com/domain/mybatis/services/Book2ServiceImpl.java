package com.domain.mybatis.services;

import com.domain.mybatis.entities.Book;
import com.domain.mybatis.modules.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by seokangchun on 15. 5. 21..
 */
@Service
public class Book2ServiceImpl implements Book2Service {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> list() {
        return bookMapper.findAll();
    }

    @Override
    public Book read(Integer id) {
        return bookMapper.findById(id);
    }

    @Override
    public void insert(Book book) {
        bookMapper.insert(book);
    }

    @Override
    public void update(Book book) {
        bookMapper.update(book);
    }

    @Override
    public void delete(Integer id) {
        bookMapper.delete(id);
    }
}
