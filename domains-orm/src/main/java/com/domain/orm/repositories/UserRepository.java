package com.domain.orm.repositories;

import com.domain.orm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, QueryDslPredicateExecutor<User>  {
    List<User> findByName(String name);
}
