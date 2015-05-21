package com.domain.orm.entities;

/**
 * Created by seokangchun on 14. 11. 28..
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="histories")
public class History {

    private  Integer id;

    private  User user;

    private  Book book;

    private  HistoryActionType actionType;

    private  Date insertDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userId", nullable=false)
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="bookId", nullable=false)
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    @Enumerated(EnumType.ORDINAL)
    @Column(name="actionType")
    public HistoryActionType getActionType() {
        return actionType;
    }
    public void setActionType(HistoryActionType actionType) {
        this.actionType = actionType;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="insertDate")
    public Date getInsertDate() {
        return insertDate;
    }
    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }


}