package com.devpedrogo.jpa_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devpedrogo.jpa_project.model.RolesEntity;

public interface IRolesRepository extends JpaRepository<RolesEntity, Integer> {

}
