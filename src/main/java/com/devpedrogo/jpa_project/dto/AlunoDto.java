package com.devpedrogo.jpa_project.dto;

import jakarta.validation.constraints.NotBlank;

public class AlunoDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
}
