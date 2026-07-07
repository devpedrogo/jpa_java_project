package com.devpedrogo.jpa_project.dto;

import java.math.BigDecimal;

public interface AvaliacaoFisicaProjection {
    Integer getIdAluno();
    String getNomeAluno();
    Integer getIdAvaliacao();
    BigDecimal getPeso();
    BigDecimal getAltura();
    BigDecimal getPorcentagemGorduraCorporal();
}
