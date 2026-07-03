package com.devpedrogo.jpa_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devpedrogo.jpa_project.dto.AlunoDto;

// @Repository = Unnecessary
public interface IAlunosRepository extends JpaRepository<AlunoDto, Integer>{

}
