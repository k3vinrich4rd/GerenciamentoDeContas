package com.example.gerenciamentoDeContas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//Métodos assessores, modificadores, construtor, construtor vazio, entidade e tabela
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cidades")
public class CidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo; //Primary key

    @Column(name = "nome_cidade", length = 75, nullable = false)
    private String nomeCidade;// coluna

    @ManyToOne
    //foreign key
    @JoinColumn(name = "estado_id", referencedColumnName = "codigo")
    private EstadoModel estadoModel; //Coluna para juntar


    @JsonIgnore // Pergunta para grazi sobre os mapeamentos.
    //Relacionamento de um para muitos
    @OneToMany(mappedBy = "cidadeModel", cascade = CascadeType.ALL)
    private List<EnderecoModel> enderecoModel = new ArrayList<>();
}
