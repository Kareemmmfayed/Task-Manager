package com.learning.task_manager.service.impl;

import com.learning.task_manager.dto.TaskRequestDTO;
import com.learning.task_manager.dto.TaskResponseDTO;
import com.learning.task_manager.entity.*;
import com.learning.task_manager.repository.TaskRepository;
import com.learning.task_manager.repository.UserRepository;
import com.learning.task_manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public Task addTask(TaskRequestDTO taskDTO) {
        return taskRepository.save(Task.builder()
                .title(taskDTO.title())
                .description(taskDTO.description())
                .status(taskDTO.status())
                .priority(taskDTO.priority())
                .category(taskDTO.category())
                .deadline(taskDTO.deadline())
                .appUser(getSingleUserById(taskDTO.userId()))
                .build());
    }

    @Override
    public List<TaskResponseDTO> getTasks() {
        return taskRepository.findAll()
                .stream()
                .map(TaskResponseDTO::makeTaskOutOfDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Task getTask(long taskId) {
        return taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task with id [" + taskId + "] not found"));
    }

    @Override
    public Task updateTask(long taskId, TaskRequestDTO taskDTO) {
        return TaskRepository.save(getSingleTaskById(taskId).builder()
                .title(taskDTO.title())
                .description(taskDTO.description())
                .status(taskDTO.status())
                .priority(taskDTO.priority())
                .category(taskDTO.category())
                .build());
    }

    public AppUser getSingleUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with id [" + userId + "] not found"));
    }

    public Task getSingleTaskById(long taskId) {
        return taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task with id [" + taskId + "] not found"));
    }
}
