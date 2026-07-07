package com.devpedrogo.jpa_project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import com.devpedrogo.jpa_project.dto.AvaliacaoFisicaProjection;
import com.devpedrogo.jpa_project.model.AvaliacoesFisicasEntity;
import java.util.List;

// @Repository = Unnecessary
public interface IAvaliacoesFisicasRepository extends JpaRepository<AvaliacoesFisicasEntity, Integer> {
    @NativeQuery(value = """
            SELECT a.id idAluno,
                a.nome nomeAluno,
                af.id idAvaliacao,
                af.peso peso,
                af.altura altura,
                af.porcentagem_gordura_corporal porcentagemGorduraCorporal
            FROM avaliacoes_fisicas af
            INNER JOIN alunos a
            ON a.avaliacao_fisica_id = af.id
            """)
    List<AvaliacaoFisicaProjection> getAllAvaliacoesFisicas();

    @NativeQuery(value = """
            SELECT a.id idAluno,
                a.nome nomeAluno,
                af.id idAvaliacao,
                af.peso peso,
                af.altura altura,
                af.porcentagem_gordura_corporal porcentagemGorduraCorporal
            FROM avaliacoes_fisicas af
            INNER JOIN alunos a
            ON a.avaliacao_fisica_id = af.id
            """, countQuery = """
            SELECT count(af.id)
            FROM avaliacoes_fisicas af
            INNER JOIN alunos a
            ON a.avaliacao_fisica_id = af.id
            """)
    Page<AvaliacaoFisicaProjection> getAllAvaliacoesFisicasPage(Pageable pageable);
}
