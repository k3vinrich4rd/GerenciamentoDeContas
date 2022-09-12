package com.example.gerenciamentoDeContas.model;

import com.example.gerenciamentoDeContas.enumeric.Status;
import com.example.gerenciamentoDeContas.enumeric.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

//Getters, Setters, Construtor, Construtor vazio, Entidade e Tabela que será criada dentro do banco de dados
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gerenciamento_de_contas")
public class ContasAPagarModel implements Serializable {
    //Model do projeto

    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Atributo

    @Column(length = 50, nullable = false)
    private String nome; //Atributo

    //O precision cuida da quantidade de digitos
    //O scale cuida da quantidade de casas decimais depois da vírgula
    @Column(length = 50, nullable = false)
    private Double valor; //Atributo

    //Atributo do tipo Enumerated
    @Enumerated(EnumType.STRING)
    private Tipo tipo; //Atributo

    //Coluna
    @Column(name = "data_de_vencimento", length = 50, nullable = false)
    public LocalDate dataDeVencimento; //Atributo

    //Coluna
    @Column(name = "data_de_pagamento")
    public LocalDateTime dataDePagamento; //Atributo

    //Atributo do tipo Enumerated
    @Enumerated(EnumType.STRING)
    private Status status; //Atributo


}
