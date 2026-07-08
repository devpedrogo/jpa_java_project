package com.devpedrogo.jpa_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devpedrogo.jpa_project.dto.AlunoDto;
import com.devpedrogo.jpa_project.exception.BadRequestException;
import com.devpedrogo.jpa_project.exception.NotFoundException;
import com.devpedrogo.jpa_project.service.AlunoService;
import com.devpedrogo.jpa_project.model.AlunosEntity;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/alunos")
public class AlunoController {
    private final AlunoService alunoService;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlunosEntity> listarAlunos() {
        return alunoService.listarAlunos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@Valid @RequestBody AlunoDto alunoDto) throws BadRequestException{
        alunoService.criarAluno(alunoDto);
    }
    
    @DeleteMapping("/{alunoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAluno(@Valid @PathVariable Integer alunoId) throws NotFoundException{
        alunoService.deletarAluno(alunoId);
    }
}
