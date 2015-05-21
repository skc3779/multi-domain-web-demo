package com.domain.mybatis.entities;

import java.util.Date;

/**
 * Created by seokangchun on 15. 5. 21..
 */

public class Book {

    private int id;

    private String name;

    private String author;

    private Date publishDate;

    private String comment;

    private BookStatus bookStatus;

    private Integer rentUserId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Integer  getRentUserId() {
        return rentUserId;
    }

    public void setRentUserId(Integer rentUser) {
        this.rentUserId = rentUser;
    }
}