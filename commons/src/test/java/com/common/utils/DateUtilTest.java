package com.common.utils;

import com.common.configs.CommonConfiguration;
import com.common.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonConfiguration.class})
@Slf4j
public class DateUtilTest {

    @Autowired
    private DateUtil dateUtil;

    @Test
    public void testLocalDateTimeToString() throws Exception {
        LocalDateTime dateTime = LocalDateTime.now();
        log.info("LocalDateTime to String : {}", dateUtil.toString(dateTime, "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void testDateToString() throws Exception {
        Date date = new Date();
        log.info("Date to String : {}", dateUtil.toString(date, "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void testToDate() throws Exception {
        Date date = dateUtil.toDate("2014-11-28 10:10:10", "yyyy-MM-dd HH:mm:ss");
        log.info("String to Date : {}", date.toString());
        assertThat(date, is(notNullValue()));
    }

    @Test
    public void testToLocalDateTime() throws Exception {
        LocalDateTime dateTime = dateUtil.toLocalDateTime("2014-11-28 10:10:10", "yyyy-MM-dd HH:mm:ss");
        log.info("String to LocalDateTime : {}", dateTime.toString());
        assertThat(dateTime, is(notNullValue()));
    }
}