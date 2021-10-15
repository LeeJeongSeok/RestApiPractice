package com.stevelee.restapipractice.repository;

import com.stevelee.restapipractice.dto.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMemberRepository implements UserRepository{

    private static Map<String, User> userRepository = new HashMap<String, User>();

    @Override
    public boolean login(User user) {
        if (userRepository.get(user.getId()) == null) {
            System.out.println("사용자가 존재하지 않습니다.");
        }
        User loginUser = userRepository.get(user.getId());

        return loginUser.getPassword().equals(user.getPassword());
    }

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
