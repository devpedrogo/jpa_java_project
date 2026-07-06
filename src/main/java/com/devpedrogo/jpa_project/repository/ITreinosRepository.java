package com.devpedrogo.jpa_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devpedrogo.jpa_project.model.TreinosEntity;

// @Repository = Unnecessary
public interface ITreinosRepository extends JpaRepository<TreinosEntity, Integer>{

    Optional<TreinosEntity> findByName(String nome);
}
