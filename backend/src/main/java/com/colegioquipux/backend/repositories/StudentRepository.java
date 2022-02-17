package com.colegioquipux.backend.repositories;

import com.colegioquipux.backend.models.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}