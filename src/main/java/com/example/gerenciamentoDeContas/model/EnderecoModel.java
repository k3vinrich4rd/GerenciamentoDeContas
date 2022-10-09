package com.example.gerenciamentoDeContas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enderecos")
//Métodos assessores, modificadores, construtor, construtor vazio, entidade e tabela
public class EnderecoModel implements Serializable {
    private static final long serialVersionUID = 1L; //Controle das conversões feitas pela JVM

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codigo; //Primary key

    @Column(name = "logradouro_endereco", length = 100, nullable = false)
    private String logradouro; //Coluna

    @Column(name = "bairro_endereco", length = 100, nullable = false)
    private String bairro; //Coluna

    @Column(name = "cep_endereco", length = 100, nullable = false)
    private String cep; //Coluna

    @Column(name = "ponto_de_referencia_endereco", length = 100, nullable = false)
    private String pontoReferencia; //Coluna

    @ManyToOne //Relacionamento
    @JoinColumn(name = "cidade_id", referencedColumnName = "codigo") //Junção de tabelas
    private CidadeModel cidadeModel; //Foreign key

    @JsonIgnore // mapeamento de um para muitos
    @OneToMany(mappedBy = "enderecoModel", cascade = CascadeType.ALL)
    private List<UsuarioModel> usuarioModel = new ArrayList<>();
}
