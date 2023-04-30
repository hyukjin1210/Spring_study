package com.example.spring_study.user.service;

import com.example.spring_study.user.entity.User;
import com.example.spring_study.user.repository.MemoryUserRepository;
import com.example.spring_study.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository = new MemoryUserRepository();

    /* 회원가입 */
    public Long join(User user) {
        //중복회원 안됨
        validateDuplicateUser(user);  //중복 회원 검증

        userRepository.save(user);
        return user.getId();
    }

    /* 전체 회원 조회 */
    List<User> findUsers() {
        return userRepository.findAll();
    }

    /* 선택 회원 조회 */
    public Optional<User> findOne(Long userId) {
        return userRepository.findById(userId);
    }


    private void validateDuplicateUser(User user) {
        userRepository.findByName(user.getName())
                .ifPresent(u -> {
                    throw new IllegalArgumentException("이미 존재하는 회원입니다.");
                });
    }
}
