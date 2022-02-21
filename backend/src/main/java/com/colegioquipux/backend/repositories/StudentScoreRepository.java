package com.colegioquipux.backend.repositories;

import com.colegioquipux.backend.models.entity.StudentScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentScoreRepository extends JpaRepository<StudentScoreEntity, Integer> {
}