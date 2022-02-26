package com.colegioquipux.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegioquipux.backend.models.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	Optional<UserEntity> findByUserNickname(String userNickname);

	Boolean existsByUserNickname(String userNickname);

	Boolean existsByUserEmail(String userEmail);

}