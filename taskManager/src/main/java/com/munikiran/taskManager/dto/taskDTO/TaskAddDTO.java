package com.munikiran.taskManager.dto.taskDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskAddDTO {

    @NotBlank(message = "Description is required")
    private String description;

    private String status; // optional, or you can use Status enum directly

    @NotNull(message = "User ID is required")
    private Long userId;
}
