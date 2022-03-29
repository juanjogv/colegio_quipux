package com.colegioquipux.backend.services.user.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegioquipux.backend.models.entity.UserEntity;
import com.colegioquipux.backend.repositories.UserRepository;
import com.colegioquipux.backend.services.user.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean existsUserByUsername (String userUsername) {
		return userRepository.existsByUsername(userUsername);
	}
	
	@Override
	public boolean existsUserByEmail (String userEmail) {
		return userRepository.existsByUserEmail(userEmail);
	}
	
	@Override
	public void saveUser (UserEntity user) {
		userRepository.save(user);
	}
	
	@Override
	public Optional<UserEntity> findUserByUsername (String username) {
		return userRepository.findByUsername(username);
	}
}
