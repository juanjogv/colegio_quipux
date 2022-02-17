package com.colegioquipux.backend.repositories;

import com.colegioquipux.backend.models.entity.UsertypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsertypeRepository extends JpaRepository<UsertypeEntity, Integer> {
}