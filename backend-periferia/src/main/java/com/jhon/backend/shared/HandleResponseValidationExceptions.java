package com.jhon.backend.shared;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

public class HandleResponseValidationExceptions {
    public static Map<String, String> handelValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    public static Map<String, String> handleExceptions(Exception ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Error", ex.getMessage());
        errors.put("timestamp", String.valueOf(System.currentTimeMillis()));
        return errors;
    }
}
