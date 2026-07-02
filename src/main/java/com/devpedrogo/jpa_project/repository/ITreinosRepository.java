package com.devpedrogo.jpa_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devpedrogo.jpa_project.model.TreinosEntity;

// @Repository = Unnecessary
public interface ITreinosRepository extends JpaRepository<TreinosEntity, Integer>{

}
