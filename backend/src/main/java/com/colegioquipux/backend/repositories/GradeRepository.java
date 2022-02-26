package com.colegioquipux.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegioquipux.backend.models.entity.GradeEntity;

@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, Integer> {
}