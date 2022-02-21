package com.colegioquipux.backend.services.user;

import com.colegioquipux.backend.models.dto.SignInDTO;
import com.colegioquipux.backend.models.dto.AuthResponseDTO;

public interface UserService {

	AuthResponseDTO signIn(SignInDTO signInDto);

}
