package com.colegioquipux.backend.services.userentry;

import org.springframework.http.ResponseEntity;

import com.colegioquipux.backend.models.dto.AuthResponseDTO;
import com.colegioquipux.backend.models.dto.SignInDTO;
import com.colegioquipux.backend.models.dto.SignUpDTO;

public interface UserEntryService {

	ResponseEntity<?> signIn(SignInDTO signInDTO);

	ResponseEntity<?> signUp(SignUpDTO signUpDTO) throws Exception;

}
