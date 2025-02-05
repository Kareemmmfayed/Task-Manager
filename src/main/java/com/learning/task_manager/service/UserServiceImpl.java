package com.learning.task_manager.service;

import com.learning.task_manager.dto.LoginDTO;
import com.learning.task_manager.dto.RegisterDTO;
import com.learning.task_manager.entity.AppUser;
import com.learning.task_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public AppUser registerUser(RegisterDTO registerDTO) {
        AppUser user = AppUser.builder()
                .email(registerDTO.email())
                .password(registerDTO.password())
                .role(registerDTO.role()).build();

        return userRepository.save(user);
    }

    public boolean loginUser(LoginDTO loginDTO) {
        return userRepository.findByEmail(loginDTO.email()).isPresent();
    }

}
