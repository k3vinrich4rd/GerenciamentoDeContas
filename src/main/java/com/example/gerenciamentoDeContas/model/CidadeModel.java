package com.example.gerenciamentoDeContas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cidades")
public class CidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cidade", length = 75, nullable = false)
    private String nomeCidade;

    @ManyToOne
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    private EstadoModel estadoModel;
}
