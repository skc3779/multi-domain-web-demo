package com.web.controllers.test.pub;

import com.domain.orm.services.HelloString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by seokangchun on 14. 11. 28..
 */
@Controller
@Slf4j
@RequestMapping("/test/pub")
public class HelloPubController {

    @Autowired
    private HelloString helloSpring;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam(value="name", defaultValue="") String name, Locale locale, Model model) {
        log.info("locale : {}", locale.getDisplayLanguage());

        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        model.addAttribute("currentDate", today.format(formatter));
        model.addAttribute("helloSpring", helloSpring.sayHello(name));
        return "hello";
    }
}
