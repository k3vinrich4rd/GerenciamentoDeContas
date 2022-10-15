package com.example.gerenciamentoDeContas.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class UsuarioRequest {

    @NotBlank(message = "Erro: o campo 'nome' não foi informado")
    private String nomeUsuario; //Coluna com validações

    @NotNull(message = "Erro, o campo 'data de nascimento' não foi informado")
    private LocalDate dataDeNascimento; //Coluna do tipo localDate

    @Email(message = "Erro, 'email' inválido")
    @NotEmpty(message = "Erro, campo 'e-mail' não informado")
    private String email; //Coluna com validações

    @CPF(message = "Erro, 'cpf' inválido")
    @NotEmpty(message = "Erro, o campo 'cpf' não foi informado")
    private String cpf; //Coluna com validações
}
