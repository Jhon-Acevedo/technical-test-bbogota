package com.jhon.backend.users.domain.entity;

import lombok.Getter;

@Getter
public enum TypeDocument {
    C("Cédula de ciudadanía"),
    P("Pasaporte");

    private final String description;

    TypeDocument(String description) {
        this.description = description;
    }

}
