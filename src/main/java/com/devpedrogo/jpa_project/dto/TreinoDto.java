package com.devpedrogo.jpa_project.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TreinoDto {

    @NotNull
    private Integer alunoId;

    @NotBlank
    private String nome;

    @NotNull
    private List<Integer> exerciciosIds;
}
