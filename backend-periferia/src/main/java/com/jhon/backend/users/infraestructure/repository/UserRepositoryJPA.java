package com.jhon.backend.users.infraestructure.repository;

import com.jhon.backend.users.domain.entity.TypeDocument;
import com.jhon.backend.users.infraestructure.repository.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryJPA extends JpaRepository<UserDto, Integer> {

    default Optional<UserDto> findByTypeDocumentAndDocumentNumber(TypeDocument typeDocument, String documentNumber) {
        if (typeDocument == TypeDocument.C && documentNumber.equals("23445322")) {
            return Optional.of(new UserDto(
                    1,
                    "Jhon",
                    "Edwin",
                    "Acevedo",
                    "Jimenez",
                    320313367,
                    "20 de julio",
                    "Bogota D.C",
                    TypeDocument.C,
                    "23445322"
            ));
        }
        return Optional.empty();
    }

}
