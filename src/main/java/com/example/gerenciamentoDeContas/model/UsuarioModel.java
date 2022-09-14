package com.example.gerenciamentoDeContas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

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
    private Long codigo;

    @Column(name = "nome_usuario", length = 55, nullable = false)
    private String nomeUsuario;

    @Column(name = "data_de_nascimento", length = 15, nullable = false)
    private LocalDate dataDeNascimento;

    @Column(name = "email_usuario", length = 50, nullable = false)
    @Email(message = "Erro, email inválido")
    @NotEmpty(message = "Erro, e-mail não informado")
    private String email;

    @Column(name = "cpf_usuario", length = 14, nullable = false)
    @CPF(message = "Cpf inválido")
    @NotEmpty(message = "Erro, cpf não informado")
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "codigo")
    private EnderecoModel enderecoModel;


//    @JsonIgnore
//    @OneToMany(mappedBy = "usuarioModel", cascade = CascadeType.ALL)
//    private List<ContasReceberModel> contasReceberModel = new ArrayList<>();
}
