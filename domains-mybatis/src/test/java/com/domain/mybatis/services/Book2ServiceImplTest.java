package com.domain.mybatis.services;

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
public class Book2ServiceImplTest {

    @Autowired
    Book2Service book2Service;
    @Autowired ObjectMapper objectMapper;

    @Test
    public void testList() throws Exception {
        List<Book> books = book2Service.list();
        log.info("{}", objectMapper.writeValueAsString(books));
        assertThat(books, is(notNullValue()));
    }

    @Test
    public void testRead() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}