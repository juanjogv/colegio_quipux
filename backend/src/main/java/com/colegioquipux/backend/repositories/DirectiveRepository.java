package com.colegioquipux.backend.repositories;

import com.colegioquipux.backend.models.entity.DirectiveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectiveRepository extends JpaRepository<DirectiveEntity, Integer> {
}