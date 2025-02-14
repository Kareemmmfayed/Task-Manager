package com.learning.task_manager.mapper;

import com.learning.task_manager.dto.TaskResponseDTO;
import com.learning.task_manager.dto.UserResponseDTO;
import com.learning.task_manager.entity.AppUser;
import com.learning.task_manager.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserResponseDTO toUserResponseDTO(AppUser appUser) {
        List<TaskResponseDTO> tasks = new ArrayList<>();
        for (Task task : appUser.getTasks()) {
            tasks.add(TaskResponseDTO.makeTaskOutOfDTO(task));
        }
        return UserResponseDTO
                .builder()
                .email(appUser.getEmail())
                .role(appUser.getRole())
                .tasks(tasks)
                .build();
    }

}
