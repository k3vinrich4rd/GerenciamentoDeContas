package com.example.gerenciamentoDeContas.model;

import com.example.gerenciamentoDeContas.enumeric.Status;
import com.example.gerenciamentoDeContas.enumeric.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gerenciamento_de_contas")
public class ContasAPagarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private Double valor;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(name = "data_de_vencimento", length = 50, nullable = false)
    public LocalDate dataDeVencimento;

    @Column(name = "data_de_pagamento")
    public LocalDateTime dataDePagamento;

    @Enumerated(EnumType.STRING)
    private Status status;


}
