package com.example.spring_study.user.repository;

import com.example.spring_study.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
