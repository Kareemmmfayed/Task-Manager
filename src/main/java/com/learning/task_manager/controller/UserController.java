package com.learning.task_manager.controller;

import com.learning.task_manager.dto.UserResponseDTO;
import com.learning.task_manager.entity.AppUser;
import com.learning.task_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{theId}")
    public ResponseEntity<UserResponseDTO> getOne(@PathVariable Long theId) {
            return ResponseEntity.ok(userService.getOneUser(theId));
    }

    @DeleteMapping("/{theId}")
    public ResponseEntity<String> deleteOne(@PathVariable Long theId) {
            userService.deleteUser(theId);
            return ResponseEntity.ok("Deleted successfully!!");
    }
}
