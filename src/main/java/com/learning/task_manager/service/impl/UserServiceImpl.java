package com.learning.task_manager.service.impl;

import com.learning.task_manager.entity.AppUser;
import com.learning.task_manager.repository.UserRepository;
import com.learning.task_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<AppUser> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<AppUser> getOneUser(Long theId) {
        return userRepository.findById(theId);
    }

    @Override
    public void deleteUser(Long theId) {
        userRepository.deleteById(theId);
    }
}
