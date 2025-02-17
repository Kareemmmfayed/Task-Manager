package com.learning.task_manager.service.impl;

import com.learning.task_manager.dto.UserResponseDTO;
import com.learning.task_manager.entity.AppUser;
import com.learning.task_manager.exception.ResourceNotFoundException;
import com.learning.task_manager.repository.UserRepository;
import com.learning.task_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserResponseDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDTO::makeUserResponseOutOfUser)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getOneUser(long userId) {
        return UserResponseDTO.makeUserResponseOutOfUser(getSingleUserById(userId));
    }

    @Override
    public String deleteUser(long userId) {
        userRepository.delete(getSingleUserById(userId));
        return "User deleted successfully!";
    }

    public AppUser getSingleUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with id [" + userId + "] not found"));
    }
}
