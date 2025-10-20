package com.munikiran.taskManager.exception;

import com.munikiran.taskManager.dto.apiDTO.ApiResponseDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Validation Errors: @Valid failed
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseDTO> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.badRequest().body(
                new ApiResponseDTO(HttpStatus.BAD_REQUEST.value(), "Validation failed", errors)
        );
    }

    // Unique Constraint / Duplicate Email etc.
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponseDTO> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String message = "Data integrity violation: " + extractDuplicateKeyMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new ApiResponseDTO(HttpStatus.CONFLICT.value(), message, null)
        );
    }

    // Catch-all fallback
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDTO> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ApiResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null)
        );
    }

    private String extractDuplicateKeyMessage(String message) {
        if (message.contains("Duplicate entry") && message.contains("for key")) {
            String[] parts = message.split("for key");
            return parts[0].trim();
        }
        return message;
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiResponseDTO> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new ApiResponseDTO(HttpStatus.CONFLICT.value(), ex.getMessage(), null)
        );
    }
}
