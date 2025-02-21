package com.learning.task_manager.service;

import com.learning.task_manager.dto.AuthenticationResponseDTO;
import com.learning.task_manager.dto.LoginDTO;
import com.learning.task_manager.dto.RegisterDTO;

public interface AuthService {
    public AuthenticationResponseDTO registerUser(RegisterDTO registerDTO);

    public AuthenticationResponseDTO loginUser(LoginDTO loginDTO);
}
