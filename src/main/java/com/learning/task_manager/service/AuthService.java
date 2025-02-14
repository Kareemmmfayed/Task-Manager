package com.learning.task_manager.service;

import com.learning.task_manager.dto.LoginDTO;
import com.learning.task_manager.dto.RegisterDTO;
import com.learning.task_manager.entity.AppUser;

public interface AuthService {
    public AppUser registerUser(RegisterDTO registerDTO);

    public boolean loginUser(LoginDTO loginDTO);
}
