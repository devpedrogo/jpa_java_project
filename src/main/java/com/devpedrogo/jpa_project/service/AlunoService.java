package com.devpedrogo.jpa_project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devpedrogo.jpa_project.dto.AlunoDto;
import com.devpedrogo.jpa_project.exception.BadRequestException;
import com.devpedrogo.jpa_project.exception.NotFoundException;
import com.devpedrogo.jpa_project.model.AlunosEntity;
import com.devpedrogo.jpa_project.repository.IAlunosRepository;
import com.devpedrogo.jpa_project.repository.IAvaliacoesFisicasRepository;
import com.devpedrogo.jpa_project.repository.ITreinosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final IAlunosRepository alunosRepository;
    private final ITreinosRepository treinosRepository;
    private final IAvaliacoesFisicasRepository avaliacoesFisicasRepository;

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

    public List<AlunosEntity> listarAlunos() {
        return alunosRepository.findAll();
    }

    public AlunosEntity buscarAlunoPorId(Integer alunoId) throws NotFoundException {
        return alunosRepository.findById(alunoId)
                .orElseThrow(() -> new NotFoundException("Aluno com id [" + alunoId + "] não encontrado!"));
    }

    //Rollback com a anotação @Transactional para manter a integridade dos dados
    @Transactional(rollbackFor = Exception.class)
    public void deletarAluno(Integer alunoId) throws NotFoundException{

        AlunosEntity aluno = alunosRepository.findById(alunoId).orElseThrow(() -> new NotFoundException("Aluno com id [" + alunoId + "] não encontrado!"));

        List<Integer> treinosAlunoIds = aluno.getTreinos().stream().map(treino -> treino.getId()).toList(); //poderia usar no map TreinosEntity::getId

        treinosRepository.deleteAllById(treinosAlunoIds);

        if (aluno.getAvaliacaoFisica() != null) {
            avaliacoesFisicasRepository.delete(aluno.getAvaliacaoFisica());
        }

        alunosRepository.delete(aluno);
    }
}
