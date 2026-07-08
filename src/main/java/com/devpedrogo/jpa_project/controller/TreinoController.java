package com.devpedrogo.jpa_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devpedrogo.jpa_project.dto.TreinoDto;
import com.devpedrogo.jpa_project.exception.BadRequestException;
import com.devpedrogo.jpa_project.exception.NotFoundException;
import com.devpedrogo.jpa_project.service.TreinoService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("v1/treinos")
@Tag(name = "Treinos", description = "Endpoints para gerenciamento de treinos")
@AllArgsConstructor
public class TreinoController {
    private final TreinoService treinoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTreino(@Valid @RequestBody TreinoDto treinoDto) throws BadRequestException, NotFoundException {
        treinoService.criarTreino(treinoDto);
    }
}
