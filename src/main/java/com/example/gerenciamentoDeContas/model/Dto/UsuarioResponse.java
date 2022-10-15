package com.example.gerenciamentoDeContas.model.Dto;

import com.example.gerenciamentoDeContas.model.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
//Métodos assessores, modificadores, construtor e construtor vazio

@Getter
@Setter
@AllArgsConstructor

//Classe Dto (criada para aparecer somente os métodos abaixo, quando fazer a requisição de busca
// para visualizar um usuário
public class UsuarioResponse {

    private UUID codigo;
    private String nomeUsuario;
    private LocalDate dataDeNascimento;
    private String email;

    public UsuarioResponse(String nomeUsuario, LocalDate dataDeNascimento, String email, LocalDate dataDeNascimento1) {
    }
}
