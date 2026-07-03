package com.devpedrogo.jpa_project.service;

import com.devpedrogo.jpa_project.dto.AlunoDto;
import com.devpedrogo.jpa_project.repository.IAlunosRepository;

public class AlunoService {
    private IAlunosRepository alunosRepository;
    //CONTINUAR VALIDACOES
    public void criarAluno(AlunoDto alunoDto){
        alunosRepository.save(alunoDto);
    }
}
