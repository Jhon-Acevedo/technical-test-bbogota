package com.jhon.backend.users.infraestructure.repository.mapper;

import com.jhon.backend.users.domain.entity.User;
import com.jhon.backend.users.infraestructure.repository.dto.UserDto;

public class UserMapper {

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.id())
                .firstName(user.firstName())
                .middleName(user.middleName())
                .firstLastName(user.firstLastName())
                .secondLastName(user.secondLastName())
                .phone(user.phone())
                .address(user.address())
                .cityResidence(user.cityResidence())
                .build();
    }

    public static User toDomain(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .middleName(userDto.getMiddleName())
                .firstLastName(userDto.getFirstLastName())
                .secondLastName(userDto.getSecondLastName())
                .phone(userDto.getPhone())
                .address(userDto.getAddress())
                .cityResidence(userDto.getCityResidence())
                .build();
    }


}
