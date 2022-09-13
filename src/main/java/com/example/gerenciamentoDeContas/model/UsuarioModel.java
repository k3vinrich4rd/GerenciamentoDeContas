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
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @NotBlank(message = "Erro, e-mail não informado")
    private String email;

    @Column(name = "cpf_usuario", length = 14, nullable = false)
    @CPF(message = "Cpf inválido")
    @NotBlank(message = "Erro, cpf não informado")
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "usuarioModel", cascade = CascadeType.ALL)
    private List<EnderecoModel> enderecoModel = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuarioModel", cascade = CascadeType.ALL)
    private List<ContasReceberModel> contasReceberModel = new ArrayList<>();
}
