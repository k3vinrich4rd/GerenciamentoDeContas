package com.example.gerenciamentoDeContas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//Métodos assessores, modificadores, construtor, construtor vazio, entidade e tabela
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estados")
public class EstadoModel {
    private static final long serialVersionUID = 1L; //Controle das conversões feitas pela JVM


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codigo; // Primary key

    @Column(name = "uf_estado", length = 2, nullable = false)
    private String uf; //Coluna

    @Column(name = "nome_estado", length = 50, nullable = false)
    private String nomeEstado; //Coluna

    @JsonIgnore
    //Relacionamento de um para muitos
    @OneToMany(mappedBy = "estadoModel", cascade = CascadeType.ALL)
    private List<CidadeModel> cidadeModel = new ArrayList<>();
}
