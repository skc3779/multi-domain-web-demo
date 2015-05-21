package com.web.controllers.mybatis.api;

import com.common.configs.CommonConfiguration;
import com.domain.mybatis.configs.MybatisConfiguration;
import com.domain.orm.configs.DomainConfiguration;
import com.web.configs.ControllerConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by seokangchun on 15. 5. 21..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonConfiguration.class, MybatisConfiguration.class, DomainConfiguration.class, ControllerConfiguration.class})
@WebAppConfiguration
public class BookApiMybatisControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        mvc = webAppContextSetup(this.context).build();
    }

    @Test
    public void testList() throws Exception {
        mvc.perform(get("/mybatis/api/book/list"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testRead() throws Exception {
        mvc.perform(get("/mybatis/api/book/"+"1"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}