package com.colegioquipux.backend.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegioquipux.backend.models.entity.UserEntity;
import com.colegioquipux.backend.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	UserRepository userRepository;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userNickname) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUserNickname(userNickname)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userNickname));
		return UserDetailsImpl.build(user);
	}
}
