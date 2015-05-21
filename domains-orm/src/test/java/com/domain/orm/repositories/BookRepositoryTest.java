package com.domain.orm.repositories;

import com.domain.orm.configs.DomainConfiguration;
import com.domain.orm.entities.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

@ContextConfiguration(classes = {DomainConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Slf4j
public class BookRepositoryTest {

    @Autowired BookRepository bookRepository;
    @Autowired UserRepository userRepository;
    @Autowired HistoryRepository historyRepository;

    @Before
    public void setUp() throws Exception {
        bookRepository.deleteAll();
        for(Book b : getBooks()) {
            bookRepository.save(b);
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    public List<User> getUsers()
    {
        log.info("getUser 시작");
        User user1 = new User();
        user1.setName("User01");
        user1.setPassword("User01");
        user1.setPoint(5);
        user1.setLevel(UserLevel.NORMAL);

        User user2 = new User();
        user2.setName("User02");
        user2.setPassword("User02");
        user2.setPoint(10);
        user2.setLevel(UserLevel.READER);

        User user3 = new User();
        user3.setName("User03");
        user3.setPassword("User03");
        user3.setPoint(25);
        user3.setLevel(UserLevel.MVP);

        List<User> users = Arrays.asList(user1, user2, user3);
        log.info("getUser 종료");

        return users;
    }

    public List<Book> getBooks(){
        Book book1 = new Book();
        book1.setName("Book01");
        book1.setAuthor("autor name 01");
        book1.setComment("comment01");
        book1.setPublishDate(new Date());
        book1.setBookStatus(BookStatus.CANRENT);
        book1.setRentUser(userRepository.findByName("User02").get(0));

        Book book2 = new Book();
        book2.setName("Book02");
        book2.setAuthor("autor name 02");
        book2.setComment("comment02");
        book2.setPublishDate(new Date());
        book2.setBookStatus(BookStatus.MISSING);
        book2.setRentUser(userRepository.findByName("User02").get(0));

        Book book3 = new Book();
        book3.setName("Book03");
        book3.setAuthor("autor name 03");
        book3.setComment("comment03");
        book3.setPublishDate(new Date());
        book3.setBookStatus(BookStatus.RENTNOW);
        book3.setRentUser(userRepository.findByName("User02").get(0));

        List<Book> books = Arrays.asList(book1,book2,book3);
        return books;
    }

    public List<History> getHistorys()
    {
        System.out.println("getHistory 시작");
        History history1 = new History();
        history1.setUser(getUsers().get(0));
        history1.setBook(getBooks().get(0));
        history1.setActionType(HistoryActionType.RENT);
        history1.setInsertDate(new Date());

        History history2 = new History();
        history1.setUser(getUsers().get(1));
        history1.setBook(getBooks().get(1));
        history2.setActionType(HistoryActionType.RETURN);
        history2.setInsertDate(new Date());

        List<History> historys = Arrays.asList(history1,history2);
        System.out.println("getHistory 종료");
        return historys;
    }

    @Test
    public void testFindByName() throws Exception {
        List<Book> book = bookRepository.findByName("Book01");
        assertThat(book, is(notNullValue()));
        assertThat(book.get(0).getName(), is("Book01"));
    }
}