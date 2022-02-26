package com.colegioquipux.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegioquipux.backend.models.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}