package com.stevelee.restapipractice.repository;

import com.stevelee.restapipractice.dto.User;

import java.util.List;

public interface UserRepository {

    void join(User user);

    User findUserById(String userId);

    List<User> findAll();
}
