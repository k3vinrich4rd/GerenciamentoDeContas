package com.example.gerenciamentoDeContas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Métodos assessores, modificadores, construtor, construtor vazio, entidade, tabela e validated
//Para fazer validações
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
@Validated

public class UsuarioModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo; //Primary key

    @Column(name = "nome_usuario", length = 55, nullable = false)
    @NotBlank(message = "Erro: o campo 'nome' não foi informado")
    private String nomeUsuario; //Coluna com validações

    @Column(name = "data_de_nascimento", length = 15)
    @NotNull(message = "Erro, o campo 'data de nascimento' não foi informado")
    private LocalDate dataDeNascimento; //Coluna do tipo localDate

    @Column(name = "email_usuario", length = 50, nullable = false)
    @Email(message = "Erro, 'email' inválido")
    @NotEmpty(message = "Erro, campo 'e-mail' não informado")
    private String email; //Coluna com validações

    @Column(name = "cpf_usuario", length = 14, nullable = false)
    @CPF(message = "Erro, 'cpf' inválido")
    @NotEmpty(message = "Erro, o campo 'cpf' não foi informado")
    private String cpf; //Coluna com validações

    @ManyToOne // Relacionamento muitos para um
    @JoinColumn(name = "endereco_id", referencedColumnName = "codigo") // Junção de tabelas
    private EnderecoModel enderecoModel; // foreign key


    @JsonIgnore // Mapeamento um para muitos
    @OneToMany(mappedBy = "usuarioModel", cascade = CascadeType.ALL)
    private List<ContasReceberModel> contasReceberModel = new ArrayList<>();
}
