package com.devpedrogo.jpa_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devpedrogo.jpa_project.model.AlunosEntity;
import java.util.Optional;

// @Repository = Unnecessary because JpaRepository already has this annotation, so it is not necessary to add it again.
public interface IAlunosRepository extends JpaRepository<AlunosEntity, Integer>{

    Optional<AlunosEntity> findByEmail(String email);
}
