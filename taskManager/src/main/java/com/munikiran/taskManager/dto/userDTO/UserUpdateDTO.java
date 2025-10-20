package com.munikiran.taskManager.dto.userDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO {
    @NotNull(message = "Id is required")
    private Long id;

    private String username;

    @Email(message = "Email is not valid")
    private String email;

    private String password;

}
