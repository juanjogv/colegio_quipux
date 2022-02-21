package com.colegioquipux.backend.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegioquipux.backend.models.dto.SignInDTO;
import com.colegioquipux.backend.services.user.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/signin")
	public ResponseEntity<?> read(@RequestBody SignInDTO signInDto) {	
		return ResponseEntity.status(HttpStatus.OK).body(userService.signIn(signInDto));
	}

}
