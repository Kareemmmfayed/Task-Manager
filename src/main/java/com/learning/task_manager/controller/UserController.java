package com.learning.task_manager.controller;

import com.learning.task_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{theId}")
    public ResponseEntity<?> getOne(@PathVariable Long theId) {
        if(userService.getOneUser(theId).isPresent()) {
            return ResponseEntity.ok(userService.getOneUser(theId));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!!!");
        }
    }

    @DeleteMapping("/{theId}")
    public ResponseEntity<?> deleteOne(@PathVariable Long theId) {
        if(userService.getOneUser(theId).isPresent()) {
            userService.deleteUser(theId);
            return ResponseEntity.ok("Deleted successfully!!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!!!");
        }
    }
}
