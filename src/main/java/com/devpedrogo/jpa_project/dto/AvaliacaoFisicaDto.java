package com.devpedrogo.jpa_project.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AvaliacaoFisicaDto {

    @NotNull
    private Integer alunoId;

    @NotNull
    private BigDecimal peso;

    @NotNull
    private BigDecimal altura;

    @NotNull
    private BigDecimal porcentagemGorduraCorporal;
}
