package com.learning.task_manager.dto;

import com.learning.task_manager.entity.Role;
import lombok.Builder;

@Builder
public record RegisterDTO(
        String email,
        String password,
        Role role
) {}
