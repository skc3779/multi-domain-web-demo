package com.domain.mybatis.modules;

import com.domain.mybatis.configs.MybatisConfiguration;
import com.domain.mybatis.entities.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by seokangchun on 15. 5. 21..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MybatisConfiguration.class })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Slf4j
public class BookMapperTest {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    ObjectMapper objectMapper;
    @Test
    public void testFindAll() throws Exception {
        List<Book> books = bookMapper.findAll();
        log.info("{}", objectMapper.writeValueAsString(books));
        assertThat(books, is(notNullValue()));
    }
}