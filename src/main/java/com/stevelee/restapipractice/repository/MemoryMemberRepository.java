package com.stevelee.restapipractice.repository;

import com.stevelee.restapipractice.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMemberRepository implements UserRepository{

    private static Map<String, User> userRepository = new HashMap<String, User>();

    @Override
    public void join(User user) {
        userRepository.put(user.getId(), user);
    }

    @Override
    public User findUserById(String userId) {
        return userRepository.get(userId);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userRepository.values());
    }
}
