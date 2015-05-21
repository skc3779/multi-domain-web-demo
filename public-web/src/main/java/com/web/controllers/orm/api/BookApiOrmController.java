package com.web.controllers.orm.api;

import com.domain.orm.entities.Book;
import com.domain.orm.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by seokangchun on 14. 12. 1..
 */
@Controller
@RequestMapping("/orm/api")
@Slf4j
public class BookApiOrmController {

    @Autowired
    private BookService bookService;

    /**
     * 리스트
     * @return Json String
     */
    @RequestMapping(value = "/book/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list() throws IOException {
        List<Book> books = bookService.list();
        return books;
    }

    /**
     * 보기
     * @param id ID
     * @return Json String
     */
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object read(@PathVariable(value = "id") Integer id) {
        return bookService.read(id);
    }

}
