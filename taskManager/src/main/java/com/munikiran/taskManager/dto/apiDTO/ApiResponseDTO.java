package com.munikiran.taskManager.dto.apiDTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDTO {
    private int status;
    private String message;
    private Object data;
}
