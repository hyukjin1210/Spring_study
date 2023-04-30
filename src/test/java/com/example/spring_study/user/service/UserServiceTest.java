package com.example.spring_study.user.service;

import com.example.spring_study.user.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserService userService = new UserService();


    @Test
    void join() {
        //given
        User user = new User();
        user.setName("hello");
        //when
        Long saveId = userService.join(user);
        //then
        User one =userService.findOne(saveId).get();
        assertThat(user.getName()).isEqualTo(one.getName());
    }

    @Test
    void findUsers() {
    }

    @Test
    void findOne() {
    }
}