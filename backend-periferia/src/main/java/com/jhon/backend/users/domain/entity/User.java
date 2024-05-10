package com.jhon.backend.users.domain.entity;

import lombok.Builder;

@Builder
public record User(
        int id,
        String firstName,
        String middleName,
        String firstLastName,
        String secondLastName,
        long phone,
        String address,
        String cityResidence
) {
}
