package com.learning.task_manager.service;

import com.learning.task_manager.dto.UserResponseDTO;
import com.learning.task_manager.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<AppUser> getUsers();

    UserResponseDTO getOneUser(Long theId);

    void deleteUser(Long theId);
}
