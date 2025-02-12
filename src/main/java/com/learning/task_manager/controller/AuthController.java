package com.learning.task_manager.controller;

import com.learning.task_manager.dto.LoginDTO;
import com.learning.task_manager.dto.RegisterDTO;
import com.learning.task_manager.entity.AppUser;
import com.learning.task_manager.service.impl.AuthServiceImpl;
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

    private final AuthServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody RegisterDTO registerDTO) {
        return ResponseEntity.ok(userService.registerUser(registerDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        if(userService.loginUser(loginDTO)) {
            return ResponseEntity.ok("User is found");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User not found!!");
        }
    }
}