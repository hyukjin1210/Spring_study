package com.example.spring_study.user.repository;

import com.example.spring_study.user.entity.User;

import java.util.*;

public class MemoryUserRepository implements UserRepository{
    private static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public User save(User user) {
        user.setId(++sequence); //아이디 세팅
        store.put(user.getId(), user);  //store에 저장
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //Optional.ofNullable 를 사용해 store.getId가 null일 경우에도 Optional로 감싸서 반환
    }

    @Override
    public Optional<User> findByName(String name) {
        return store.values().stream()
                .filter(user -> user.getName().equals(name)).findAny();

    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
