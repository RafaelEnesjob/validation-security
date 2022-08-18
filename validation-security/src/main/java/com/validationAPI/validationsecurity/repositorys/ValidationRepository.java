package com.validationAPI.validationsecurity.repositorys;

import com.validationAPI.validationsecurity.models.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationRepository extends JpaRepository<Validation, Integer> {
}
