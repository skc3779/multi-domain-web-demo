package com.domain.orm.services;

import org.springframework.stereotype.Service;

/**
 * Created by seokangchun on 14. 11. 28..
 */
@Service
public class HelloString {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
