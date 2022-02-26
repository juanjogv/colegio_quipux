package com.colegioquipux.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegioquipux.backend.models.entity.DirectiveEntity;

@Repository
public interface DirectiveRepository extends JpaRepository<DirectiveEntity, Integer> {
}