package com.domain.orm.services;

import com.domain.orm.entities.Book;
import java.util.List;

/**
 * Created by seokangchun on 14. 12. 1..
 */
public interface BookService {
    public List<Book> list();
    public Book read(Integer id);
    public Book save(Book book);
    public void delete(Book book);
}
