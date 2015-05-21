package com.domain.mybatis.modules;

import com.domain.mybatis.core.Mapper;
import com.domain.mybatis.entities.User;

import java.util.List;

/**
 * Created by seokangchun on 15. 5. 21..
 */
@Mapper
public interface UserMapper {
    List<User> findAll();
    User findById(Integer id);
    void insert(User user);
    void update(User user);
    void delete(Integer id);
}
