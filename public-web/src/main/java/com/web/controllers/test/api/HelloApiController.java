package com.web.controllers.test.api;

import com.domain.orm.services.HelloString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

/**
 * Created by seokangchun on 14. 11. 28..
 */
@Controller
@Slf4j
public class HelloApiController {

    @Autowired
    private HelloString helloSpring;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/test/api/hello", method = RequestMethod.GET)
    @ResponseBody
    public Object hello(@RequestParam(value="name", defaultValue="") String name, Locale locale) {
        log.info("locale : {}", locale.getDisplayLanguage());
        return helloSpring.sayHello(name);
    }
}
