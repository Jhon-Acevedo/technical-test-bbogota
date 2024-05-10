package com.jhon.backend.users.application.getUser;

import com.jhon.backend.common.UseCase;
import com.jhon.backend.users.domain.exceptions.UserNotFoundException;
import com.jhon.backend.users.domain.repository.IUserRepository;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class GetUserUseCase {

    private final IUserRepository userRepository;
    public UserResponse execute(UserRequest userRequest) {
        var user = userRepository.getUserByTypeDocumentAndDocumentNumber(userRequest.typeDocument(), userRequest.documentNumber()).orElseThrow(UserNotFoundException::new);
        return UserResponse.fromDto(user);
    }

}
