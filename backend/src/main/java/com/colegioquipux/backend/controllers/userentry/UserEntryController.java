package com.colegioquipux.backend.controllers.userentry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegioquipux.backend.models.dto.SignInDTO;
import com.colegioquipux.backend.models.dto.SignUpDTO;
import com.colegioquipux.backend.services.userentry.UserEntryService;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class UserEntryController {

	@Autowired
	private UserEntryService userService;

	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestBody SignInDTO signInDTO) {
		return userService.signIn(signInDTO);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody SignUpDTO signUpDTO) {
		return userService.signUp(signUpDTO);
	}
}
