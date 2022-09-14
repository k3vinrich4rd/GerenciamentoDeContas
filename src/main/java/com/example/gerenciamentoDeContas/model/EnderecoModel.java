package com.example.gerenciamentoDeContas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@Table(name = "enderecos")
public class EnderecoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "logradouro_endereco", length = 100, nullable = false)
    private String logradouro;

    @Column(name = "bairro_endereco", length = 100, nullable = false)
    private String bairro;

    @Column(name = "cep_endereco", length = 100, nullable = false)
    private String cep;

    @Column(name = "ponto_de_referencia_endereco", length = 100, nullable = false)
    private String pontoReferencia;

    @ManyToOne
    @JoinColumn(name = "cidade_id", referencedColumnName = "codigo")
    private CidadeModel cidadeModel;
}
