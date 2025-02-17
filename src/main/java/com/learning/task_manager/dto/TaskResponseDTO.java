package com.learning.task_manager.dto;

import com.learning.task_manager.entity.TaskCategory;
import com.learning.task_manager.entity.TaskPriority;
import com.learning.task_manager.entity.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TaskResponseDTO(
        String title,
        String description,
        TaskStatus status,
        TaskPriority priority,
        TaskCategory category,
        LocalDate deadline,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Long userId
) {

    public static TaskResponseDTO makeTaskOutOfDTO(com.learning.task_manager.entity.Task task) {
        return new TaskResponseDTO(
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getCategory(),
                task.getDeadline(),
                task.getCreatedAt(),
                task.getUpdatedAt(),
                task.getAppUser() != null ? task.getAppUser().getId() : null
        );
    }
}
