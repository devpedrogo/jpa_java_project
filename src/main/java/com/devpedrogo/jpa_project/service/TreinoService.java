package com.devpedrogo.jpa_project.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.devpedrogo.jpa_project.dto.TreinoDto;
import com.devpedrogo.jpa_project.exception.BadRequestException;
import com.devpedrogo.jpa_project.exception.NotFoundException;
import com.devpedrogo.jpa_project.model.AlunosEntity;
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

    public void criarTreino(TreinoDto treinoDto) throws BadRequestException, NotFoundException {
        Set<ExerciciosEntity> exercicios = new HashSet<>();

        AlunosEntity aluno = alunosRepository.findById(treinoDto.getAlunoId()).orElse(null);

        if(aluno == null){
            throw new NotFoundException("Aluno não encontrado!");
        }

        TreinosEntity treino = treinosRepository.findByNomeAndAlunoId(treinoDto.getNome(), treinoDto.getAlunoId()).orElse(null);

        if(treino != null){
            throw new BadRequestException("Treino já cadastrado com esse nome para esse aluno!");
        }

        for(Integer exercicioId : treinoDto.getExerciciosIds()){
            ExerciciosEntity exercicio = exerciciosRepository.findById(exercicioId)
                .orElseThrow(() -> new NotFoundException("Exercício com ID " + exercicioId + " não encontrado!"));

            exercicios.add(exercicio);
        }

        treino = TreinosEntity.builder()
                .nome(treinoDto.getNome())
                .aluno(aluno)
                .exercicios(exercicios)
                .build();

        treinosRepository.save(treino);
    }
}
