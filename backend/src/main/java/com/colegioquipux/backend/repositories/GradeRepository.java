package com.colegioquipux.backend.repositories;

import com.colegioquipux.backend.models.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<GradeEntity, Integer> {
}