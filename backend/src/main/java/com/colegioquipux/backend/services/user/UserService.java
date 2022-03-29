package com.colegioquipux.backend.services.user;

import java.util.Optional;

import com.colegioquipux.backend.models.entity.UserEntity;

public interface UserService {

	boolean existsUserByUsername(String userUsername);

	boolean existsUserByEmail(String userEmail);

	void saveUser(UserEntity user);

	Optional<UserEntity> findUserByUsername(String username);

}
