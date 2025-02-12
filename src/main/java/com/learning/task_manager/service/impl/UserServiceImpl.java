package com.learning.task_manager.service.impl;

import com.learning.task_manager.entity.AppUser;
import com.learning.task_manager.repository.UserRepository;
import com.learning.task_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<AppUser> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public AppUser getOneUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with id [" + userId + "] not found"));
    }

    @Override
    public void deleteUser(Long theId) {
        userRepository.deleteById(theId);
    }
}
