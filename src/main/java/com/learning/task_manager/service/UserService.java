package com.learning.task_manager.service;

import com.learning.task_manager.dto.UserResponseDTO;
import com.learning.task_manager.entity.AppUser;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> getUsers();
    UserResponseDTO getOneUser(long userId);
    String deleteUser(long userId);
    AppUser getSingleUserByEmail(String email);
}
