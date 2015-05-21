package com.domain.orm.entities;

/**
 * Created by seokangchun on 14. 11. 28..
 */

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

    private  Integer id;

    private  String name;

    private  String password;

    private  Integer point;

    private  UserLevel level;

//    private  Set<History> histories = new HashSet<History>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="point")
    public Integer getPoint() {
        return point;
    }
    public void setPoint(Integer point) {
        this.point = point;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name="level")
    public UserLevel getLevel() {
        return level;
    }
    public void setLevel(UserLevel level) {
        this.level = level;
    }


//    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
//    public Set<History> getHistories() {
//        return histories;
//    }
//    public void setHistories(Set<History> histories) {
//        this.histories = histories;
//    }
}
