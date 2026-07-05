package com.devpedrogo.jpa_project.service;

import org.springframework.stereotype.Service;

import com.devpedrogo.jpa_project.dto.AlunoDto;
import com.devpedrogo.jpa_project.exception.BadRequestException;
import com.devpedrogo.jpa_project.model.AlunosEntity;
import com.devpedrogo.jpa_project.repository.IAlunosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private IAlunosRepository alunosRepository;

    //CONTINUAR VALIDACOES
    public void criarAluno(AlunoDto alunoDto) throws BadRequestException{
        AlunosEntity aluno = alunosRepository.findByEmail(alunoDto.getEmail()).orElse(null);

        if(aluno != null){
            throw new BadRequestException("Aluno já cadastrado com esse email!");
        }

        AlunosEntity novoAluno = AlunosEntity.builder()
                .nome(alunoDto.getNome())
                .email(alunoDto.getEmail())
                .build();

        alunosRepository.save(novoAluno);
    }
}
