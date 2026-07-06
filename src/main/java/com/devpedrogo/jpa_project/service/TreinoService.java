package com.devpedrogo.jpa_project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devpedrogo.jpa_project.dto.TreinoDto;
import com.devpedrogo.jpa_project.exception.BadRequestException;
import com.devpedrogo.jpa_project.model.ExerciciosEntity;
import com.devpedrogo.jpa_project.model.TreinosEntity;
import com.devpedrogo.jpa_project.repository.IAlunosRepository;
import com.devpedrogo.jpa_project.repository.IExerciciosRepository;
import com.devpedrogo.jpa_project.repository.ITreinosRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TreinoService {

    private final IAlunosRepository alunosRepository;
    private final IExerciciosRepository exerciciosRepository;
    private final ITreinosRepository treinosRepository;

    public void criarTreino(TreinoDto treinoDto) throws BadRequestException{
        List<ExerciciosEntity> exercicios = new ArrayList<>();

        TreinosEntity treino = treinosRepository.findByName(treinoDto.getNome()).orElse(null);

        if(treino != null){
            throw new BadRequestException("Treino já cadastrado com esse nome para esse aluno!");
        }

            // CONTINUA

        // TreinosEntity treino = TreinosEntity.builder()
        //         .nome(treinoDto.getNome())
        //         .aluno(treinoDto.getAlunoId())
        //         .exercicios(treinoDto.getExerciciosIds())
        //         .build();
    }
}
