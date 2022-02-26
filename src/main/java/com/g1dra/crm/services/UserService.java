package com.g1dra.crm.services;

import com.g1dra.crm.models.User;
import com.g1dra.crm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveFileName(String fileName) {
        User user = userRepository.getById(1L);
        System.out.println(user);
    }
}
