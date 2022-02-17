package com.colegioquipux.backend.repositories;

import com.colegioquipux.backend.models.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {
}