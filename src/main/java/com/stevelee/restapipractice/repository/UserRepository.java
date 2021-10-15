package com.stevelee.restapipractice.repository;

import com.stevelee.restapipractice.dto.User;

import java.util.List;

public interface UserRepository {

    boolean login(User user);

    void join(User user);

    User findUserById(String userId);

    List<User> findAll();
}
