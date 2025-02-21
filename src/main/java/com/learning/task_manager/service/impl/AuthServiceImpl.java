package com.learning.task_manager.service.impl;

import com.learning.task_manager.config.JWTService;
import com.learning.task_manager.dto.AuthenticationResponseDTO;
import com.learning.task_manager.dto.LoginDTO;
import com.learning.task_manager.dto.RegisterDTO;
import com.learning.task_manager.entity.AppUser;
import com.learning.task_manager.entity.Role;
import com.learning.task_manager.repository.UserRepository;
import com.learning.task_manager.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public AuthenticationResponseDTO registerUser(RegisterDTO registerDTO) {
        AppUser user = AppUser.builder()
                .firstName(registerDTO.firstName())
                .lastName(registerDTO.lastName())
                .email(registerDTO.email())
                .password(passwordEncoder.encode(registerDTO.password()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponseDTO loginUser(LoginDTO loginDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.email(),
                loginDTO.password()
        ));

        var user = userRepository.findByEmail(loginDTO.email()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

}