package com.devpedrogo.jpa_project.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.devpedrogo.jpa_project.dto.AvaliacaoFisicaDto;
import com.devpedrogo.jpa_project.dto.AvaliacaoFisicaProjection;
import com.devpedrogo.jpa_project.exception.BadRequestException;
import com.devpedrogo.jpa_project.exception.NotFoundException;
import com.devpedrogo.jpa_project.model.AlunosEntity;
import com.devpedrogo.jpa_project.model.AvaliacoesFisicasEntity;
import com.devpedrogo.jpa_project.repository.IAlunosRepository;
import com.devpedrogo.jpa_project.repository.IAvaliacoesFisicasRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final IAlunosRepository alunosRepository;
    private final IAvaliacoesFisicasRepository avaliacoesFisicasRepository;

    public void criarAvaliacaoFisica(AvaliacaoFisicaDto avaliacaoFisicaDto)
            throws NotFoundException, BadRequestException {
        AlunosEntity aluno = alunosRepository.findById(avaliacaoFisicaDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado!"));

        AvaliacoesFisicasEntity avaliacaoFisica = aluno.getAvaliacaoFisica();
        if (avaliacaoFisica != null) {
            throw new BadRequestException("Avaliação física já cadastrada para este aluno.");
        }

        avaliacaoFisica = AvaliacoesFisicasEntity.builder()
                .peso(avaliacaoFisicaDto.getPeso())
                .altura(avaliacaoFisicaDto.getAltura())
                .porcentagemGorduraCorporal(avaliacaoFisicaDto.getPorcentagemGorduraCorporal())
                .build();

        aluno.setAvaliacaoFisica(avaliacaoFisica);
        alunosRepository.save(aluno);
    }

    public List<AvaliacaoFisicaProjection> getAllAvaliacoesFisicas() {
        return avaliacoesFisicasRepository.getAllAvaliacoesFisicas();
    }

    public Page<AvaliacaoFisicaProjection> getAllAvaliacoesFisicasPageable(Integer page, Integer size) {
        return avaliacoesFisicasRepository.getAllAvaliacoesFisicasPage(PageRequest.of(page, size));
    }
}
