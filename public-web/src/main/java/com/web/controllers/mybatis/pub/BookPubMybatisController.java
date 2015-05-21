package com.web.controllers.mybatis.pub;

import com.common.utils.DateUtil;
import com.domain.mybatis.entities.Book;
import com.domain.mybatis.services.Book2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by seokangchun on 15. 5. 21..
 */
@Controller
@RequestMapping("/mybatis/pub")
@Slf4j
public class BookPubMybatisController {
    @Autowired
    Book2Service book2Service;
    @Autowired
    DateUtil dateUtil;

    @RequestMapping(value = "/book/list", method=RequestMethod.GET)
    public Object list(Model model) {
        List<Book> books = book2Service.list();
        List<Map<String, Object>> maps = books.stream().map(this::convertToMap).collect(Collectors.toList());
        model.addAttribute("books", maps);
        return "book/list";
    }

    @RequestMapping(value="/book/{id}", method=RequestMethod.GET)
    public String read(@PathVariable(value="id") Integer id, Model model) {
        model.addAttribute("book", convertToMap(book2Service.read(id)));
        return "book/read";
    }

    private Map<String, Object> convertToMap(Book book) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", String.valueOf(book.getId()));
        map.put("name", book.getName());
        map.put("author", book.getAuthor());
        map.put("publishDate", dateUtil.toString(book.getPublishDate(), "yyyy-MM-dd"));
        map.put("comment", book.getComment());
        map.put("rendUser", book.getRentUserId() == null ? "" : book.getRentUserId().toString());
        map.put("status", String.valueOf(book.getBookStatus().intValue()));
        return map;
    }

}
