package com.jhon.backend.users.application.getUser;

import com.jhon.backend.users.domain.entity.User;
import lombok.Builder;

@Builder
public record UserResponse(
        String firstName,
        String middleName,
        String firstLastName,
        String secondLastName,
        long phone,
        String address,
        String cityResidence) {
    public static UserResponse fromDto(User user) {
        return UserResponse.builder()
                .firstName(user.firstName())
                .middleName(user.middleName())
                .firstLastName(user.firstLastName())
                .secondLastName(user.secondLastName())
                .phone(user.phone())
                .address(user.address())
                .cityResidence(user.cityResidence())
                .build();
    }
}
