package com.jhon.backend.users.infraestructure.repository;

import com.jhon.backend.users.domain.entity.TypeDocument;
import com.jhon.backend.users.domain.entity.User;
import com.jhon.backend.users.domain.repository.IUserRepository;
import com.jhon.backend.users.infraestructure.repository.dto.UserDto;
import com.jhon.backend.users.infraestructure.repository.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserRepositoryImpl implements IUserRepository {

    private final UserRepositoryJPA userRepositoryJPA;

    @Override
    public Optional<User> getUserByTypeDocumentAndDocumentNumber(TypeDocument typeDocument, String documentNumber) {
        Optional<UserDto> userDto = this.userRepositoryJPA.findByTypeDocumentAndDocumentNumber(typeDocument, documentNumber);
        return userDto.map(UserMapper::toDomain);
    }
}
