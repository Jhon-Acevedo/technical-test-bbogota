package com.jhon.backend.users.infraestructure.controller;

import com.jhon.backend.shared.HandleResponseValidationExceptions;
import com.jhon.backend.users.application.getUser.GetUserUseCase;
import com.jhon.backend.users.application.getUser.UserRequest;
import com.jhon.backend.users.domain.entity.TypeDocument;
import com.jhon.backend.users.domain.exceptions.UserNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.HandlerMethodValidator;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Tag(name = "Users", description = "Users API")
public class UserAPI {

    private final GetUserUseCase getUserUseCase;

    @Operation(summary = "Get User by typeDocument and documentNumber")
    @GetMapping("/")
    @Validated
    public ResponseEntity<?> getUser(
           @RequestParam(defaultValue = "") TypeDocument typeDocument,
           @Valid @NotBlank(message = "Document Number is empty") @RequestParam(defaultValue = "") String documentNumber) {
        UserRequest request = new UserRequest(typeDocument, documentNumber);
        return new ResponseEntity<>(getUserUseCase.execute(request), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UserNotFoundException.class})
    public Map<String, String> handleExceptions(RuntimeException ex) {
        return HandleResponseValidationExceptions.handleExceptions(ex);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String, String> handelValidationExceptions(MethodArgumentNotValidException ex) {
        return HandleResponseValidationExceptions.handelValidationExceptions(ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HandlerMethodValidationException.class})
    public Map<String, String> handelMethodValidationExceptions(MethodArgumentNotValidException ex) {
        return HandleResponseValidationExceptions.handelValidationExceptions(ex);
    }

}
