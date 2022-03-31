package com.colegioquipux.backend.services.userentry.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.colegioquipux.backend.models.dto.AuthResponseDTO;
import com.colegioquipux.backend.models.dto.SignInDTO;
import com.colegioquipux.backend.models.dto.SignUpDTO;
import com.colegioquipux.backend.models.entity.UserEntity;
import com.colegioquipux.backend.models.payload.MessageResponse;
import com.colegioquipux.backend.security.jwt.JwtUtils;
import com.colegioquipux.backend.security.services.UserDetailsImpl;
import com.colegioquipux.backend.services.user.UserService;
import com.colegioquipux.backend.services.userentry.UserEntryService;
import com.colegioquipux.backend.utils.Constantes.YNAnswer;
import com.colegioquipux.backend.utils.DateUtils;

@Service
public class UserEntryServiceImpl implements UserEntryService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private UserService userService;

	@Override
	public ResponseEntity<?> signIn(SignInDTO signInDTO) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signInDTO.getUsername(), signInDTO.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK)
				.body(new AuthResponseDTO(userDetails.getUsername(), userDetails.getEmail(), jwt, roles));
	}

	@Override
	public ResponseEntity<?> signUp(SignUpDTO signUpDTO) {

		if (Boolean.TRUE.equals(userService.existsUserByUsername(signUpDTO.getUsername()))) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new MessageResponse("Error: Este usuario ya esta registrado!"));
		}
		if (Boolean.TRUE.equals(userService.existsUserByEmail(signUpDTO.getEmail()))) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new MessageResponse("Error: Este email ya esta en uso!"));
		}

		UserEntity user = new UserEntity();

		user.setUserUsername(signUpDTO.getUsername());
		user.setUserEmail(signUpDTO.getEmail());
		user.setUserPassword(encoder.encode(signUpDTO.getPassword()));
		user.setUserType(signUpDTO.getUserType());
		user.setRegisterDate(Timestamp.valueOf(DateUtils.dateTime()));
		user.setIsActive(YNAnswer.Y);

		userService.saveUser(user);

		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Usuario registrado satisfactoriamente!"));
	}
}
