package com.jhon.backend.users.domain.repository;

import com.jhon.backend.users.domain.entity.TypeDocument;
import com.jhon.backend.users.domain.entity.User;

import java.util.Optional;

public interface IUserRepository {

    Optional<User> getUserByTypeDocumentAndDocumentNumber(TypeDocument typeDocument, String documentNumber);
}
