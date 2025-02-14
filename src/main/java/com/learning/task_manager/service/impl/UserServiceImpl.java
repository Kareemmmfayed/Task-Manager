package com.learning.task_manager.service.impl;

import com.learning.task_manager.dto.UserResponseDTO;
import com.learning.task_manager.entity.AppUser;
import com.learning.task_manager.repository.UserRepository;
import com.learning.task_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.learning.task_manager.mapper.UserMapper.toUserResponseDTO;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<AppUser> getUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public UserResponseDTO getOneUser(Long userId) {
        return toUserResponseDTO(getSingleUserById(userId));
    }

    private AppUser getSingleUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with id [" + userId + "] not found"));
    }

    @Override
    public void deleteUser(Long theId) {
        userRepository.deleteById(theId);
    }
}
