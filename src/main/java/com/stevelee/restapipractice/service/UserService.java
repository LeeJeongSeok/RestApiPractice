package com.stevelee.restapipractice.service;

import com.stevelee.restapipractice.dto.User;
import com.stevelee.restapipractice.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    MemoryMemberRepository memoryMemberRepository;

    public String login(String userId, String userPassword) {
        User user = memoryMemberRepository.findUserById(userId);
        if (user != null) {
            user.getPassword().equals(userPassword);
            return "ok";
        }
        return "fail";
    }

    public void join(User user) {
        memoryMemberRepository.join(user);
    }

    public User findUserById(String userId) {
        return memoryMemberRepository.findUserById(userId);
    }

    public List<User> findAll() {
        return memoryMemberRepository.findAll();
    }
}
