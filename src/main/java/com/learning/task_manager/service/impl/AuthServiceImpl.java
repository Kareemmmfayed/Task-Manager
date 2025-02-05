package com.learning.task_manager.service.impl;

import com.learning.task_manager.dto.LoginDTO;
import com.learning.task_manager.dto.RegisterDTO;
import com.learning.task_manager.entity.AppUser;
import com.learning.task_manager.repository.UserRepository;
import com.learning.task_manager.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public AppUser registerUser(RegisterDTO registerDTO) {
        AppUser user = AppUser.builder()
                .email(registerDTO.email())
                .password(registerDTO.password())
                .role(registerDTO.role()).build();

        return userRepository.save(user);
    }

    @Override
    public boolean loginUser(LoginDTO loginDTO) {
        return userRepository.findByEmail(loginDTO.email()).isPresent();
    }

}
