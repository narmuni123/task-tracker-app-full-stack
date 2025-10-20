package com.munikiran.taskManager.utils.mapper;

import com.munikiran.taskManager.dto.taskDTO.TaskDTO;
import com.munikiran.taskManager.dto.userDTO.UserDTO;
import com.munikiran.taskManager.model.User;

import java.util.List;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        List<TaskDTO> taskDTOs = user.getTasks().stream()
                .map(task -> new TaskDTO(
                        task.getId(),
                        task.getDescription(),
                        task.getStatus(),
                        task.getCreatedAt(),
                        task.getUpdatedAt()
                ))
                .toList();

        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                taskDTOs
        );
    }
}
