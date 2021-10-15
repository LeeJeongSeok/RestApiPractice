package com.stevelee.restapipractice.repository;

import com.stevelee.restapipractice.dto.User;

public interface MemoryUserRepository {

    void login(User user);

    void join(User user);

    User findUserById(String userId);
}
