package com.domain.mybatis.entities;

/**
 * Created by seokangchun on 15. 5. 21..
 */
public class User {
    private  Integer id;

    private  String name;

    private  String password;

    private  Integer point;

    private UserLevel userLevel;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPoint() {
        return point;
    }
    public void setPoint(Integer point) {
        this.point = point;
    }

    public UserLevel getUserLevel() {
        return userLevel;
    }
    public void setUserLevel(UserLevel userLevel) {
        this.userLevel = userLevel;
    }
}
