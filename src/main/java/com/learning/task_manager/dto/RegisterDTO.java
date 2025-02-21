package com.learning.task_manager.dto;

import com.learning.task_manager.entity.Role;
import lombok.Builder;

@Builder
public record RegisterDTO(
        String firstName,
        String lastName,
        String email,
        String password
) {}
