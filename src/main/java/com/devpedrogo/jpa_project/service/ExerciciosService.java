package com.devpedrogo.jpa_project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devpedrogo.jpa_project.dto.ExercicioDto;
import com.devpedrogo.jpa_project.model.ExerciciosEntity;
import com.devpedrogo.jpa_project.repository.IExerciciosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExerciciosService {
    
    private final IExerciciosRepository exerciciosRepository;

    public List<ExerciciosEntity> findAll(){
        return exerciciosRepository.findAll();
    }

    public void save(ExercicioDto exercicioDto){
        ExerciciosEntity exercicio = ExerciciosEntity.builder()
                .nome(exercicioDto.getNome())
                .grupoMuscular(exercicioDto.getGrupoMuscular())
                .build();

        exerciciosRepository.save(exercicio);
    }

    public List<ExerciciosEntity> findAllByGrupoMuscular(String grupoMuscular){
        return exerciciosRepository.findAllByGrupoMuscular(grupoMuscular);
    }

    public void deleteById(Integer id){
        exerciciosRepository.deleteById(id);
    }
}
