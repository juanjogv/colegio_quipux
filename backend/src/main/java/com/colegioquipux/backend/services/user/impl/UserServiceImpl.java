package com.colegioquipux.backend.services.user.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.colegioquipux.backend.models.dto.SignInDTO;
import com.colegioquipux.backend.models.dto.AuthResponseDTO;
import com.colegioquipux.backend.repositories.UserRepository;
import com.colegioquipux.backend.repositories.UsertypeRepository;
import com.colegioquipux.backend.security.jwt.JwtUtils;
import com.colegioquipux.backend.security.services.UserDetailsImpl;
import com.colegioquipux.backend.services.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UsertypeRepository usertypeRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@Override
	public AuthResponseDTO signIn(SignInDTO signInDto) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signInDto.getUserNickname(), signInDto.getUserPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		return new AuthResponseDTO(userDetails.getUsername(), userDetails.getEmail(), jwt, roles);
	}
}
