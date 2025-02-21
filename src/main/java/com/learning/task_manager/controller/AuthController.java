package com.learning.task_manager.controller;

import com.learning.task_manager.dto.AuthenticationResponseDTO;
import com.learning.task_manager.dto.LoginDTO;
import com.learning.task_manager.dto.RegisterDTO;
import com.learning.task_manager.entity.AppUser;
import com.learning.task_manager.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterDTO registerDTO) {
        return ResponseEntity.ok(authService.registerUser(registerDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> login(@RequestBody LoginDTO loginDTO) {
            return ResponseEntity.ok(authService.loginUser(loginDTO));
    }
}