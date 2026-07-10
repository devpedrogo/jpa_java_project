package com.devpedrogo.jpa_project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterRequestDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
}
