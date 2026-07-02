package com.devpedrogo.jpa_project.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "avaliacoes_fisicas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvaliacoesFisicasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "peso", nullable = false)
    private BigDecimal peso;

    @Column(name = "altura", nullable = false)
    private BigDecimal altura;

    @Column(name = "porcentagem_gordura_corporal", nullable = false)
    private BigDecimal porcentagemGorduraCorporal;
}
