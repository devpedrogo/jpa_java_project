package com.devpedrogo.jpa_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devpedrogo.jpa_project.model.ExerciciosEntity;

// @Repository = Unnecessary
public interface IExerciciosRepository extends JpaRepository<ExerciciosEntity, Integer>{

}
