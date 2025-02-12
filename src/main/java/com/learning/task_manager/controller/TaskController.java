package com.learning.task_manager.controller;

import com.learning.task_manager.dto.TaskRequestDTO;
import com.learning.task_manager.dto.TaskResponseDTO;
import com.learning.task_manager.entity.Task;
import com.learning.task_manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody TaskRequestDTO taskDTO) {
        return ResponseEntity.ok(taskService.addTask(taskDTO));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable long taskId) {
        return ResponseEntity.ok(taskService.getTask(taskId));
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable long taskId, @RequestBody TaskRequestDTO taskRequestDTO) {
        return ResponseEntity.ok(taskService.updateTask(taskId, taskRequestDTO));
    }
}
