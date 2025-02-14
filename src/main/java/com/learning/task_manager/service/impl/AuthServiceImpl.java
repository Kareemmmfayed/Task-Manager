package com.learning.task_manager.service.impl;

import com.learning.task_manager.dto.LoginDTO;
import com.learning.task_manager.dto.RegisterDTO;
import com.learning.task_manager.entity.AppUser;
import com.learning.task_manager.repository.UserRepository;
import com.learning.task_manager.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public AppUser registerUser(RegisterDTO registerDTO) {
        return userRepository.save(AppUser.builder()
                .email(registerDTO.email())
                .password(registerDTO.password())
                .role(registerDTO.role()).build());
    }

    @Override
    public boolean loginUser(LoginDTO loginDTO) {
        return userRepository.findByEmail(loginDTO.email()).isPresent();
    }

}
