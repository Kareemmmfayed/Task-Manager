package com.learning.task_manager.service.impl;

import com.learning.task_manager.dto.TaskRequestDTO;
import com.learning.task_manager.dto.TaskResponseDTO;
import com.learning.task_manager.entity.*;
import com.learning.task_manager.exception.ResourceNotFoundException;
import com.learning.task_manager.repository.TaskRepository;
import com.learning.task_manager.repository.UserRepository;
import com.learning.task_manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
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
        return taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task with id [" + taskId + "] not found"));
    }

    @Override
    @Transactional
    public Task updateTask(long taskId, TaskRequestDTO taskDTO) {
        Task task = getSingleTaskById(taskId);
        task.setId(taskId);
        task.setTitle(taskDTO.title());
        task.setDescription(taskDTO.description());
        task.setStatus(taskDTO.status());
        task.setPriority(taskDTO.priority());
        task.setCategory(taskDTO.category());
        task.setDeadline(taskDTO.deadline());
        task.setAppUser(getSingleUserById(taskDTO.userId()));
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public String deleteTask(long taskId) {
        Task task = getSingleTaskById(taskId);
        task.setAppUser(null);
        taskRepository.delete(task);
        return "Task deleted successfully!";
    }

    public AppUser getSingleUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with id [" + userId + "] not found"));
    }

    public Task getSingleTaskById(long taskId) {
        return taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task with id [" + taskId + "] not found"));
    }
}
