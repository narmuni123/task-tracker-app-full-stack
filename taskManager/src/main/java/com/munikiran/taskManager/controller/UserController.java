package com.munikiran.taskManager.controller;

import com.munikiran.taskManager.dto.apiDTO.ApiResponseDTO;
import com.munikiran.taskManager.dto.userDTO.UserAddDTO;
import com.munikiran.taskManager.dto.userDTO.UserDTO;
import com.munikiran.taskManager.dto.userDTO.UserUpdateDTO;
import com.munikiran.taskManager.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<ApiResponseDTO> addUser(@RequestBody @Valid UserAddDTO userAddDTO) {
        UserDTO user = userService.addUser(userAddDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponseDTO(HttpStatus.CREATED.value(), "User created successfully.", user)
        );
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<ApiResponseDTO> updateUser(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO userUpdateDTO) {
        UserDTO user = userService.updateUser(id, userUpdateDTO);

        return  ResponseEntity.ok(new ApiResponseDTO(200, "User updated successfully", user));
    }

    @GetMapping
    public ResponseEntity<ApiResponseDTO> getAllUsers(){
        List<UserDTO> userDTOList = userService.getAllUsers();
        return  ResponseEntity.ok(new ApiResponseDTO(200, "Users fetched successfully", userDTOList));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponseDTO> getUSerByID(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);

        return ResponseEntity.ok(new ApiResponseDTO(200, "User fetched successfully", user));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ApiResponseDTO> deleterUser(@PathVariable Long id) {
        userService.deleteUser(id);

        return ResponseEntity.ok(
                new ApiResponseDTO(HttpStatus.OK.value(), "User deleted successfully.", null)
        );
    }

}
