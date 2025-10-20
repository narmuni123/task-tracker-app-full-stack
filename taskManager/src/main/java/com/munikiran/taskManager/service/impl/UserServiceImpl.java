package com.munikiran.taskManager.service.impl;

import com.munikiran.taskManager.dto.userDTO.UserAddDTO;
import com.munikiran.taskManager.dto.userDTO.UserDTO;
import com.munikiran.taskManager.dto.userDTO.UserUpdateDTO;
import com.munikiran.taskManager.exception.ResourceNotFoundException;
import com.munikiran.taskManager.exception.UserAlreadyExistsException;
import com.munikiran.taskManager.model.User;
import com.munikiran.taskManager.repository.UserRepository;
import com.munikiran.taskManager.service.UserService;
import com.munikiran.taskManager.utils.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO addUser(UserAddDTO userAddDTO) {
        User user = new User();

        user.setUsername(userAddDTO.getUsername());
        user.setEmail(userAddDTO.getEmail());
        user.setPassword(userAddDTO.getPassword());

        return mapToDTO(userRepository.save(user));
    }

    @Override
    public UserDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        if (!user.getUsername().equals(userUpdateDTO.getUsername()) &&
                userRepository.existsByUsername(userUpdateDTO.getUsername())) {
            throw new UserAlreadyExistsException("Username already taken");
        }

        if (!user.getEmail().equals(userUpdateDTO.getEmail()) &&
                userRepository.existsByEmail(userUpdateDTO.getEmail())) {
            throw new UserAlreadyExistsException("Email already registered");
        }
        user.setEmail(userUpdateDTO.getEmail());
        user.setUsername(userUpdateDTO.getUsername());
        return mapToDTO(userRepository.save(user));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToDTO).toList();
    }
    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return mapToDTO(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
    }

    private UserDTO mapToDTO(User user) {
        return UserMapper.toDTO(user);
    }
}
