package com.learning.task_manager.service;

import com.learning.task_manager.dto.TaskRequestDTO;
import com.learning.task_manager.dto.TaskResponseDTO;
import com.learning.task_manager.entity.*;

import java.util.List;

public interface TaskService {

    Task addTask(TaskRequestDTO taskDTO);

    List<TaskResponseDTO> getTasks();

    Task getTask(long taskId);

    Task updateTask(long taskId, TaskRequestDTO taskDTO);
}
