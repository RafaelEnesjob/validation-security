package com.validationAPI.validationsecurity.domain.repositories;

import com.validationAPI.validationsecurity.domain.entities.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationRepository extends JpaRepository<Validation, Integer> {
}
