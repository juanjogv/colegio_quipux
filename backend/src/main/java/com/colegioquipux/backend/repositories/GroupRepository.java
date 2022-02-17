package com.colegioquipux.backend.repositories;

import com.colegioquipux.backend.models.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity, Integer> {
}