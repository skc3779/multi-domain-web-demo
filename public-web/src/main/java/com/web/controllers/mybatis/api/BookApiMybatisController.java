package com.web.controllers.mybatis.api;

import com.domain.mybatis.services.Book2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by seokangchun on 15. 5. 21..
 */
@Controller
@RequestMapping("/mybatis/api")
@Slf4j
public class BookApiMybatisController {
    @Autowired
    Book2Service book2Service;

    @RequestMapping(value = "/book/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list() {
        return book2Service.list();
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object read(@PathVariable(value = "id") Integer id) {
        return book2Service.read(id);
    }
}
