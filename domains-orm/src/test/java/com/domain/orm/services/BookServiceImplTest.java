package com.domain.orm.services;

import com.domain.orm.configs.DomainConfiguration;
import com.domain.orm.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DomainConfiguration.class})
@Slf4j
@Transactional
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testList() throws Exception {
        List<Book> books = bookService.list();
        log.info("{}", objectMapper.writeValueAsString(books));
        assertThat(books, is(notNullValue()));
    }

    @Test
    public void testRead() throws Exception {
        Book book = bookService.read(1);
        log.info("{}", objectMapper.writeValueAsString(book));
        assertThat(book, is(notNullValue()));
    }
}