package com.devpedrogo.jpa_project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlunoDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
}
