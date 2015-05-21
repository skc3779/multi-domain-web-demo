package com.common.utils;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by seokangchun on 14. 11. 28..
 */
@Component
public class DateUtil {

    public String toString(LocalDateTime dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }

    public String toString(Date date, String format) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
//        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).format(formatter);
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    public Date toDate(String date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public LocalDateTime toLocalDateTime(String date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(date, formatter);
    }
}
