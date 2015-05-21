package com.domain.orm.services;

import com.domain.orm.configs.DomainConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DomainConfiguration.class})
@Slf4j
public class HelloStringTest {

    /**
     * 1번 로그 방식
     */
    //private static Log log = LogFactory.getLog(HelloStringTest.class);

    @Autowired
    private HelloString helloString;

    @Test
    public void testSayHello() throws Exception {

        String name = helloString.sayHello("seo");
        /**
         * 1번 로그활용
         */
        //log.info("name : " + name);
        /**
         * lombok slf4j
         */
        log.info("name : {}", name);
        assertThat(name, is("Hello seo"));
    }

}