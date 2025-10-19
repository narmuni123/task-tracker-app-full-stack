package com.munikiran.taskManager.service;

import com.munikiran.taskManager.dto.userDTO.UserAddDTO;
import com.munikiran.taskManager.dto.userDTO.UserDTO;
import com.munikiran.taskManager.dto.userDTO.UserUpdateDTO;

import java.util.List;

public interface UserService {

    UserDTO ddUser(UserAddDTO userAddDTO);

    UserDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    void deleteUser(Long id);
}
