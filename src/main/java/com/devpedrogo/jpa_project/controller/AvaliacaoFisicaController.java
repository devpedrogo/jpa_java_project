package com.devpedrogo.jpa_project.controller;

import org.springframework.web.bind.annotation.RestController;

import com.devpedrogo.jpa_project.dto.AvaliacaoFisicaDto;
import com.devpedrogo.jpa_project.exception.BadRequestException;
import com.devpedrogo.jpa_project.exception.NotFoundException;
import com.devpedrogo.jpa_project.service.AvaliacaoFisicaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("v1/avaliacoes")
@RequiredArgsConstructor
public class AvaliacaoFisicaController {
    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException{
        avaliacaoFisicaService.criarAvaliacaoFisica(avaliacaoFisicaDto);
    }
    
}
