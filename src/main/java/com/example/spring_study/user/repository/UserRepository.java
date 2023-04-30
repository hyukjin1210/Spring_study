package com.example.spring_study.user.repository;

import com.example.spring_study.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository{
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByName(String name);
    List<User> findAll();
}
