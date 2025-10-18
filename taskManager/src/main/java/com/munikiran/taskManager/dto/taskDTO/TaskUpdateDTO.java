package com.munikiran.taskManager.dto.taskDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskUpdateDTO {

    @NotNull(message = "Task ID is required")
    private Long id;

    private String description;

    private String status; // or Status enum
}
