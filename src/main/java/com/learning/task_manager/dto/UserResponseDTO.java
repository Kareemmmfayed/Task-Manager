package com.learning.task_manager.dto;

import com.learning.task_manager.entity.AppUser;
import com.learning.task_manager.entity.Role;

public record UserResponseDTO(
        long id,
        String firstName,
        String lastName,
        String email,
        Role role
) {
    public static UserResponseDTO makeUserResponseOutOfUser(AppUser appUser) {
        return new UserResponseDTO(
                appUser.getId(),
                appUser.getFirstName(),
                appUser.getLastName(),
                appUser.getEmail(),
                appUser.getRole()
        );
    }
}
