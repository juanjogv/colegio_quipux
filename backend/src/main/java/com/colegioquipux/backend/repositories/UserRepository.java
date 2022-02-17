package com.colegioquipux.backend.repositories;

import com.colegioquipux.backend.models.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}