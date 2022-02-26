package com.colegioquipux.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegioquipux.backend.models.entity.UsertypeEntity;

@Repository
public interface UsertypeRepository extends JpaRepository<UsertypeEntity, Integer> {
}