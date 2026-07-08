package com.devpedrogo.jpa_project.controller;

import org.springframework.web.bind.annotation.RestController;

import com.devpedrogo.jpa_project.dto.AvaliacaoFisicaDto;
import com.devpedrogo.jpa_project.dto.AvaliacaoFisicaProjection;
import com.devpedrogo.jpa_project.exception.BadRequestException;
import com.devpedrogo.jpa_project.exception.NotFoundException;
import com.devpedrogo.jpa_project.service.AvaliacaoFisicaService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("v1/avaliacoes")
@Tag(name = "Avaliações Físicas", description = "Endpoints para gerenciamento de avaliações físicas")
@RequiredArgsConstructor
public class AvaliacaoFisicaController {
    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto)
            throws NotFoundException, BadRequestException {
        avaliacaoFisicaService.criarAvaliacaoFisica(avaliacaoFisicaDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AvaliacaoFisicaProjection> getAllAvaliacoesFisicas() {
        return avaliacaoFisicaService.getAllAvaliacoesFisicas();
    }

    @GetMapping("/page/{page}/size{size}")
    @ResponseStatus(HttpStatus.OK)
    public Page<AvaliacaoFisicaProjection> getAllAvaliacoesFisicasPageable(@PathVariable Integer page,
            @PathVariable Integer size) {
        return avaliacaoFisicaService.getAllAvaliacoesFisicasPageable(page, size);
    }
}
