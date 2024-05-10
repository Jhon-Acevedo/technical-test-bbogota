package com.jhon.backend.users.application.getUser;

import com.jhon.backend.users.domain.entity.TypeDocument;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank(message = "Type Document is empty") TypeDocument typeDocument,
        @NotBlank(message = "Document Number is empty") String documentNumber) {
}
