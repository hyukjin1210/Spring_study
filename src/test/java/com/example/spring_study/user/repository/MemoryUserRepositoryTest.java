package com.example.spring_study.user.repository;

import com.example.spring_study.user.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 모든 테스트코드는 독립적으로 실행되어야 한다.
 *
 */
class MemoryUserRepositoryTest {
    MemoryUserRepository userRepository = new MemoryUserRepository();

    @AfterEach  //메서드가 실행되고나서 실행되는 콜백함수의 역할
    public void afterEach()  {
        userRepository.clearStore();
    }

    @Test
    void save() {
        User user = new User();
        user.setName("spring");

        userRepository.save(user);

        User result = userRepository.findById(user.getId()).get();
        assertThat(user).isEqualTo(result);
    }

    @Test
    void findByName() {
        User user1 = new User();
        user1.setName("spring1");
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("spring2");
        userRepository.save(user2);

        User result = userRepository.findByName("spring1").get();

        assertThat(result).isEqualTo(user1);
    }

    @Test
    void findAll() {
        User user1 = new User();
        user1.setName("spring1");
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("spring2");
        userRepository.save(user2);

        List<User> result = userRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}