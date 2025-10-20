package com.munikiran.taskManager.dto.taskDTO;

import com.munikiran.taskManager.dto.userDTO.UserDTO;
import com.munikiran.taskManager.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Long id;

    private String description;

    private Status status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
