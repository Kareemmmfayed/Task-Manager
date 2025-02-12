package com.learning.task_manager.dto;

import com.learning.task_manager.entity.TaskCategory;
import com.learning.task_manager.entity.TaskPriority;
import com.learning.task_manager.entity.TaskStatus;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record TaskRequestDTO(String title, String description, TaskStatus status, TaskPriority priority, TaskCategory category, LocalDate deadline, Long userId) {}