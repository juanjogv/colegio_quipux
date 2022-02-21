package com.colegioquipux.backend.repositories;

import com.colegioquipux.backend.models.EUserTypes;
import com.colegioquipux.backend.models.entity.UsertypeEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsertypeRepository extends JpaRepository<UsertypeEntity, Integer> {
	Optional<UsertypeEntity> findByUserTypeName(EUserTypes userTypeName);
}