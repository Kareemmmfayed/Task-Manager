package com.learning.task_manager.dto;

import com.learning.task_manager.entity.Role;
import lombok.Builder;

import java.util.List;

@Builder
public record UserResponseDTO(
        String email,
        Role role,
        List<TaskResponseDTO> tasks
) {
}
