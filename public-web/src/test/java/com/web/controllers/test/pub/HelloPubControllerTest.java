package com.web.controllers.test.pub;

import com.common.configs.CommonConfiguration;
import com.domain.mybatis.configs.MybatisConfiguration;
import com.web.configs.ControllerConfiguration;
import com.domain.orm.configs.DomainConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CommonConfiguration.class, DomainConfiguration.class,  MybatisConfiguration.class, ControllerConfiguration.class})
@WebAppConfiguration
public class HelloPubControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void Setup() {
        this.mvc = webAppContextSetup(this.context).build();
    }

/*
    @InjectMocks
    HelloApiController controller;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mvc = standaloneSetup(controller)
                .setViewResolvers(viewResolver())
                .build();
    }

    private InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jade");
        return viewResolver;
    }
*/

    @Test
    public void testHello() throws Exception {
        mvc.perform(get("/test/pub/hello").param("name", "seo"))
                .andExpect(status().isOk())
                .andExpect(view().name(containsString("hello")))
                .andDo(print());
    }
}